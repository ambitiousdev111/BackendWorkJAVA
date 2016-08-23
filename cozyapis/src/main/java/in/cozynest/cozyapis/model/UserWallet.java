package in.cozynest.cozyapis.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
		@NamedQuery(name = "UserWallet.findByUserId", query = "select cw from UserWallet cw Join cw.user c where c.id=:userId"),
		@NamedQuery(name = "UserWallet.findAmountByUserId", query = "select cw.amount from UserWallet cw Join cw.user c where cid=:userId"),
		@NamedQuery(name = "UserWallet.findByGeneratedUserId", query = "select cw from UserWallet cw Join cw.user c where c.generatedUserId=:generatedUserId"),
		@NamedQuery(name = "UserWallet.findByPhone", query = "select cw from UserWallet cw Join cw.user c where c.phone = :phone") })
@Entity
@Table(name = "user_wallet")
@XmlRootElement
public class UserWallet implements java.io.Serializable,IAuthorization {

	private static final long serialVersionUID = 2081766435012622117L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "amount")
	private double amount;

	public UserWallet() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String getGeneratedUserId() {
		return user.getGeneratedUserId();
	}

	@Override
	public String getUserTypeString() {
		return user.getUserType().toString();
	}

}