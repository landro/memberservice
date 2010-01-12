package no.bekk.open.memberservice.controllers;

import no.bekk.open.memberservice.message.MemberDetail;
import no.bekk.open.memberservice.message.MemberDetailsResponse;
import no.bekk.open.memberservice.service.MemberManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberDetailsController {

	private MemberManager memberManager;

	@RequestMapping(value = "/member_details/{id}", method = RequestMethod.GET)
	@ResponseBody
	public MemberDetailsResponse memberDetails(
			@PathVariable(value = "id") String id) {
		MemberDetail detail = memberManager.getMemberDetails(id);
		MemberDetailsResponse response = new MemberDetailsResponse(detail);
		return response;
	}

	public void setMemberManager(MemberManager memberManager) {
		this.memberManager = memberManager;
	}

}
