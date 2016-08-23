package in.cozynest.cozyapis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries ({
	@NamedQuery (name = "Token.findByAccessToken", query = "select t from Token t where t.accessToken=:accessToken")
})

@Entity
@Table(name = "token")
@XmlRootElement
public class Token implements java.io.Serializable,IAuthorization {

	private static final long serialVersionUID = 5738538608356643303L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "access_token")
	private String accessToken;
	@Column(name = "issue_date")
	private Date issueDate;
	@Column(name = "expire")
	private Date expire;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Token() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpire() {
		return expire;
	}

	public void setExpire(Date expire) {
		this.expire = expire;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getGeneratedUserId() {
		return user.getGeneratedUserId();
	}

	@Override
	public String getUserTypeString() {
		return user.getUserTypeString();
	}
}
