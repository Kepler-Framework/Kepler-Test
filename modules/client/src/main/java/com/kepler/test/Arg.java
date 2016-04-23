package com.kepler.test;

import com.kepler.org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author kim
 *
 * 2016年4月23日
 */
public class Arg {

	private String name;

	private Class<?> clazz;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
