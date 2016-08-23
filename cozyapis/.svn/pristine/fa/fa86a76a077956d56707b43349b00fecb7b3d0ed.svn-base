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
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries ({
	@NamedQuery(name="UserScope.findByScope", query="select u from UserScope u where u.scope=:scope")
})

@Entity
@Table(name="userscope")
@XmlRootElement
public class UserScope implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="scope",nullable=false)
	private String scope;
	
	
	
	@Column(name = "authority", nullable = false)
	@Enumerated(EnumType.STRING)
	private Authority authority;
	
	
	@Column(name = "method", nullable = false)
	@Enumerated(EnumType.STRING)
	private Method method;

	public UserScope() {
		super();
	}
  
	public enum Authority
	{
		ADMIN, ADMINUSER, ALL
	}
	public enum Method
	{
		POST,PUT,GET,DELETE
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}
	
}