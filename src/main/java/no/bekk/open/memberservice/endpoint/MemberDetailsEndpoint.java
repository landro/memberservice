package no.bekk.open.memberservice.endpoint;

import no.bekk.open.memberservice.message.MemberDetail;
import no.bekk.open.memberservice.message.MemberDetailsRequest;
import no.bekk.open.memberservice.message.MemberDetailsResponse;
import no.bekk.open.memberservice.service.MemberManager;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

@Endpoint
public class MemberDetailsEndpoint {

	private MemberManager memberManager;

	@PayloadRoot(localPart = "MemberDetailsRequest", namespace = "http://open.bekk.no/memberservice")
	public MemberDetailsResponse memberDetails(MemberDetailsRequest request) {
		MemberDetail detail = memberManager.getMemberDetails(request
				.getId());
		MemberDetailsResponse response = new MemberDetailsResponse();
		response.setMemberDetail(detail);
		return response;
	}

	public void setMemberManager(MemberManager memberManager) {
		this.memberManager = memberManager;
	}

}
