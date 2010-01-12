package no.bekk.open.memberservice.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "MemberDetailsResponse", namespace = MemberDetailsNamespace.NAMESPACE)
@XmlType(name = "MemberDetailsResponse", namespace = MemberDetailsNamespace.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
public class MemberDetailsResponse {

	public MemberDetailsResponse() {
	}

	@XmlElement(required = true, name = "memberdetail", namespace = MemberDetailsNamespace.NAMESPACE)
	private MemberDetail memberDetail;

	public MemberDetailsResponse(MemberDetail memberDetail) {
		this.memberDetail = memberDetail;
	}

	public MemberDetail getMemberDetail() {
		return memberDetail;
	}

	public void setMemberDetail(MemberDetail memberDetail) {
		this.memberDetail = memberDetail;
	}

}
