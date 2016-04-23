package com.kepler;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kim
 *
 * 2016年4月23日
 */
public class Dept implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private Date createAt;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
}
