package com.common.generate.javacreate.ordercenter.dto.statusmachine;

import java.io.Serializable;

/**
 * 订单状态拓扑图-节点
 *
 * @author Hu Liangzhi
 */
public class OrderStatusVertexDTO implements Serializable {
    private static final long serialVersionUID = 9162414509527908682L;

    /**
     * 后台对应每个状态值生成唯一id
     */
    private String id;

    /**
     * 状态值
     */
    private Integer statusValue;

    /**
     * 状态名
     */
    private String statusName;

    /**
     * 与状态名相同
     */
    private String nodeName;

    /**
     * 垂直距离
     */
    private int top;

    /**
     * 水平距离
     */
    private int left;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + left;
        result = prime * result + ((statusValue == null) ? 0 : statusValue.hashCode());
        result = prime * result + top;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderStatusVertexDTO other = (OrderStatusVertexDTO) obj;
        if (left != other.left)
            return false;
        if (statusValue == null) {
            if (other.statusValue != null)
                return false;
        } else if (!statusValue.equals(other.statusValue))
            return false;
        if (top != other.top)
            return false;
        return true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(Integer statusValue) {
        this.statusValue = statusValue;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }
}