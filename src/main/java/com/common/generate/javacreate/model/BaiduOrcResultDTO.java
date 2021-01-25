package com.common.generate.javacreate.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author xialei
 * @date 2021/1/16 15:51
 */
public class BaiduOrcResultDTO implements Serializable {
    private static final long serialVersionUID = 1073334029324662432L;

    /**
     * 图像方向，当detect_direction=true时存在。
     * - -1:未定义，
     * - 0:正向，
     * - 1: 逆时针90度，
     * - 2:逆时针180度，
     * - 3:逆时针270度
     */
    private Integer direction;

    /**
     * 唯一的log id，用于问题定位
     */
    private Long log_id;


    /**
     * 识别结果数，表示words_result的元素个数
     */
    private Integer words_result_num;
    /**
     * 定位和识别结果数组
     */
    private List<BaiduOrcWordDTO> words_result;

    private Integer language;

    private String result;

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Long getLog_id() {
        return log_id;
    }

    public void setLog_id(Long log_id) {
        this.log_id = log_id;
    }

    public Integer getWords_result_num() {
        return words_result_num;
    }

    public void setWords_result_num(Integer words_result_num) {
        this.words_result_num = words_result_num;
    }

    public List<BaiduOrcWordDTO> getWords_result() {
        return words_result;
    }

    public void setWords_result(List<BaiduOrcWordDTO> words_result) {
        this.words_result = words_result;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
