package no.bekk.open.memberservice.endpoint;

import no.bekk.open.memberservice.message.MemberDetail;
import no.bekk.open.memberservice.message.MemberDetailsRequest;
import no.bekk.open.memberservice.message.MemberDetailsResponse;
import no.bekk.open.memberservice.service.MemberManager;

import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

public class MemberDetailsEndpoint extends
		AbstractMarshallingPayloadEndpoint {

	private MemberManager memberManager;

	protected Object invokeInternal(Object requestObject) throws Exception {
		MemberDetailsRequest request = (MemberDetailsRequest) requestObject;
		MemberDetail memberDetail = memberManager.getMemberDetails(request
				.getId());
		MemberDetailsResponse response = new MemberDetailsResponse(memberDetail);
		return response;

	}

	public void setMemberManager(MemberManager memberManager) {
		this.memberManager = memberManager;
	}

}
