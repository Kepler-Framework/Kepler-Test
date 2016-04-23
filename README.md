* 准备工作
	* JDK依赖
		* JDK1.7及以上
	* 运行依赖
		* @See[<a href="http://maven.apache.org">Maven</a>]
<br></br>
* 测试原理
	* <img src="https://raw.githubusercontent.com/Kepler-Framework/Kepler-Images/master/test_client.png" width="90%"/>  
	* 通过解析JSON构建请求参数，并将返回结果序列化为JSON
<br></br>
* 如何使用
	* 增加Kepler-test-client中需要测试的@See[<a href="https://github.com/Kepler-Framework/Kepler-Test/blob/master/modules/client/pom.xml">接口依赖(Dependency)</a>]
	```
	<dependency>
		<groupId>com.kepler</groupId>
		<artifactId>kepler-test-demo-interface</artifactId>
		<version>1.0-SNAPSHOT</version>
	</dependency>
	```
	* 编写测试用例中@See[<a href="https://github.com/Kepler-Framework/Kepler-Test/blob/master/modules/client/case/3/case.json">元数据部分</a>]
	```
	{
		"service": "com.kepler.TestApp",
		"version": "0.0.1-test",
		"method": "test",
		"profile": "",
		"catalog": "",
		"args": 
		[
			{
				"name": "apply",
				"clazz": "com.kepler.Apply"
			}
		]
	}
	```
	* 编写测试用例中@See[<a href="https://github.com/Kepler-Framework/Kepler-Test/blob/master/modules/client/case/3/case-apply.json">请求参数部分</a>]
	```
	{
		"desc": "THIS TEST",
		"dept": 
		{
			"name": "dept",
			"createAt": "2016-04-23 01:02:03"
		},
	
		"user": 
		{
			"name": "kim",
			"level": "0"
		}
	}
	```
