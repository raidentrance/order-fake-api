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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private OrderInfoStatus status;

	@OneToMany(mappedBy = "orderInfo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Item> items;

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
