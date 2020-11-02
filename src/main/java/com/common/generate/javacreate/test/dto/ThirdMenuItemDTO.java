package com.common.generate.javacreate.test.dto;

import java.io.Serializable;
import java.util.List;

/*
 * Copyright © 2016 北京易酒批电子商务有限公司. All rights reserved.
 */

public class ThirdMenuItemDTO implements Serializable {
	private static final long serialVersionUID = -4884723000208983123L;
	/**
	 * 权限code
	 */
	private String id;
	/**
	 * 权限名称
	 */
	private String name;
	/**
	 * 文本
	 */
	private String text;
	/**
	 * url地址
	 */
	private String namespace;
	/**
	 * 排序
	 */
	private String sort;
	/**
	 * 图片
	 */
	private Integer imgCode;
	/**
	 * 是否展示
	 */
	private Boolean isShowSubMenu;
	private List<ThirdMenuItemDTO> navList;
	
	/** 图标*/
	private String imgIcon;
	/** 参数 */
	private String argument;
	/**
	 * 类型：1、菜单 2、权限点
	 */
	private Integer type;

	@Override
	public String toString() {
		return "MenuItemDTO [id=" + id + ", name=" + name + ", text=" + text + ", namespace=" + namespace + ", sort=" + sort + ", imgCode=" + imgCode + ", isShowSubMenu=" + isShowSubMenu + ", navList=" + navList + "]";
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getImgCode() {
		return imgCode;
	}

	public void setImgCode(Integer imgCode) {
		this.imgCode = imgCode;
	}

	public Boolean getIsShowSubMenu() {
		return isShowSubMenu;
	}

	public void setIsShowSubMenu(Boolean isShowSubMenu) {
		this.isShowSubMenu = isShowSubMenu;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public List<ThirdMenuItemDTO> getNavList() {
		return navList;
	}

	public void setNavList(List<ThirdMenuItemDTO> navList) {
		this.navList = navList;
	}

	public String getImgIcon() {
		return imgIcon;
	}

	public void setImgIcon(String imgIcon) {
		this.imgIcon = imgIcon;
	}

	public String getArgument() {
		return argument;
	}

	public void setArgument(String argument) {
		this.argument = argument;
	}
}
