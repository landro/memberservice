package no.bekk.open.memberservice.service;

import no.bekk.open.memberservice.message.MemberDetail;

public class MemberManagerImpl implements MemberManager {

	public MemberDetail getMemberDetails(String id) {
		MemberDetail detail = new MemberDetail();
		detail.setName("John Doe");
		detail.setPhone("111-111-1111");
		detail.setCity("New York");
		detail.setState("NY");
		return detail;
	}

}
