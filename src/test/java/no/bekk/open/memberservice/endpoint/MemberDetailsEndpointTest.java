package no.bekk.open.memberservice.endpoint;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertSame;
import no.bekk.open.memberservice.message.MemberDetail;
import no.bekk.open.memberservice.message.MemberDetailsRequest;
import no.bekk.open.memberservice.message.MemberDetailsResponse;
import no.bekk.open.memberservice.service.MemberManager;

import org.junit.Test;

public class MemberDetailsEndpointTest {

	@Test
	public void testMemberDetails() throws Exception {
		MemberManager memberManagerMock = createMock(MemberManager.class);
		MemberDetail memberDetail = new MemberDetail();
		memberDetail.setName("testname");
		memberDetail.setPhone("testphone");
		memberDetail.setCity("testcity");
		memberDetail.setState("teststate");
		expect(memberManagerMock.getMemberDetails(eq("testid"))).andReturn(memberDetail);
		MemberDetailsEndpoint memberDetailsEndpoint = new MemberDetailsEndpoint();
		memberDetailsEndpoint.setMemberManager(memberManagerMock);
		replay(memberManagerMock);
		MemberDetailsRequest request = new MemberDetailsRequest();
		request.setId("testid");
		MemberDetailsResponse response = memberDetailsEndpoint.memberDetails(request);
		verify(memberManagerMock);
		assertSame(memberDetail, response.getMemberDetail());
	}

}
