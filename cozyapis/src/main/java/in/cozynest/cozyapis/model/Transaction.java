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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@NamedQueries({ @NamedQuery(name = "Transaction.findByDate", query = "select t from Transaction t where t.date=:date"),
		@NamedQuery(name = "Transaction.findByOrderId", query = "select t from Transaction t Join t.order o where o.id=:orderId"),
		@NamedQuery(name = "Transaction.findByUserId", query = "select t from Transaction t Join t.order o Join o.user c where c.id=:userId") })

@Entity
@Table(name = "transaction")
@XmlRootElement
public class Transaction implements java.io.Serializable,IAuthorization {

	private static final long serialVersionUID = -6237427611357304732L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Enumerated(EnumType.STRING)
	@Column(name = "payment_type", nullable = false)
	private PaymentType paymentType;

	@Column(name = "date", nullable = false)
	private java.util.Date date;

	@Enumerated(EnumType.STRING)
	@Column(name = "transaction_type", nullable = false)
	private TransactionType transactionType;

	@Column(name = "amount", nullable = false)
	private double amount;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;

	@Column(name = "remark", nullable = false)
	private String remark;

	public enum PaymentType {
		WALLET, COD
	}

	public enum TransactionType {
		CREDIT, DEBIT
	}

	public Transaction() {
	}

	public Transaction(PaymentType paymentType, Date date, TransactionType transactionType, double amount, Order order,
			String remark) {
		this.paymentType = paymentType;
		this.date = date;
		this.transactionType = transactionType;
		this.amount = amount;
		this.order = order;
		this.remark = remark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", paymentType=" + paymentType + ", date=" + date + ", transactionType="
				+ transactionType + ", amount=" + amount + ", order=" + order + ", remark=" + remark + "]";
	}

	@Override
	public String getGeneratedUserId() {
		return order.getUser().getGeneratedUserId();
	}

	@Override
	public String getUserTypeString() {
		return order.getUser().getUserTypeString();
	}

}