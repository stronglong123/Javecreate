package com.common.generate.javacreate.service.impl;

import com.common.generate.javacreate.service.FileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author xialei
 * @date 2020/12/1 13:40
 */

@Service
public class NiuKeService extends FileService {
    @Override
    public String dealText(String line, boolean changeFlag) {
        if (StringUtils.isEmpty(line)) {
            return "";
        }
        line = line.trim();
        StringBuilder builder = new StringBuilder();
        if (line.startsWith("●")) {
            line = line.replace("●", "");
            builder.append("\r\n").append("问题:").append(line);
        } else if (line.startsWith("考察点")) {
            builder.append("\r\n").append(line);
        } else if (line.startsWith("参考回答")) {
            builder.append("\r\n").append(line);
        } else {
            builder.append(line);
        }
        return builder.toString();
    }
}
