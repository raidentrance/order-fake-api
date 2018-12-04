/**
 * 
 */
package com.walmart.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author raidentrance
 *
 */
@Entity
@Table(name = "orderinfo")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class OrderInfo {
	@Id
	@Column(name = "id", nullable = false)
	private String orderId;

	@Column(name = "delivery_date")
	@Temporal(TemporalType.DATE)
	private Date deliveryDate;

	@Column(name = "last_update_ts")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateTs;

	@Column(name = "delivery_time")
	private String deliveryPeriod;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private OrderInfoStatus status;

	@OneToMany(mappedBy = "orderInfo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Item> items;
	
	@Column(name = "client_name")
	private String clientName;
	
	@Column(name = "delivery_address")
	private String deliveryAddress;
	
	@Column(name = "payment_method")
	private String paymentMethod;
	
	@Column(name = "contact_phone")
	private String contactPhone;
	
	@Column(name = "carrier")
	private String carrier;
	
	@Column(name = "channel")
	private String channel;
	
	@Column(name = "in_transit_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date inTransitDate;

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getLastUpdateTs() {
		return lastUpdateTs;
	}

	public void setLastUpdateTs(Date lastUpdateTs) {
		this.lastUpdateTs = lastUpdateTs;
	}

	public OrderInfoStatus getStatus() {
		return status;
	}

	public void setStatus(OrderInfoStatus status) {
		this.status = status;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getDeliveryPeriod() {
		return deliveryPeriod;
	}

	public void setDeliveryPeriod(String deliveryPeriod) {
		this.deliveryPeriod = deliveryPeriod;
	}

	public Date getInTransitDate() {
		return inTransitDate;
	}

	public void setInTransitDate(Date inTransitDate) {
		this.inTransitDate = inTransitDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderInfo other = (OrderInfo) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

}
