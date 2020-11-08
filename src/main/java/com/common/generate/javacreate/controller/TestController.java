package com.common.generate.javacreate.controller;

import com.common.generate.javacreate.model.WebsocketMsgDTO;
import com.common.generate.javacreate.utils.HtmlToImageUtil;
import com.common.generate.javacreate.utils.WebSocket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xialei
 * @date 2020/9/2 10:51
 */
@RestController
public class TestController {
    @Resource
    private WebSocket webSocket;

    @GetMapping("/test1")
    public void test1() {
        //创建业务消息信息
        WebsocketMsgDTO msgDTO =new WebsocketMsgDTO();
        msgDTO.setType("topic");
        msgDTO.setMsgId(1L);
        msgDTO.setMsgTxt("全体测试消息");
        //全体发送
        webSocket.sendAllMessage(msgDTO);
    }

    @GetMapping("/test2")
    public void test2(HttpServletResponse response) {
        //创建业务消息信息
        WebsocketMsgDTO msgDTO =new WebsocketMsgDTO();
        msgDTO.setType("topic");
        msgDTO.setMsgId(1L);
        msgDTO.setMsgTxt("全体测试消息");
        //单个用户发送 (userId为用户id)
        webSocket.sendOneMessage("1111", msgDTO);
    }

    @GetMapping("/test3")
    public void test3(HttpServletResponse response) {
        //创建业务消息信息
        WebsocketMsgDTO msgDTO =new WebsocketMsgDTO();
        msgDTO.setType("topic");
        msgDTO.setMsgId(1L);
        msgDTO.setMsgTxt("全体测试消息");
        List<String> userIds =new ArrayList<>();
        userIds.add("1111");
        userIds.add("2222");
        webSocket.sendMoreMessage(userIds, msgDTO);
    }


