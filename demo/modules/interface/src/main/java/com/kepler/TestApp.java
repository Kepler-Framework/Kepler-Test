package com.kepler;

import com.kepler.annotation.Service;

@Service(version = "0.0.1-test")
public interface TestApp {

	public String test();

	public String test(String kepler);

	public Apply test(Apply apply);

	public Apply test(User user, Dept dept);
}
