package in.cozynest.cozyapis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "package")
@XmlRootElement
public class Package implements java.io.Serializable {

	private static final long serialVersionUID = 6473059328847581396L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "package_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private PackageType packageType;
	
	@Column(name = "image_url", nullable = false)
	private String imageUrl;

	@Column(name = "cost", nullable = false)
	private double cost;

	@Column(name = "cost_of_unit", nullable = false)
	private double costOfUnit;

	public enum PackageType {
		BREAKFAST, LUNCHDINNER, BREAKFASTLUNCHDINNER
	}

	public Package() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PackageType getPackageType() {
		return packageType;
	}

	public void setPackageType(PackageType packageType) {
		this.packageType = packageType;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getCostOfUnit() {
		return costOfUnit;
	}

	public void setCostOfUnit(double costOfUnit) {
		this.costOfUnit = costOfUnit;
	}

	@Override
	public String toString() {
		return "Package [id=" + id + ", name=" + name + ", description=" + description + ", packageType=" + packageType
				+ ", imageUrl=" + imageUrl + ", cost=" + cost + ", costOfUnit=" + costOfUnit + "]";
	}

}