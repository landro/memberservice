package no.bekk.open.memberservice.binding;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import no.bekk.open.memberservice.message.MemberDetailsRequest;
import no.bekk.open.memberservice.test.AbstractApplicationContextAwareTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class MemberDetailsRequestBindTest extends AbstractApplicationContextAwareTest {

	@Autowired
	Jaxb2Marshaller jaxb2Marshaller;

	@Test
	public void testUnMarshallingToMemberDetailsRequest() throws Exception {
		InputStream stream = this.getClass().getClassLoader()
				.getResourceAsStream("sampleMemberRequest.xml");
		Object memberDetailsRequestObj = jaxb2Marshaller
				.unmarshal(new StreamSource(stream));
		assertNotNull(memberDetailsRequestObj);
	}

	@Test
	public void testMarshallingToMemberDetailsRequest() throws Exception {
		MemberDetailsRequest memberDetailsRequest = new MemberDetailsRequest();
		memberDetailsRequest.setId("SAMPLE");
		StringWriter writer = new StringWriter();
		Result result = new StreamResult(writer);
		jaxb2Marshaller.marshal(memberDetailsRequest, result);
		assertTrue(writer.toString().contains("MemberDetailsRequest"));
	}

}
