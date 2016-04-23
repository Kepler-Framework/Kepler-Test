package com.kepler.impl;

import com.kepler.Apply;
import com.kepler.Dept;
import com.kepler.TestApp;
import com.kepler.User;
import com.kepler.annotation.Autowired;

@Autowired
public class TestAppImpl implements TestApp {

	@Override
	public String test() {
		return "Hello world ";
	}

	public String test(String kepler) {
		return "Hello world " + kepler;
	}

	@Override
	public Apply test(Apply apply) {
		return apply;
	}

	public Apply test(User user, Dept dept) {
		Apply apply = new Apply();
		apply.setDesc("THIS IS A Test");
		apply.setUser(user);
		apply.setDept(dept);
		return apply;
	}
}
