package com.kepler.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kepler.config.Profile;
import com.kepler.config.PropertiesUtils;
import com.kepler.header.HeadersContext;
import com.kepler.header.HeadersProcessor;
import com.kepler.id.IDGenerators;
import com.kepler.invoker.Invoker;
import com.kepler.org.apache.commons.lang.reflect.MethodUtils;
import com.kepler.protocol.RequestFactory;
import com.kepler.protocol.RequestValidation;
import com.kepler.serial.Serials;
import com.kepler.service.Imported;
import com.kepler.service.imported.ImportedServiceFactory;

/**
 * @author kim
 *
 * 2016年4月23日
 */
@ContextConfiguration(value = "classpath:kepler-runtime.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainTest {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	private static final Log LOGGER = LogFactory.getLog(MainTest.class);

	private static final String DATE_FORAMT = PropertiesUtils.get(MainTest.class.getName().toLowerCase() + ".date_foramt", "yyyy-MM-dd HH:mm:ss");

	private static final String STUFFIX = PropertiesUtils.get(MainTest.class.getName().toLowerCase() + ".stuffix", ".json");

	private static final String PATH = PropertiesUtils.get(MainTest.class.getName().toLowerCase() + ".path", null);

	@Resource(name = "kepler.id")
	private IDGenerators id;

	@Resource(name = "kepler.invoker")
	private Invoker invoker;

	@Resource(name = "kepler.serials")
	private Serials serials;

	@Resource(name = "kepler.config.profile")
	private Profile profile;

	@Resource(name = "kepler.header.context")
	private HeadersContext headers;

	@Resource(name = "kepler.header.processor")
	private HeadersProcessor processor;

	@Resource(name = "kepler.service.imported")
	private Imported imported;

	@Resource(name = "kepler.protocol.request")
	private RequestFactory request;

	@Resource(name = "kepler.protocol.validation4client")
	private RequestValidation validation;

	/**
	 * 创建Case
	 * 
	 * @return
	 * @throws Exception
	 */
	private Case generate() throws Exception {
		Case test = MainTest.MAPPER.readValue(ResourceUtils.getFile(MainTest.PATH + MainTest.STUFFIX), Case.class);
		return test;
	}

	/**
	 * 创建请求参数
	 * 
	 * @param test
	 * @return
	 * @throws Exception
	 */
	private List<Object> generate(Case test) throws Exception {
		List<Object> args = new ArrayList<Object>();
		for (Arg arg : test.getArgs()) {
			args.add(MainTest.MAPPER.readValue(ResourceUtils.getFile(MainTest.PATH + "-" + arg.getName() + MainTest.STUFFIX), arg.getClazz()));
		}
		return args;
	}

	@Before
	public void prepare() {
		MainTest.MAPPER.setDateFormat(new SimpleDateFormat(System.getProperty(MainTest.DATE_FORAMT, MainTest.DATE_FORAMT)));
	}

	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void test() throws Exception {
		Case test = this.generate();
		ImportedServiceFactory<?> imported = new ImportedServiceFactory(Class.forName(test.getService()), test.getProfile(), test.getVersion(), test.getProfile(), this.invoker, this.validation, this.request, this.headers, this.processor, this.id, this.profile, this.serials, this.imported);
		Object response = MethodUtils.invokeMethod(imported.getObject(), test.getMethod(), this.generate(test).toArray(new Object[] {}));
		MainTest.LOGGER.warn(MainTest.MAPPER.writeValueAsString(response));
	}
}
