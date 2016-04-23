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
	* 
