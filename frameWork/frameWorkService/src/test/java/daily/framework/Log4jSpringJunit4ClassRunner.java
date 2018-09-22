package daily.framework;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.junit.runners.model.InitializationError;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class Log4jSpringJunit4ClassRunner extends SpringJUnit4ClassRunner{

	static{
		try {
			PropertyConfigurator.configure(new ClassPathResource("config/log4j.properties").getFile().getAbsolutePath());
		} catch (IOException e) {
			throw new RuntimeException("加载log4j日志文件出错", e);
		}
	}
	
	public Log4jSpringJunit4ClassRunner(Class<?> clazz)throws InitializationError {
		super(clazz);
	}
}
