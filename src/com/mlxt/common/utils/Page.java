package com.mlxt.common.utils;

import java.util.List;

/**
 * Filename: Page.java
 * 
 * ��ҳ����
 * 
 * @author Luor
 * @version 1.0
 */
public class Page<T> {
	
	private int page;   //��ǰҳ��
	private List<T> rows;
	private int size;   //ÿҳ����
	private int total;   //��ҳ����
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
