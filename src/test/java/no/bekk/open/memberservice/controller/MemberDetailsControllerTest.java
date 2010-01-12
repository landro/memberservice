package no.bekk.open.memberservice.controller;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertSame;
import no.bekk.open.memberservice.controllers.MemberDetailsController;
import no.bekk.open.memberservice.message.MemberDetail;
import no.bekk.open.memberservice.message.MemberDetailsResponse;
import no.bekk.open.memberservice.service.MemberManager;

import org.junit.Test;

public class MemberDetailsControllerTest {

	@Test
	public void testInvokeInternalObject() throws Exception {
		MemberManager memberManagerMock = createMock(MemberManager.class);
		MemberDetail memberDetail = new MemberDetail("testname", "testphone",
				"testcity", "teststate");
		expect(memberManagerMock.getMemberDetails(eq("testid"))).andReturn(
				memberDetail);
		MemberDetailsController controller = new MemberDetailsController();
		controller.setMemberManager(memberManagerMock);
		replay(memberManagerMock);
		MemberDetailsResponse response = controller.memberDetails("testid");
		verify(memberManagerMock);
		assertSame(memberDetail, response.getMemberDetail());
	}

}
