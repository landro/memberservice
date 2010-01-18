package no.bekk.open.memberservice.endpoint;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import no.bekk.open.memberservice.message.MemberDetail;
import no.bekk.open.memberservice.message.MemberDetailsRequest;
import no.bekk.open.memberservice.service.MemberManager;

import org.junit.Test;

public class MemberDetailsEndpointTest {

	@Test
	public void testInvokeInternalObject() throws Exception {
		MemberManager memberManagerMock = createMock(MemberManager.class);
		MemberDetail memberDetail = new MemberDetail("testname","testphone","testcity","teststate");
		expect(memberManagerMock.getMemberDetails(eq("testid"))).andReturn(memberDetail);
		MemberDetailsEndpoint memberDetailsEndpoint = new MemberDetailsEndpoint();
		memberDetailsEndpoint.setMemberManager(memberManagerMock);
		replay(memberManagerMock);
		memberDetailsEndpoint.memberDetails(new MemberDetailsRequest("testid"));
		verify(memberManagerMock);
	}

}
