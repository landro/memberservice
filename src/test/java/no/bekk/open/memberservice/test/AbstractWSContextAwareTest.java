package no.bekk.open.memberservice.test;

import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(inheritLocations = true, locations = { "file:src/main/webapp/WEB-INF/ws-servlet.xml" })
public abstract class AbstractWSContextAwareTest extends
		AbstractApplicationContextAwareTest {

}
