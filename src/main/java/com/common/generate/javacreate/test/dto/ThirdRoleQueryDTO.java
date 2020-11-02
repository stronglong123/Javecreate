package com.common.generate.javacreate.test.dto;

import java.io.Serializable;

public class ThirdRoleQueryDTO implements Serializable {
	private static final long serialVersionUID = 2683647028698593156L;

	/** 角色名 */
	private String roleName;
	/** 角色编码 */
	private String roleCode;
	/**
	 * 服务商Id
	 */
	private Long serviceId;

	private String appCode;

	private Long refUserId;

	private Long orgId;

	private Long warehouseId;

	/**
	 * 页码.
	 */
	public static String PAGE_NUM = "pageNum";

	/**
	 * 每页大小.
	 */
	public static String PAGE_SIZE = "pageSize";

	/**
	 * 排序条件.
	 */
	public static String ORDER_BY = "orderBy";

	/**
	 * 页码.
	 */
	private Integer pageNum;

	/**
	 * 每页大小.
	 */
	private Integer pageSize;

	/**
	 * 排序条件.
	 */
	private String orderBy;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public Long getRefUserId() {
		return refUserId;
	}

	public void setRefUserId(Long refUserId) {
		this.refUserId = refUserId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public static String getPageNum() {
		return PAGE_NUM;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public static void setPageNum(String pageNum) {
		PAGE_NUM = pageNum;
	}

	public static String getPageSize() {
		return PAGE_SIZE;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public static void setPageSize(String pageSize) {
		PAGE_SIZE = pageSize;
	}

	public static String getOrderBy() {
		return ORDER_BY;
	}

	public static void setOrderBy(String orderBy) {
		ORDER_BY = orderBy;
	}
}
