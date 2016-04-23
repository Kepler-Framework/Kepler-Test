package com.kepler;

import java.io.Serializable;

/**
 * @author kim
 *
 * 2016年4月23日
 */
public class Apply implements Serializable{

	private static final long serialVersionUID = 1L;

	private String desc;

	private User user;

	private Dept dept;

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
