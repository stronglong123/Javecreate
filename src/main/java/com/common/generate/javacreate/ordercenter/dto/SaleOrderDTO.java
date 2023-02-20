package com.common.generate.javacreate.ordercenter.dto;



import com.common.generate.javacreate.service.impl.es.base.OrderAmountDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderBaseDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderConsignorDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderContactDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderDeliveryDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderExtDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderItemBaseDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderPickDTO;
import com.common.generate.javacreate.service.impl.es.base.OrderSaleDTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 订单基础信息
 * 
 * @author Hu Liangzhi
 *
 */
public class SaleOrderDTO implements Serializable {
	private static final long serialVersionUID = 5079932771578474388L;

	/**
	 * 订单基础信息
	 */
	private OrderBaseDTO orderBaseDTO;

	/**
	 * 销售单信息
	 */
	private OrderSaleDTO orderSaleDTO;

	/**
	 * 订单金额信息
	 */
	private OrderAmountDTO orderAmountDTO;

	/**
	 * 订单发货信息
	 */
	private OrderConsignorDTO orderConsignorDTO;

	/**
	 * 订单收货信息
	 */
	private OrderContactDTO orderContactDTO;

    /**
     * 订单配送信息
     * @deprecated 仅包含第一个发货记录
     */
    @Deprecated
    private OrderDeliveryDTO orderDeliveryDTO;

    /**
     * 订单配送信息
     */
    private List<OrderDeliveryDTO> orderDeliverys;

	/**
	 * 订单拣货信息
	 */
	private OrderPickDTO orderPickDTO;

	/**
	 * 订单扩展信息
	 */
	private OrderExtDTO orderExtDTO;

//	/**
//	 * 订单会员信息
//	 */
//	private OrderMemberDTO orderMemberDTO;
//
//	/**
//	 * 订单标签信息
//	 */
//	private List<OrderTagDTO> orderTagDTOList;
//
//	/**
//	 * 订单异常信息
//	 */
//	private List<OrderExceptionDTO> orderExceptionDTOList;
//
//	/**
//	 * 销售单明细
//	 */
//	private List<SaleOrderItemDTO> saleOrderItemDTOList;

	public OrderBaseDTO getOrderBaseDTO() {
		return orderBaseDTO;
	}

	public void setOrderBaseDTO(OrderBaseDTO orderBaseDTO) {
		this.orderBaseDTO = orderBaseDTO;
	}

	public OrderSaleDTO getOrderSaleDTO() {
		return orderSaleDTO;
	}

	public void setOrderSaleDTO(OrderSaleDTO orderSaleDTO) {
		this.orderSaleDTO = orderSaleDTO;
	}

	public OrderAmountDTO getOrderAmountDTO() {
		return orderAmountDTO;
	}

	public void setOrderAmountDTO(OrderAmountDTO orderAmountDTO) {
		this.orderAmountDTO = orderAmountDTO;
	}

	public OrderConsignorDTO getOrderConsignorDTO() {
		return orderConsignorDTO;
	}

	public void setOrderConsignorDTO(OrderConsignorDTO orderConsignorDTO) {
		this.orderConsignorDTO = orderConsignorDTO;
	}

	public OrderContactDTO getOrderContactDTO() {
		return orderContactDTO;
	}

	public void setOrderContactDTO(OrderContactDTO orderContactDTO) {
		this.orderContactDTO = orderContactDTO;
	}

	public OrderDeliveryDTO getOrderDeliveryDTO() {
		return orderDeliveryDTO;
	}

	public void setOrderDeliveryDTO(OrderDeliveryDTO orderDeliveryDTO) {
		this.orderDeliveryDTO = orderDeliveryDTO;
	}

	public OrderPickDTO getOrderPickDTO() {
		return orderPickDTO;
	}

	public void setOrderPickDTO(OrderPickDTO orderPickDTO) {
		this.orderPickDTO = orderPickDTO;
	}

	public OrderExtDTO getOrderExtDTO() {
		return orderExtDTO;
	}

	public void setOrderExtDTO(OrderExtDTO orderExtDTO) {
		this.orderExtDTO = orderExtDTO;
	}

//	public OrderMemberDTO getOrderMemberDTO() {
//		return orderMemberDTO;
//	}
//
//	public void setOrderMemberDTO(OrderMemberDTO orderMemberDTO) {
//		this.orderMemberDTO = orderMemberDTO;
//	}
//
//	public List<SaleOrderItemDTO> getSaleOrderItemDTOList() {
//		return saleOrderItemDTOList;
//	}
//
//	public void setSaleOrderItemDTOList(List<SaleOrderItemDTO> saleOrderItemDTOList) {
//		this.saleOrderItemDTOList = saleOrderItemDTOList;
//	}
//
//	public List<OrderTagDTO> getOrderTagDTOList() {
//		return orderTagDTOList;
//	}
//
//	public void setOrderTagDTOList(List<OrderTagDTO> orderTagDTOList) {
//		this.orderTagDTOList = orderTagDTOList;
//	}
//
//	public List<OrderExceptionDTO> getOrderExceptionDTOList() {
//		return orderExceptionDTOList;
//	}
//
//	public void setOrderExceptionDTOList(List<OrderExceptionDTO> orderExceptionDTOList) {
//		this.orderExceptionDTOList = orderExceptionDTOList;
//	}
//
//	public List<OrderDeliveryDTO> getOrderDeliverys() {
//		return orderDeliverys;
//	}
//
//	public void setOrderDeliverys(List<OrderDeliveryDTO> orderDeliverys) {
//		this.orderDeliverys = orderDeliverys;
//	}
//
//	public Boolean saleOrderAutoComplete() {
//		for (SaleOrderItemDTO saleOrderItemDTO : saleOrderItemDTOList) {
//			OrderItemBaseDTO orderItemBaseDTO = saleOrderItemDTO.getOrderItemBaseDTO();
//			if ((orderItemBaseDTO.getTakeCount().add(orderItemBaseDTO.getInStockCount()).compareTo(orderItemBaseDTO.getDeliveryCount()) != 0)
//					&& (orderItemBaseDTO.getTakeCount().add(orderItemBaseDTO.getInStockCount()).compareTo(orderItemBaseDTO.getOutStockCount()) != 0)) {
//				return false;
//			}
//		}
//		if(orderAmountDTO.getUncollectedAmount().compareTo(BigDecimal.ZERO) != 0) {
//			return false;
//		}
//		return true;
//	}
}