    @GetMapping("/getImage")
    public void getImage(HttpServletResponse response) {
        String headHtml = "<!DOCTYPE html>\n" +
                "<html lang=\"zh-CN\"><!--100*150,90-->\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <style>        * {\n" +
                "        margin: 0;\n" +
                "        padding: 0;\n" +
                "        font-family: \"simsun\";\n" +
                "    }\n" +
                "\n" +
                "    .print_paper {\n" +
                "        font-size: 14px;\n" +
                "        border: none;\n" +
                "        border-collapse: collapse;\n" +
                "        width: 375px;\n" +
                "        margin-top: -1px;\n" +
                "        table-layout: fixed;\n" +
                "    }\n" +
                "\n" +
                "    .print_paper td {\n" +
                "        border: solid #000 1px;\n" +
                "        padding: 0 5px;\n" +
                "    }\n" +
                "\n" +
                "    .table_first {\n" +
                "        margin-top: 0;\n" +
                "    }\n" +
                "\n" +
                "    .print_paper .x1 {\n" +
                "        font-size: 32px;\n" +
                "        font-weight: bold;\n" +
                "        text-align: center;\n" +
                "        letter-spacing: 5px;\n" +
                "        line-height: 0.95;\n" +
                "        font-family: \"Microsoft YaHei\";\n" +
                "    }\n" +
                "\n" +
                "    .print_paper .x4 {\n" +
                "        font-size: 20px;\n" +
                "        font-weight: bold;\n" +
                "        font-family: \"Microsoft YaHei\";\n" +
                "    }\n" +
                "\n" +
                "    .print_paper .xx8 {\n" +
                "        font-size: 8px;\n" +
                "        line-height: 0.8;\n" +
                "    }\n" +
                "\n" +
                "    .print_paper .xx10 {\n" +
                "        font-size: 10px;\n" +
                "    }\n" +
                "\n" +
                "    .print_paper .xx12 {\n" +
                "        font-size: 12px;\n" +
                "        font-weight: bold;\n" +
                "    }\n" +
                "\n" +
                "    .print_paper .xx14 {\n" +
                "        font-size: 14px;\n" +
                "        font-weight: bold;\n" +
                "        font-family: \"SimHei\";\n" +
                "    }\n" +
                "\n" +
                "    .print_paper .xx16 {\n" +
                "        font-size: 16px;\n" +
                "        font-weight: bold;\n" +
                "        font-family: \"Microsoft YaHei\";\n" +
                "    }\n" +
                "\n" +
                "    .print_paper .xx48 {\n" +
                "        font-size: 40px;\n" +
                "        font-weight: bold;\n" +
                "        text-align: center;\n" +
                "        font-family: \"Microsoft YaHei\";\n" +
                "    }\n" +
                "\n" +
                "    .no_border {\n" +
                "        width: 100%;\n" +
                "        height: 100%;\n" +
                "        font-size: 14px;\n" +
                "    }\n" +
                "\n" +
                "    .no_border td {\n" +
                "        border: none;\n" +
                "        vertical-align: top;\n" +
                "    }\n" +
                "\n" +
                "    .print_paper .fwb {\n" +
                "        font-weight: bold;\n" +
                "    }\n" +
                "\n" +
                "    .print_paper .f24 {\n" +
                "        font-family: \"Arial\";\n" +
                "        font-size: 24pt;\n" +
                "    }\n" +
                "\n" +
                "    .print_paper .f20 {\n" +
                "        font-family: \"Arial\";\n" +
                "        font-size: 20pt;\n" +
                "    }\n" +
                "\n" +
                "    .print_paper .p0 {\n" +
                "        padding: 0;\n" +
                "    }\n" +
                "\n" +
                "    /*增加类*/\n" +
                "    .print_paper .p0 .sp {\n" +
                "        position: absolute;\n" +
                "        left: 3px;\n" +
                "        top: 110px;\n" +
                "    }\n" +
                "\n" +
                "    .print_paper .ovh {\n" +
                "        overflow: hidden;\n" +
                "    }\n" +
                "\n" +
                "    .print_paper .ov {\n" +
                "        overflow: visible;\n" +
                "    }\n" +
                "\n" +
                "    .print_paper .f10 {\n" +
                "        font-size: 10px;\n" +
                "    }\n" +
                "\n" +
                "    .print_paper .f13 {\n" +
                "        font-size: 13px;\n" +
                "    }\n" +
                "\n" +
                "    .print_paper .bln {\n" +
                "        border-left: none;\n" +
                "    }\n" +
                "\n" +
                "    .print_paper .brn {\n" +
                "        border-right: none;\n" +
                "    }    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<table class=\"print_paper table_first\">\n" +
                "    <tr height=\"53\">\n" +
                "        <td>\n" +
                "            <table class=\"no_border\">\n" +
                "                <tr>\n" +
                "                    <td style=\"vertical-align: middle;\"><img class=\"logo\" height=\"35\" alt=\"\"\n" +
                "                                                             src=\"data:image/png;base64,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\"/>\n" +
                "                    </td>\n" +
                "                    <td style=\"vertical-align: middle;\" colspan=\"2\">                        <!--&nbsp;-->\n" +
                "                        <div class=\"f20\" style=\"font-weight: bold;\">&nbsp;&nbsp;&nbsp;&nbsp;</div>\n" +
                "                    </td>                    <!--<td style=\"vertical-align:middle;\">&nbsp;</td>-->\n" +
                "                    <td style=\"vertical-align: middle; text-align: right; position: absolute; left: 264px\"><img\n" +
                "                            height=\"35\" class=\"phone\" alt=\"\"\n" +
                "                            src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAKAAAAA8CAMAAADWtUEnAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAABhQTFRFIiIi1NTUjo6OsbGxYWFh7u7uAAAA////lVpTKwAABPNJREFUeNrsWYvO8yYM9Y30/d94NgZig5t+0/5NlfZFqpKcgDm+gA2F15df8Evwl+D3EUQi0YuIv5MgClx+CX8fQRaBye+6AITaVxFEufaLzj7UW0n8kvstoUyuLSUpNTrlAuFbggwHvwtksyHdn/CZIAZxsMKlRtPgcchIEAt+1jzxS1TwkSCXrqjRoHdWHXYViA6aUaGNCf6c4NTmRygUBN1+tOmyxSEvz1Cybu+7zyfWeGq3ceQJhfky3EgnwT624GGO5GS57UbRAF3qPpk4exUeUL7HaZBMuB6aLOJtd/KK5Ra1g8A9u+VcK65KgYBGbaUmSGHs04QpUvC1C2ofCEpJUHaCr+P5Jjis5uvy2yj0Dy2y7S/4E4LwgAZZPshhQQzObPJuqSkI4h2/H1wsD2jb/XdMEg5M+HommPzNeZHY8kD0JT+htGYf1csMhXUJi3wSOVEcgI6YOFKPFOv9gY5XX4WLhZqi+NPF0IInoIWgOAnOxhmnKllGVK7HVEfRm2fOm2PKitSZOguCt1loOb4V2Tyjd+SnMu8kaE4+VsKpEz5WOzjTJJ6FRWnBgFK1rBWTZARAf4UHm6zPOfQRUnMqQ7NCh/lGDIYgLAh2f6oHhaRIdnynl1zQFFkt23UrPW+0pczOeUCoSi1TC9XMy2VxCrYOarmK7/PXtiY3qGrfiMZelDwDR4gmC4+pANXuhD+lh2Cu6xnlzCnVSXU1vQKmmwvKnYmUOwIoaX9AUwJ4Q3CvOTlYForsMDyEfyOr/UOC2+IHbO1bN6y8LQCOL1TutFrp4htNvdpVEzxKBCBmeRuBKZRp09IriK3OHZO0QjFmA0k6QrVjv/fFB79RDGyZVOXxitgJ84auwqdA7ww1dr4rXcLzrviwX510y7zIZUVUo0dypXJffNrw8G9dFJRbPS4TdI3uW3J6c7LQ9q07yDZN6/1yWSlgqSe+0T66Lxpln1kcjVgczfCMPtoOxGYuTWXLjMl0UFajK/lBhovTLeUAeolUxfF3HGAi64Xt9fpWgr9HwL8Efwn+CYKWndo3E9RNi3y1BQH+axezpVHREg8vzXc43ynAsxIExLwZBXtBKx9IK1BNQ55Q5RIrSMXTv6VbWbdZ+1ltYf37aYCNDCyhiI/1oMkClUSXJlzqQ+lYEXZ+ICBN7E+UVbxqYtRB7QeqitEVq/SkJ22FxWFFcd6cn8kyla09W6ljD1eXdrpYzWYtzFzUbxdjH3LBLpR6CR1cDKavvjcznbg6vV1/6xqqoGZ3buM2FDPPdaVeNiS7vSVIh7TL0KIEYAylN3unCA8P9xrMXntxx20UP617vw3pOHXieUAGftQB68RDxpGz71a0F7tm/IYgmytoBp0+QPdFhOduZOiI9q8jNvOwSDdWbxQIoou1Pyd78KmtcYXY8HRzyZ8JvqzIUrn+X4R6VuMDMrwotuzi5YPuLZtiLzc+jsm3qlK5bzOqb4U+ERSbbHC5VLU7uUFu2DyvltItcSJo4zWxYAefWTaloU+SHgzaHYGbzlN1w7qBRac+y+ivrT4RJI9Rj4irn75QgtFZXymM55aHOydwZbyNE5zHuxBvONefzn60/0SwSV+tfFdoM4Fkg+0PSpb1eNtQpGmT3o5sVnsb9iMUFF+RxHOP33r/+YW8vZ1YaScM0v+VdPAnk8z/kyDRbz34PddfAgwAfP7m2QIPxogAAAAASUVORK5CYII=\"/>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "<table class=\"print_paper\">\n" +
                "    <tr height=\"65\">\n" +
                "        <td class=\"p0\" width=\"249\" style=\"text-align: center;\"><img width=\"249px\"\n" +
                "                                                                    src=\"data:image/gif;base64,R0lGODlh+gAtAPAAAAAAAP///ywAAAAA+gAtAEAI/wADCBxIsKDBgQASAhCYkKBChQ4fLkQ48WFEiwEwSqw4kSFEiholevTYsGDJiBc7ZvxI8uPJlS9LvkxpcONImCoP6tzJk2fIlDFFUmwJlKNMoUGTukRqNOfKmioxEgW5lObQpwelUj06tafXrz6rbo0q9KZWmzhbcqVaVC3HrldRsp3r9ibctVBn4lyrFaxfvz/Htr16lunRwHcNi+2LVW5ipXjTEnYKty5Wxn8z70S8l2zhx0sPiwUtmi/LuKgLQ35L9zJlyYNFa57dkzNay2ZPow1pW7di03qDex4em/hknYx3N6XNPOvozoNzr56q3Krl6rBR282u+vnnxiZPX/9f3rw89eHTJ6fn7d03e+BOhVvnznR+5PnjK5uf3bt7UNLkYQdgftltt113xdnHWl7x1Vfgfpr1555vA0omIH3vsZZcgwquZ1xuyIkHnWt6QfiXhOlJh16ADlaI3YZQdbjigRSCh9+IsplIG4ozqtdjhjR6GBiM4cmYYGv3tUYgZjp+xWN0JP4YWntCLiaifEhOGNl3JT74oohNOkmllmS5OOWWZC55JYdZeqiggUriSF6YJ46ZYpTFlbYghmdquGaMbUr5po1xftklnZvZ2aOKeTaFZpXwAeoYn0cmBqd+hr6GaIiPpuljowSaOeSfRQZaKX2Xeukgk5s61+mdOY7/p2eQUo6K5aQICgYel69taKumrYb36qJ46grkrp5mKmlqE57KK6cN/hqsmMNCGaucsyILqZ+3MquUszV26auVh047F6xlFSuro3v6xy6jpeLarLEfugYtg5GaG1a1usK7bqh8ZnstnN8G2qlc4q4prb6J8oubuti+q22t5LIpb8EAP+tqtBUz3HC76d4GsXIC10tyx/F6a3KLqBKK6apgemwhsSJfe3LGycLcLa0yHnzcxvhyC6y+T/Y7smI4b+uvdhP3DPJ/Lqu6sMzCPu3p0jfL6bSaOzdtsNUI96owylRbhS6vVSZNcb6T8vy12yACXTXbZZ9nbchzRqx2o3QT/7yym1mmOm7fZRf9sM1Ia/224kRe/PeYYd87t9B1m00z3qJKjHHEhHeb694/Mxj00nUbPiLWiV/oLtcWq7y113GLPjnphSt6d+agr9t5658rbmnUg1Neud1G15x31qrnPDXTm68Ou71yH8kqw6Ybj7vvAWuet99G0jtowsItX7rtxR+fOsvOK5sy3Nmzn+TL4tfu8OlHs5c758K3/Xz6Kws+NuFUqx7m2jczCfEtf8x7HLigBj6OAVBmAkQbxe53st0tq3fJY6DYwke2ykUwXMrT3uvUp7/m5ex7G3QgAsc3P+sR8FgmhOH2CBVDQQUOeP9bofyshq7rZXBtOvTcvEQouKcbkdCD5Duc+eyHPf7FT4g19FnsqjY6iLGQh5fzIfpCaMGUYXCLGpSc9GLmsQ9qMG1N5GIQeTfENIYxet57kGYCAgA7\"/>\n" +
                "            <span class=\"sp\" style=\"font-size: 11px;display: none\">1&nbsp;/&nbsp;1</span> <br/>\n" +
                "            <div style=\"font-size: 11px; font-weight: bold;\"><span\n" +
                "                    style=\"display: none\">子单号&nbsp;&nbsp;252314540522<br/>母单号&nbsp;&nbsp;252314540522</span> <span\n" +
                "                    style=\"display: block;margin-top: 3px;\">运单号&nbsp;&nbsp;252314540522</span> <span\n" +
                "                    style=\"display: none;margin-top: 10px;\">签回单号&nbsp;&nbsp;252314540522</span></div>\n" +
                "        </td>\n" +
                "        <td class=\"xx16 p0\">\n" +
                "            <div style=\"height: 74px;\"> 顺丰标快 <br/> <span class=\"xx10\">目的地：</span>\n" +
                "                <div class=\"f24\">020</div>\n" +
                "            </div>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "<table class=\"print_paper\" height=\"50\">\n" +
                "    <tr>\n" +
                "        <td width=\"50\" style=\"padding: 0;\" class=\"xx16 brn\">收方:</td>\n" +
                "        <td class=\"bln\">\n" +
                "            <div style=\"height: 59px; overflow: hidden;\"> 上海市上海市徐汇区上海市徐汇区湖南路街道淮海中路966号上海市徐汇区中心医院<br/> <span\n" +
                "                    style=\"width: 297px;display: inline-block;\">吴小辉&nbsp;&nbsp;13667132550</span></div>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "<table class=\"print_paper\" height=\"58\">\n" +
                "    <tr>\n" +
                "        <td rowspan=\"2\" style=\"vertical-align: top;\" class=\"f13\"> 月结帐号： <br/> 支付方式：寄付现结 <br/>\n" +
                "            <div style=\"display: none\">声明价值：0</div>\n" +
                "            <div style=\"display: none\">签单返回单号：${SignWaybillCode}</div>\n" +
                "            <div style=\"display: none\">操作要求：${OperateRequire}</div>\n" +
                "        </td>\n" +
                "        <td height=\"45\">代收货款：￥0元<br/>卡号：</td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "        <td>运费：-<br/>费用合计：-</td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "<table class=\"print_paper\" height=\"68\" width=\"100%\">\n" +
                "    <tr>\n" +
                "        <td class=\"xx14 brn\" width=\"50\" style=\"padding: 0; \"> 寄方:</td>\n" +
                "        <td class=\"ov bln\" style=\"width: 136px;\">\n" +
                "            <div class=\"xx10\" style=\"width: 115px; height: 66px;\">\n" +
                "                <div style=\"height: 40px; overflow: hidden\"> 上海市上海市松江区上海市上海市松江区叶榭镇</div>\n" +
                "                <div style=\"width: 140px;overflow: hidden;\"><span style=\"width: 52px;display: inline-block;\">下测试</span>13399123456\n" +
                "                </div>\n" +
                "                <div class=\"xx10\" style=\"margin-left: -45px; position: absolute;top: 337px;\">原寄地：755</div>\n" +
                "            </div>\n" +
                "        </td>\n" +
                "        <td class=\"xx10\" width=\"86\">收件员：<br/>寄件日期：2020-08-07 18:06:52</td>\n" +
                "        <td class=\"xx10\">收方签署:<br/> <br/>日期：</td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "<table class=\"print_paper table_first\" height=\"60\">\n" +
                "    <tr height=\"55\">\n" +
                "        <td><img class=\"logo\" height=\"30\"\n" +
                "                 src=\"data:image/png;base64,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\"\n" +
                "                 alt=\"\"/> <img class=\"phone\" height=\"30\"\n" +
                "                               src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAKAAAAA8CAMAAADWtUEnAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAABhQTFRFIiIi1NTUjo6OsbGxYWFh7u7uAAAA////lVpTKwAABPNJREFUeNrsWYvO8yYM9Y30/d94NgZig5t+0/5NlfZFqpKcgDm+gA2F15df8Evwl+D3EUQi0YuIv5MgClx+CX8fQRaBye+6AITaVxFEufaLzj7UW0n8kvstoUyuLSUpNTrlAuFbggwHvwtksyHdn/CZIAZxsMKlRtPgcchIEAt+1jzxS1TwkSCXrqjRoHdWHXYViA6aUaGNCf6c4NTmRygUBN1+tOmyxSEvz1Cybu+7zyfWeGq3ceQJhfky3EgnwT624GGO5GS57UbRAF3qPpk4exUeUL7HaZBMuB6aLOJtd/KK5Ra1g8A9u+VcK65KgYBGbaUmSGHs04QpUvC1C2ofCEpJUHaCr+P5Jjis5uvy2yj0Dy2y7S/4E4LwgAZZPshhQQzObPJuqSkI4h2/H1wsD2jb/XdMEg5M+HommPzNeZHY8kD0JT+htGYf1csMhXUJi3wSOVEcgI6YOFKPFOv9gY5XX4WLhZqi+NPF0IInoIWgOAnOxhmnKllGVK7HVEfRm2fOm2PKitSZOguCt1loOb4V2Tyjd+SnMu8kaE4+VsKpEz5WOzjTJJ6FRWnBgFK1rBWTZARAf4UHm6zPOfQRUnMqQ7NCh/lGDIYgLAh2f6oHhaRIdnynl1zQFFkt23UrPW+0pczOeUCoSi1TC9XMy2VxCrYOarmK7/PXtiY3qGrfiMZelDwDR4gmC4+pANXuhD+lh2Cu6xnlzCnVSXU1vQKmmwvKnYmUOwIoaX9AUwJ4Q3CvOTlYForsMDyEfyOr/UOC2+IHbO1bN6y8LQCOL1TutFrp4htNvdpVEzxKBCBmeRuBKZRp09IriK3OHZO0QjFmA0k6QrVjv/fFB79RDGyZVOXxitgJ84auwqdA7ww1dr4rXcLzrviwX510y7zIZUVUo0dypXJffNrw8G9dFJRbPS4TdI3uW3J6c7LQ9q07yDZN6/1yWSlgqSe+0T66Lxpln1kcjVgczfCMPtoOxGYuTWXLjMl0UFajK/lBhovTLeUAeolUxfF3HGAi64Xt9fpWgr9HwL8Efwn+CYKWndo3E9RNi3y1BQH+axezpVHREg8vzXc43ynAsxIExLwZBXtBKx9IK1BNQ55Q5RIrSMXTv6VbWbdZ+1ltYf37aYCNDCyhiI/1oMkClUSXJlzqQ+lYEXZ+ICBN7E+UVbxqYtRB7QeqitEVq/SkJ22FxWFFcd6cn8kyla09W6ljD1eXdrpYzWYtzFzUbxdjH3LBLpR6CR1cDKavvjcznbg6vV1/6xqqoGZ3buM2FDPPdaVeNiS7vSVIh7TL0KIEYAylN3unCA8P9xrMXntxx20UP617vw3pOHXieUAGftQB68RDxpGz71a0F7tm/IYgmytoBp0+QPdFhOduZOiI9q8jNvOwSDdWbxQIoou1Pyd78KmtcYXY8HRzyZ8JvqzIUrn+X4R6VuMDMrwotuzi5YPuLZtiLzc+jsm3qlK5bzOqb4U+ERSbbHC5VLU7uUFu2DyvltItcSJo4zWxYAefWTaloU+SHgzaHYGbzlN1w7qBRac+y+ivrT4RJI9Rj4irn75QgtFZXymM55aHOydwZbyNE5zHuxBvONefzn60/0SwSV+tfFdoM4Fkg+0PSpb1eNtQpGmT3o5sVnsb9iMUFF+RxHOP33r/+YW8vZ1YaScM0v+VdPAnk8z/kyDRbz34PddfAgwAfP7m2QIPxogAAAAASUVORK5CYII=\"\n" +
                "                               alt=\"\"/></td>\n" +
                "        <td style=\"text-align: center;\"><img\n" +
                "                src=\"data:image/gif;base64,R0lGODlhsQAlAPAAAAAAAP///ywAAAAAsQAlAEAI/wADCBxIsKDBgwgFAgAQgGHDhQohNnwYkSHEhRYjVnyYUeJEhRopcvwoMeNAjxgnekzIsqXLlzAJXtw4UqXDlBdnisQ5E+XJkCV1lvwYcqRFhzGTKl2KUGjQmztzGgWasyPSq1Q33oSKVOTUlUzDinXpdCtXsxRxUj1q9SfIqFqBEvWqFuzYu3g1oq15VCtbkmjrYn0bNO7OuSh7ds3LWGxZmn2N/t3qt+1bwGsxq5R5VXHjz45NpuQbta/a0l8Ha366GnFny6Bjx3xMmnXV1bcjE6WMmrfJooJlC39Je3RknlN7e77sO7DcrolhD59usPhQ25MzB2eeNfl1zieXU/8fHx7w3uNST2OHPbiwd67g49olP9z6Wb/vK9t0i9vw9/LyLUZffaKxtp9k+UnGnlvuqQcfgKkNSJ59IGGXIE8LEtZcgRXGF6GE1FF4IHIO6qdbexu2Bt1rB4JIoHmQKXdhbnQxmKJvroUnnYuxiYieaU6ZWKOG2j3n4XY8yuajjCUq2CKKRR62oo4tJgnakhY2ieGTNkb5H3DiWfkZloFlp1yG/V2YY4Bi9ljgeUwG6eSJXfZmJIRItskYmfhpSaNPRNop5ZFh6okXnwj6mR2gaWq55oeG5oUoiXJuSWegtt0J5o6RhgZjbWXOuKhqzfn34KZVdurpedeFqiikUAqi+iVdharK1KTpVfonqd05OiWbto6FK5Aczjlko5U+mmewSw2blq6j8leqmr9Cymyzb8aYJbSw1pnpoHjWei1MztJ4JpeYOgcuqrqNm1S5Zq6HLrLF/kYrp+6SlS2ofXKLZKzfzhpdqvnq+6lxcda7q7S9JlvtsgW3BK+o3aZraofh4htxU/sivK3C0XIHF7WEarxxdR232i/IFdOrYskECxcQADs=\"/>\n" +
                "            <span style=\"display: none\">子单号&nbsp;252314540522</span> <span style=\"display: block\">252314540522</span>\n" +
                "            <span style=\"display: none\">252314540522</span></td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "<table class=\"print_paper \">\n" +
                "    <tr height=\"76\">\n" +
                "        <td class=\"brn\" style=\"padding: 0; width: 16px;\">寄<br/>方:</td>\n" +
                "        <td class=\"xx10 bln\">\n" +
                "            <div style=\"height: 67px; overflow: hidden;\"> 上海市上海市松江区上海市上海市松江区叶榭镇<br/> <span\n" +
                "                    style=\"width: 164px;display: inline-block;\">                    <span\n" +
                "                    style=\"width: 52px;display: inline-block;\">下测试</span>13399123456                </span></div>\n" +
                "        </td>\n" +
                "        <td style=\"padding: 0; width: 16px;\" class=\"fwb brn\">收<br/>方:</td>\n" +
                "        <td class=\"xx10 bln\">\n" +
                "            <div style=\"height: 67px; overflow: hidden\"> 上海市上海市徐汇区上海市徐汇区湖南路街道淮海中路966号上海市徐汇区中心医院<br/> <span\n" +
                "                    style=\"width: 164px;display: inline-block;\">                    <span\n" +
                "                    style=\"width: 52px;display: inline-block;\">吴小辉</span>13667132550                </span></div>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "<table class=\"print_paper\">\n" +
                "    <tr height=\"18\">\n" +
                "        <td width=\"36\" style=\"padding: 0; text-align: center;\">数量</td>\n" +
                "        <td width=\"254\" style=\"padding: 0; text-align: center;\">托寄物</td>\n" +
                "        <td style=\"padding: 0; text-align: center;\">备注</td>\n" +
                "    </tr>\n" +
                "    <tr height=\"34\">\n" +
                "        <td>&nbsp;</td>\n" +
                "        <td>洋河天之蓝52度480ml等</td>\n" +
                "        <td>\n" +
                "            <div class=\"f10 ovh\" style=\"height: 33px\"></div>\n" +
                "        </td>\n" +
                "    </tr>\n" +
                "    <tr height=\"40\">\n" +
                "        <td colspan=\"2\">\n" +
                "            <table class=\"no_border\">\n" +
                "                <tr>\n" +
                "                    <td>订单号</td>\n" +
                "                    <td class=\"xx14\" style=\"vertical-align: middle; text-align: center;\"><br/>103022000017</td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "        </td>\n" +
                "        <td style=\"text-align: center;\">费用合计：<br/>- 元</td>\n" +
                "    </tr>\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>";
        HtmlToImageUtil.toImage(headHtml, response);
    }


//    public void m() {
//        HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
//
//
//        String htmlstr = "<table style=\"width: 700px;font-size:16px;font-family: 'Microsoft YaHei';\" cellpadding=\"0\" cellspacing=\"0\">\n" +
//                "    <tr >\n" +
//                "      <th  style=\"background-color: #f2f2f2;height: 30px;width:  700px; border:1px solid #e6e6e6;border-top:none;text-align: center;color: #333333;\" colspan=\"2\">收据</th>\n" +
//                "    </tr>\n" +
//                "    <tr style=\"width:  700px;\">\n" +
//                "      <td style=\"border:1px solid #e6e6e6;border-top:none;text-align: center;color: #666666;height: 30px;\" >日期</td>\n" +
//                "      <td  style=\"border:1px solid #e6e6e6;border-top:none;text-align: center;color: #666666;border-left: 0px;height: 30px;\">" + DateUtil.format(saleOrder.getCreateTime(), "yyyy-MM-dd HH:mm:ss") + "</td>\n" +
//                "    </tr>\n" +
//                "    <tr style=\"width:  700px;\">\n" +
//                "      <td  style=\"border:1px solid #e6e6e6;border-top:none;text-align: center;color: #666666;height: 30px;\">交易编号</td>\n" +
//                "      <td  style=\"border:1px solid #e6e6e6;border-top:none;text-align: center;color: #666666;border-left: 0px;height: 30px;\">" + saleOrder.getOrderCode() + "</td>\n" +
//                "    </tr>\n" +
//                "    <tr style=\"width:  700px;\">\n" +
//                "      <td  style=\"border:1px solid #e6e6e6;border-top:none;text-align: center;color: #666666;height: 30px;\">交易类型</td>\n" +
//                "      <td  style=\"border:1px solid #e6e6e6;border-top:none;text-align: center;color: #666666;border-left: 0px;height: 30px;\">捐赠</td>\n" +
//                "    </tr>\n" +
//                "    <tr style=\"width:  700px;\">\n" +
//                "      <td  style=\"border:1px solid #e6e6e6;border-top:none;text-align: center;color: #666666;height: 30px;\">交易金额</td>\n" +
//                "      <td  style=\"border:1px solid #e6e6e6;border-top:none;text-align: center;color: #666666;border-left: 0px;height: 30px;\">" + saleOrder.getProductPrice() + "</td>\n" +
//                "    </tr>\n" +
//                "   <tr style=\"width:  700px;\">\n" +
//                "      <td  style=\"border:1px solid #e6e6e6;border-top:none;text-align: center;color: #666666;height: 30px;\">付款人</td>\n" +
//                "      <td  style=\"border:1px solid #e6e6e6;border-top:none;text-align: center;color: #666666;border-left: 0px;height: 30px;\">" + saleOrder.getUserName() + "</td>\n" +
//                "    </tr>" +
//                "</table>";
//        imageGenerator.loadHtml(htmlstr);
//        BufferedImage bufferedImage = getGrayPicture(imageGenerator.getBufferedImage());
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        try {
//            ImageIO.write(bufferedImage, "jpg", outputStream);
//            String base64Img = Base64.encodeBase64String(outputStream.toByteArray());
//            String res = "data:image/jpg;base64," + base64Img.toString();
//            modelAndView.addObject("imageres", res);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (outputStream != null) {
//                try {
//                    outputStream.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//    }

}
