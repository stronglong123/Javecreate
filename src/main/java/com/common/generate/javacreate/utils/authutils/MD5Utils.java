package com.common.generate.javacreate.utils.authutils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author xialei
 * @date 2020/10/13 16:22
 */
public class MD5Utils {
    private static final Logger LOGGER = LoggerFactory.getLogger(MD5Utils.class);

    public MD5Utils() {
    }

    public static String getMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            StringBuffer buf = new StringBuffer("");

            for(int offset = 0; offset < byteDigest.length; ++offset) {
                int i = byteDigest[offset];
                if (i < 0) {
                    i += 256;
                }

                if (i < 16) {
                    buf.append("0");
                }

                buf.append(Integer.toHexString(i));
            }

            return buf.toString();
        } catch (NoSuchAlgorithmException var6) {
            LOGGER.info("context", var6);
            return null;
        }
    }

}
