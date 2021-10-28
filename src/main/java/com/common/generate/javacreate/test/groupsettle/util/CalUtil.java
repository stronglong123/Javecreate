package com.common.generate.javacreate.test.groupsettle.util;

import com.alibaba.dubbo.common.utils.StringUtils;

import java.math.BigDecimal;

/**
 * @author xialei
 * @date 2021/7/12 10:58
 */
public class CalUtil {

    public static void main(String[] args){
        String text ="130.5+1783.5+87+43.5+174";

        System.out.println(cal(text));

    }



    public static BigDecimal cal(String text){
        String[] split = text.split("\\+");
        BigDecimal totalCount =BigDecimal.ZERO;

        for (String s : split) {
            if(StringUtils.isNotEmpty(s)){
                totalCount =totalCount.add(new BigDecimal(s.trim()));
            }
        }
        return totalCount;
    }
}
