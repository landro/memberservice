package no.bekk.open.memberservice.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "MemberDetailType", namespace = MemberDetailsNamespace.NAMESPACE)
@XmlAccessorType(XmlAccessType.FIELD)
public class MemberDetail {

	@XmlElement(required = true, namespace = MemberDetailsNamespace.NAMESPACE)
	private String name;

	@XmlElement(required = true, namespace = MemberDetailsNamespace.NAMESPACE)
	private String phone;

	@XmlElement(required = true, namespace = MemberDetailsNamespace.NAMESPACE)
	private String city;

	@XmlElement(required = true, namespace = MemberDetailsNamespace.NAMESPACE)
	private String state;

	public MemberDetail() {

	}

	public MemberDetail(String name, String phone, String city, String state) {
		this.name = name;
		this.phone = phone;
		this.city = city;
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
