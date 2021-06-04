package com.qa.ims.persistence.domain;

public class Order {
	
	private Long order_id;
	private Long c_id;
	private Double total_cost;

	public Order(Long c_id, Double total_cost) {
		this.setC_id(c_id);
		this.setTotal_cost(total_cost);
	}

	public Order(Long order_id, Long c_id, Double total_cost) {
		this.setOrder_id(order_id);
		this.setC_id(c_id);
		this.setTotal_cost(total_cost);
		
	}
	
	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}

	public Double getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(Double total_cost) {
		this.total_cost = total_cost;
	}



	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", c_id=" + c_id + ", total_cost=" + total_cost + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c_id == null) ? 0 : c_id.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((total_cost == null) ? 0 : total_cost.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Order other = (Order) obj;
		if (c_id == null) {
			if (other.c_id != null) {
				return false;
			}
		} else if (!c_id.equals(other.c_id)) {
			return false;
		}
		if (order_id == null) {
			if (other.order_id != null) {
				return false;
			}
		} else if (!order_id.equals(other.order_id)) {
			return false;
		}
		if (total_cost == null) {
			if (other.total_cost != null) {
				return false;
			}
		} else if (!total_cost.equals(other.total_cost)) {
			return false;
		}
		return true;
	}

//	public double getTotal_cost() {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	
	

}
