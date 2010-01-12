package no.bekk.open.memberservice.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "MemberDetailsRequest", namespace = MemberDetailsNamespace.NAMESPACE)
@XmlType(name = "MemberDetailsRequest", namespace = MemberDetailsNamespace.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
public class MemberDetailsRequest {

	public MemberDetailsRequest() {
	}

	public MemberDetailsRequest(String id) {
		this.id = id;
	}

	@XmlElement(required = true)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
