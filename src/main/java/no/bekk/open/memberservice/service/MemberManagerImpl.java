package no.bekk.open.memberservice.service;

import no.bekk.open.memberservice.message.MemberDetail;

public class MemberManagerImpl implements MemberManager {

	public MemberDetail getMemberDetails(String id) {
		return new MemberDetail("John Doe","111-111-1111","New York","NY");
	}

}
