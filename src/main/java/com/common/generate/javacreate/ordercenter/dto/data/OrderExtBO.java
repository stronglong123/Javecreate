package com.common.generate.javacreate.ordercenter.dto.data;

import com.common.generate.javacreate.service.impl.es.ApiModel;
import com.common.generate.javacreate.service.impl.es.ApiParam;

import java.util.Date;

/**
 * @ClassName OrderExtBO
 * @Description oms订单扩展
 * @Author hhw
 * @Date 2022/5/11 14:06
 * @Version 1.0
 **/
@ApiModel(description = "oms订单扩展模型")
public class OrderExtBO {
    @ApiParam(description = "id")
    private Long id;
    @ApiParam(description = "orderId")
    private Long order_Id;

    /**
     * 扩展类型1=拆分单...
     */
    @ApiParam(description = "扩展类型1")
    private Integer extType;
    @ApiParam(description = "扩展类型2")
    private String ext1;
    @ApiParam(description = "扩展类型3")
    private String ext2;
    @ApiParam(description = "扩展类型4")
    private String ext3;
    @ApiParam(description = "扩展类型5")
    private String ext4;
    @ApiParam(description = "扩展类型6")
    private String ext5;
    @ApiParam(description = "扩展类型7")
    private String ext6;
    @ApiParam(description = "扩展类型8")
    private String ext7;
    @ApiParam(description = "扩展类型9")
    private String ext8;
    @ApiParam(description = "扩展类型10")
    private String ext9;
    @ApiParam(description = "扩展类型11")
    private String ext10;
    @ApiParam(description = "扩展类型12")
    private String ext11;
    @ApiParam(description = "扩展类型13")
    private String ext12;
    @ApiParam(description = "扩展类型14")
    private String ext13;
    @ApiParam(description = "扩展类型15")
    private String ext14;
    @ApiParam(description = "扩展类型16")
    private String ext15;
    @ApiParam(description = "扩展类型17")
    private String ext16;
    @ApiParam(description = "扩展类型18")
    private String ext17;
    @ApiParam(description = "扩展类型19")
    private String ext18;
    @ApiParam(description = "扩展类型20")
    private String ext19;
    @ApiParam(description = "扩展类型21")
    private String ext20;
    @ApiParam(description = "扩展类型22")
    private Date createTime;
    @ApiParam(description = "扩展类型23")
    private Integer createUser_Id;
    @ApiParam(description = "扩展类型24")
    private Date lastUpdateTime;
    @ApiParam(description = "扩展类型25")
    private Integer lastUpdateUser_Id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrder_Id() {
        return order_Id;
    }

    public void setOrder_Id(Long order_Id) {
        this.order_Id = order_Id;
    }

    public Integer getExtType() {
        return extType;
    }

    public void setExtType(Integer extType) {
        this.extType = extType;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4;
    }

    public String getExt5() {
        return ext5;
    }

    public void setExt5(String ext5) {
        this.ext5 = ext5;
    }

    public String getExt6() {
        return ext6;
    }

    public void setExt6(String ext6) {
        this.ext6 = ext6;
    }

    public String getExt7() {
        return ext7;
    }

    public void setExt7(String ext7) {
        this.ext7 = ext7;
    }

    public String getExt8() {
        return ext8;
    }

    public void setExt8(String ext8) {
        this.ext8 = ext8;
    }

    public String getExt9() {
        return ext9;
    }

    public void setExt9(String ext9) {
        this.ext9 = ext9;
    }

    public String getExt10() {
        return ext10;
    }

    public void setExt10(String ext10) {
        this.ext10 = ext10;
    }

    public String getExt11() {
        return ext11;
    }

    public void setExt11(String ext11) {
        this.ext11 = ext11;
    }

    public String getExt12() {
        return ext12;
    }

    public void setExt12(String ext12) {
        this.ext12 = ext12;
    }

    public String getExt13() {
        return ext13;
    }

    public void setExt13(String ext13) {
        this.ext13 = ext13;
    }

    public String getExt14() {
        return ext14;
    }

    public void setExt14(String ext14) {
        this.ext14 = ext14;
    }

    public String getExt15() {
        return ext15;
    }

    public void setExt15(String ext15) {
        this.ext15 = ext15;
    }

    public String getExt16() {
        return ext16;
    }

    public void setExt16(String ext16) {
        this.ext16 = ext16;
    }

    public String getExt17() {
        return ext17;
    }

    public void setExt17(String ext17) {
        this.ext17 = ext17;
    }

    public String getExt18() {
        return ext18;
    }

    public void setExt18(String ext18) {
        this.ext18 = ext18;
    }

    public String getExt19() {
        return ext19;
    }

    public void setExt19(String ext19) {
        this.ext19 = ext19;
    }

    public String getExt20() {
        return ext20;
    }

    public void setExt20(String ext20) {
        this.ext20 = ext20;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser_Id() {
        return createUser_Id;
    }

    public void setCreateUser_Id(Integer createUser_Id) {
        this.createUser_Id = createUser_Id;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getLastUpdateUser_Id() {
        return lastUpdateUser_Id;
    }

    public void setLastUpdateUser_Id(Integer lastUpdateUser_Id) {
        this.lastUpdateUser_Id = lastUpdateUser_Id;
    }
}
