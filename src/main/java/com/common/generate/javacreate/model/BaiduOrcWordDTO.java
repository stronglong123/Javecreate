package com.common.generate.javacreate.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author xialei
 * @date 2021/1/16 15:51
 */
public class BaiduOrcWordDTO implements Serializable {
    private static final long serialVersionUID = 1073334029324662432L;

    /**
     * -识别结果字符串
     */
    private String words;

    /**
     * 行置信度信息；如果输入参数 probability = true 则输出
     */
    private List<Probability> probability;

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public List<Probability> getProbability() {
        return probability;
    }

    public void setProbability(List<Probability> probability) {
        this.probability = probability;
    }

    class Probability {
        /**
         * 行置信度平均值
         */
        private Integer average;
        /**
         *行置信度方差
         */
        private Integer variance;
        /**
         * 行置信度最小值
         */
        private Integer min;

        public Integer getAverage() {
            return average;
        }

        public void setAverage(Integer average) {
            this.average = average;
        }

        public Integer getVariance() {
            return variance;
        }

        public void setVariance(Integer variance) {
            this.variance = variance;
        }

        public Integer getMin() {
            return min;
        }

        public void setMin(Integer min) {
            this.min = min;
        }
    }

}
