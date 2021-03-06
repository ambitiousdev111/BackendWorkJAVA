package in.cozynest.cozyapis.utils;

import javax.xml.bind.annotation.XmlRootElement;

import in.cozynest.cozyapis.model.Package.PackageType;

@XmlRootElement
public class TodaysDeliveryWrapper {

	private String userId;
	private String name;
	private String phone;
	private String address;
	private PackageType packageType;

	public TodaysDeliveryWrapper(String userId, String name, String phone, String address,
			PackageType packageType) {
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.packageType = packageType;
	}

	public TodaysDeliveryWrapper() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PackageType getPackageType() {
		return packageType;
	}

	public void setPackageType(PackageType packageType) {
		this.packageType = packageType;
	}

}