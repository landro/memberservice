package no.bekk.open.memberservice.binding;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import no.bekk.open.memberservice.message.MemberDetail;
import no.bekk.open.memberservice.message.MemberDetailsResponse;
import no.bekk.open.memberservice.test.AbstractApplicationContextAwareTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class MemberDetailsResponseBindTest extends AbstractApplicationContextAwareTest {

	@Autowired
	Jaxb2Marshaller jaxb2Marshaller;

	@Test
	public void testUnMarshallingToMemberDetailsRequest() throws Exception {
		InputStream stream = this.getClass().getClassLoader()
				.getResourceAsStream("sampleMemberResponse.xml");
		Object memberDetailsRequestObj = jaxb2Marshaller
				.unmarshal(new StreamSource(stream));
		assertNotNull(memberDetailsRequestObj);
	}

	@Test
	public void testMarshallingToMemberDetailsRequest() throws Exception {
		MemberDetail memberDetail = new MemberDetail("testname", "testphone",
				"testcity", "teststate");
		MemberDetailsResponse response = new MemberDetailsResponse(memberDetail);
		StringWriter writer = new StringWriter();
		Result result = new StreamResult(writer);
		jaxb2Marshaller.marshal(response, result);
		assertNotNull(writer.toString());
		assertTrue(writer.toString().contains("memberdetail"));
	}

}
