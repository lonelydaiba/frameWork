package daily.framework;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(Log4jSpringJunit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-*.xml"})
@WebAppConfiguration
public class TestSupport extends AbstractTransactionalJUnit4SpringContextTests{

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void doNothing(){}
}
