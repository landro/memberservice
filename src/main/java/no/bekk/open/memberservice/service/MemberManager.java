package no.bekk.open.memberservice.service;

import no.bekk.open.memberservice.message.MemberDetail;

public interface MemberManager {
	MemberDetail getMemberDetails(String id);

}
