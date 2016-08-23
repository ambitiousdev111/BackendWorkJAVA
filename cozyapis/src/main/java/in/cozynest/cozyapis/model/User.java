package in.cozynest.cozyapis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({ @NamedQuery(name = "User.findByPhone", query = "select c from User c where c.phone=:phone"),
	    @NamedQuery(name="User.findByEmail",query="select c from User c where c.email=:email"),
	    @NamedQuery(name="User.findById",query="select c from User c where c.id=:id"),
		@NamedQuery(name = "User.findByUserId", query = "select c from User c where c.generatedUserId=:userId"),
		@NamedQuery(name = "User.findByUserIdOrPhone", query = "select c from User c where c.generatedUserId=:userId or c.phone=:phone"),
		@NamedQuery(name = "User.findByPhoneAndWithoutCurrentPK", query = "select c from User c where id not in(:id) and c.phone=:phone"),
		@NamedQuery(name = "User.findByGeneratedUserIdAndWithoutCurrentPK", query = "select c from User c where id not in (:id) and c.generatedUserId=:generatedUserId"),
		
        @NamedQuery(name="User.findByEmailAndPassword",query="select c from User c where c.email=:email")})
@Entity
@Table(name = "user")
@XmlRootElement

public class User implements java.io.Serializable,IAuthorization {
	private static final long serialVersionUID = -7373792587429160278L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "generated_user_id", nullable = false)
	private String generatedUserId;

	@Column(name = "name", nullable = false)
	private String name;

	
	
	@Column(name = "phone", nullable = false)
	private String phone;

	
    @Column(name="email",nullable=false)
	private String email;
	@Column(name = "date_of_birth", nullable = true)
	@Temporal(TemporalType.DATE)
	private java.util.Date dateOfBirth;

	@Column(name = "gender", nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "date_of_joining", nullable = true)
	private java.util.Date dateOfJoining;
	
	@Column(name = "user_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private UserType userType;

	@Column(name = "profession", nullable = false)
	private String profession;
	
	public enum UserType {
		ADMIN, USER
	}
	
	public enum Gender {
		MALE, FEMALE
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGeneratedUserId() {
		return generatedUserId;
	}

	public void setGeneratedUserId(String generatedUserId) {
		this.generatedUserId = generatedUserId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public java.util.Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public java.util.Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(java.util.Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public User getUser() {
		return this;
	}

	public String getUserTypeString() {
		return userType.toString();
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", generatedUserId=" + generatedUserId + ", name=" + name + ", phone="
				+ phone + ",email="+email+", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", dateOfJoining=" + dateOfJoining
				+ "]";
	}

}