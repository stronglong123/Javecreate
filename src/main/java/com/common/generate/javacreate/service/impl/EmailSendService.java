package com.common.generate.javacreate.service.impl;


import com.common.generate.javacreate.model.email.EmailDTO;
import com.common.generate.javacreate.model.email.VerifyEmailDTO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @author xialei
 * @date 2020/5/26 15:32
 */
@Service
public class EmailSendService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSendService.class);

    public boolean sendEmail(EmailDTO emailDTO) {
        if (StringUtils.isEmpty(emailDTO.getTittle())) {
            emailDTO.setTittle("");
        }
        if (StringUtils.isEmpty(emailDTO.getContent())) {
            emailDTO.setContent("");
        }
        Transport ts = null;
        try {
            /**初始化参数配置*/
            Properties prop = initProp(emailDTO.getHost());
            /** 1、创建session*/
            VerifyEmailDTO verifyEmail = new VerifyEmailDTO(emailDTO.getSenderUserName(), emailDTO.getSenderPassword());
            Session session = Session.getInstance(prop, verifyEmail);
            /** 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态*/
            session.setDebug(true);
            /** 2、通过session得到transport对象*/
            ts = session.getTransport();
            /** 3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。*/
            ts.connect(emailDTO.getHost(), emailDTO.getSenderAddress(), emailDTO.getSenderPassword());
            /**  4、创建邮件*/
            Message message = createMail(session, emailDTO);
            /**  5、发送邮件*/
            ts.sendMessage(message, message.getAllRecipients());
            ts.close();
            return true;
        } catch (Exception e) {
            throw new RuntimeException("发送邮件失败:" + e.getMessage());
        } finally {
            try {
                if (null != ts) {
                    ts.close();
                }
            } catch (Exception e) {
                LOGGER.error("关闭Transport出错", e);
            }
        }
    }


    /**
     * 初始化参数配置
     *
     * @param host
     * @return
     */
    private Properties initProp(String host) {
        Properties prop = new Properties();
        prop.setProperty("mail.host", host);
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");
        return prop;
    }

    /**
     * 创建邮件文本
     *
     * @param session
     * @param emailDTO
     * @return
     */
    private MimeMessage createMail(Session session, EmailDTO emailDTO) {
        /** 创建纯文本邮件*/
        if (CollectionUtils.isEmpty(emailDTO.getPhotoSrcs()) && CollectionUtils.isEmpty(emailDTO.getFileList())) {
            return createSimpleMail(session, emailDTO);
        }
        /**创建有图片、附件邮件*/
        return createMixedMail(session, emailDTO);
    }

    /**
     * @Method: createSimpleMail
     * @Description: 创建一封只包含文本的邮件
     */
    private MimeMessage createSimpleMail(Session session, EmailDTO emailDTO) {
        /**创建邮件对象*/
        MimeMessage message = new MimeMessage(session);
        /** 指明邮件的发件人*/
        try {
            message.setFrom(new InternetAddress(emailDTO.getSenderAddress()));
            /** 指明邮件的收件人*/
            message.setRecipients(Message.RecipientType.TO, getReceivers(emailDTO.getReceiveAddress()));
            /** 邮件的标题*/
            message.setSubject(emailDTO.getTittle());
            /** 邮件的文本内容*/
            message.setContent(emailDTO.getContent(), emailDTO.getContextType());
            /** 返回创建好的邮件对象*/
            return message;
        } catch (MessagingException e) {
            throw new RuntimeException("创建邮件失败:" + e.getMessage());
        }

    }

    /**
     * @Method: createMixedMail
     * @Description: 生成一封带附件和带图片的邮件
     */
    private MimeMessage createMixedMail(Session session, EmailDTO emailDTO) {
        MimeMessage message = new MimeMessage(session);
        try {
            /** 设置邮件的基本信息*/
            message.setFrom(new InternetAddress(emailDTO.getSenderAddress()));
            message.setRecipients(Message.RecipientType.TO, getReceivers(emailDTO.getReceiveAddress()));
            message.setSubject(emailDTO.getTittle());
            message.setSentDate(new Date());
            /** 代表正文的bodypart*/
            MimeBodyPart content = new MimeBodyPart();
            /** 描述关系:正文和图片*/
            if (CollectionUtils.isNotEmpty(emailDTO.getPhotoSrcs())) {
                MimeMultipart contentAndImg = new MimeMultipart();
                contentAndImg.setSubType("related");
                StringBuilder imgStr = new StringBuilder();
                for (File photoSrc : emailDTO.getPhotoSrcs()) {
                    /** 准备图片数据*/
                    MimeBodyPart image = new MimeBodyPart();
                    DataHandler dh = new DataHandler(new FileDataSource(photoSrc));
                    image.setDataHandler(dh);
                    image.setContentID(dh.getName());
                    contentAndImg.addBodyPart(image);
                    imgStr.append("<img src='cid:" + dh.getName() + "'>");
                    contentAndImg.addBodyPart(image);
                }
                /** 正文*/
                MimeBodyPart text = new MimeBodyPart();
                text.setContent(emailDTO.getContent() + imgStr.toString(), emailDTO.getContextType());
                contentAndImg.addBodyPart(text);
                content.setContent(contentAndImg);
            } else {
                content.setContent(emailDTO.getContent(), emailDTO.getContextType());
            }

            /** 描述关系:正文和附件*/
            MimeMultipart contentAndFile = new MimeMultipart();
            contentAndFile.addBodyPart(content);
            List<File> fileList = emailDTO.getFileList();
            if (CollectionUtils.isNotEmpty(fileList)) {
                for (File file : fileList) {
                    MimeBodyPart attach = new MimeBodyPart();
                    DataHandler dh = new DataHandler(new FileDataSource(file));
                    attach.setDataHandler(dh);
                    attach.setFileName(dh.getName());
                    contentAndFile.addBodyPart(attach);
                }
                contentAndFile.setSubType("mixed");
            }
            message.setContent(contentAndFile);
            message.saveChanges();
            /** 返回创建好的的邮件*/
            return message;
        } catch (Exception e) {
            throw new RuntimeException("创建邮件失败:" + e.getMessage());
        }
    }

    /**
     * 支持多个多个收件人，逗号分隔
     *
     * @param receiveAddress
     * @return
     */
    private InternetAddress[] getReceivers(String receiveAddress) {
        try {
            String[] addresses = receiveAddress.split(",");
            InternetAddress toAddress[] = new InternetAddress[addresses.length];
            for (int i = 0; i < addresses.length; i++) {
                toAddress[i] = new InternetAddress(addresses[i]);
            }
            return toAddress;
        } catch (AddressException e) {
            throw new RuntimeException("解析收件人失败：" + e);
        }
    }

}
