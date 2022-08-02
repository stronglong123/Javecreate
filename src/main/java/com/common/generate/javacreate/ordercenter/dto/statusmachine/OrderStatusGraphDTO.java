package com.common.generate.javacreate.ordercenter.dto.statusmachine;

import java.io.Serializable;
import java.util.List;

/**
 * 订单状态拓扑图
 *
 * @author Hu Liangzhi
 */
public class OrderStatusGraphDTO implements Serializable {
    private static final long serialVersionUID = 9162414509527908682L;

    /**
     * 接入方应用Code
     */
    private String partnerCode;

    /**
     * 0-公有（public）；1-应用私有（private）,2-内部（inner）
     */
    private Integer visibility;

    /**
     * 单据类型
     */
    private Integer secOrderType;

    /**
     * 状态机id
     */
    private Long machineId;

    /**
     * 状态机名
     */
    private String machineName;

    /**
     * 点集合
     */
    private List<OrderStatusVertexDTO> vertexList;

    /**
     * 边集合
     */
    private List<OrderStatusEdgeDTO> edgeList;

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Integer getSecOrderType() {
        return secOrderType;
    }

    public void setSecOrderType(Integer secOrderType) {
        this.secOrderType = secOrderType;
    }

    public Long getMachineId() {
        return machineId;
    }

    public void setMachineId(Long machineId) {
        this.machineId = machineId;
    }

    public List<OrderStatusVertexDTO> getVertexList() {
        return vertexList;
    }

    public void setVertexList(List<OrderStatusVertexDTO> vertexList) {
        this.vertexList = vertexList;
    }

    public List<OrderStatusEdgeDTO> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(List<OrderStatusEdgeDTO> edgeList) {
        this.edgeList = edgeList;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }
}