package com.common.generate.javacreate.controller;

import com.common.generate.javacreate.domain.email.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.common.generate.javacreate.service.impl.EmailSendService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author xialei
 * @date 2020/5/27 17:07
 */
@RestController
public class EmailController {

    @Autowired
    private EmailSendService emailSendService;

    @PostMapping("/base/sendMail")
    public boolean sendMail(MultipartFile[] photos,MultipartFile[] files) throws Exception {
        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setSenderPassword("wawdhiztygzhihhc");
        emailDTO.setHost("smtp.qq.com");
        emailDTO.setSenderUserName("1279132832@qq.com");
        emailDTO.setSenderAddress("1279132832@qq.com");
        emailDTO.setReceiveAddress("1492989313@qq.com");
        emailDTO.setContent("测试邮件");
        emailDTO.setTittle("测试邮件发送");

        emailSendService.sendEmail(emailDTO);
        //程序结束时，删除临时文件
//        deleteFile(excelFile);
        return true;
    }



    private void transMultipartFile2File(MultipartFile[] files) throws Exception {
        List<File> fileList = new ArrayList<>();
        for (MultipartFile file : files) {
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 获取文件后缀
            String prefix = fileName.substring(fileName.lastIndexOf("."));
            // 用uuid作为文件名，防止生成的临时文件重复
            final File transFile = File.createTempFile(UUID.randomUUID().toString(), prefix);
            System.out.println(transFile.getName());
            // MultipartFile to File
            file.transferTo(transFile);
            fileList.add(transFile);
        }


    }

    /**
     * 删除
     *
     * @param files
     */
    private void deleteFile(File... files) {
        for (File file : files) {
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
