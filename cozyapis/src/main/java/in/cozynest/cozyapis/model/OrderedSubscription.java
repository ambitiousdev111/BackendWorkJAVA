package in.cozynest.cozyapis.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({
		@NamedQuery(name = "OrderedSubscription.findByStartDate", query = "select os from OrderedSubscription os where os.startDate=:startDate"),
		@NamedQuery(name = "OrderedSubscription.findByEndDate", query = "select os from OrderedSubscription os where os.endDate=:endDate"),
		@NamedQuery(name = "OrderedSubscription.findByUserId", query = "select os from OrderedSubscription os Join os.user u where u.id=:userId"),
		@NamedQuery(name = "OrderedSubscription.findByPlanType", query = "select os from OrderedSubscription os Join os.subscriptionPlan sp where sp.planType=:planType"),
		@NamedQuery(name = "OrderedSubscription.findByGeneratedUserId", query = "select os from OrderedSubscription os Join os.user u where u.generatedUserId=:generatedUserId"),
		@NamedQuery(name = "OrderedSubscription.findByPhone", query = "select os from OrderedSubscription os Join os.user u where u.phone=:phone"),
		@NamedQuery(name = "OrderedSubscription.findByEndDateAndEndShift", query = "select os from OrderedSubscription os where os.endDate=:endDate and os.endShift=:endShift"),
		@NamedQuery(name = "OrderedSubscription.getStatusById",query="select os.orderStatus from OrderedSubscription os where os.id=:id")
		})

@Entity
@Table(name = "ordered_subscription")
@XmlRootElement
public class OrderedSubscription implements java.io.Serializable {

	private static final long serialVersionUID = -8998988523331603884L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date", nullable = false)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", nullable = false)
	private Date endDate;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "start_shift", nullable = false)
	@Enumerated(EnumType.STRING)
	private Shift startShift;

	@Column(name = "end_shift", nullable = false)
	@Enumerated(EnumType.STRING)
	private Shift endShift;

	@JoinColumn(name = "subscription_plan_id")
	@OneToOne(cascade = CascadeType.MERGE)
	private SubscriptionPlan subscriptionPlan;

	@Enumerated(EnumType.STRING)
	@Column(name = "order_status", nullable = false)
	private OrderedSubscriptionStatus orderStatus;

	@Column(name = "order_date", nullable = false)
	private Date orderDate;

	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user;

	@Column(name = "cost", nullable = false)
	private Double cost;

	@Column(name="remark",nullable= true)
    private String remark;
	
	public enum PlanDuration {
		MONTHLY, WEEKLY
	}

	public enum OrderedSubscriptionStatus {
		CONVERTEDTOSUBSCRIPTION, CANCELLED, NEW
	}

	public enum Shift {
		BREAKFAST, LUNCH, DINNER
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public OrderedSubscription() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Shift getStartShift() {
		return startShift;
	}

	public void setStartShift(Shift startShift) {
		this.startShift = startShift;
	}

	public Shift getEndShift() {
		return endShift;
	}

	public void setEndShift(Shift endShift) {
		this.endShift = endShift;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public SubscriptionPlan getSubscriptionPlan() {
		return subscriptionPlan;
	}

	public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
		this.subscriptionPlan = subscriptionPlan;
	}

	public OrderedSubscriptionStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderedSubscriptionStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "OrderedSubscription [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", address="
				+ address + ", startShift=" + startShift + ", endShift=" + endShift + ", subscriptionPlan="
				+ subscriptionPlan + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + ", user=" + user
				+ ", cost=" + cost + ", remark=" + remark + "]";
	}
    
	

}