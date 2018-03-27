package com.jxliu.ssm.util;

import java.util.List;

/**
 * easyui工具类，返回total，rows
 * @author Administrator
 */
public class EasyuiResult {
	private int total;
	private List<?> rows;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
}
