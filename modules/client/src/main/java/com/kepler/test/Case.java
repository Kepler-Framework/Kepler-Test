package com.kepler.test;

import com.kepler.org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author kim
 *
 * 2016年4月23日
 */
public class Case {

	private String service;

	private String version;

	private String profile;

	private String catalog;

	private String method;

	private Arg[] args;

	public Arg[] getArgs() {
		return this.args;
	}

	public void setArgs(Arg[] args) {
		this.args = args;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getProfile() {
		return this.profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getCatalog() {
		return this.catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
