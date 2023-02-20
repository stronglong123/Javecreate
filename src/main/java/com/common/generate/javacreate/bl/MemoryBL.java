package com.common.generate.javacreate.bl;

import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author xialei
 * @date 2023/1/30 13:42
 */
@Service
public class MemoryBL {


    public static void main(String[] args) {
        Double memoryCurve = getMemoryCurve(0.333);
        System.out.println(memoryCurve);
    }


    /**
     * 设初次记忆后经过了x小时，那么记忆率y近似地满足
     * y=1-0.56(x^0.06)
     *
     * @return
     */
    public static Double getMemoryCurve(double hours) {
        double forgettingCurve = Math.pow(hours, 0.06d) * 0.56;
        double memoryCurve = 1 - forgettingCurve;
        return setScale(memoryCurve, 4);
    }


    private static double setScale(double value, Integer newScale) {
        BigDecimal bigDecimal = BigDecimal.valueOf(value);
        return bigDecimal.setScale(newScale, RoundingMode.HALF_UP).doubleValue();
    }

}
