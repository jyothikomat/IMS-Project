package com.qa.ims.persistence.domain;

public class Customer {

	private Long c_id;
	private String firstname;
	private String surname;

	public Customer(String firstname, String surname) {
		this.setFirstname(firstname);
		this.setSurname(surname);
	}

	public Customer(Long c_id, String firstname, String surname) {
		this.setC_id(c_id);
		this.setFirstname(firstname);
		this.setSurname(surname);
	}

	public Long getC_id() {
		return c_id;
	}

	public void setC_id(Long c_id) {
		this.c_id = c_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		return "c_id:" + c_id + " firstname:" + firstname + " surname:" + surname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((c_id == null) ? 0 : c_id.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		Customer other = (Customer) obj;
		if (getFirstname() == null) {
			if (other.getFirstname() != null)
				return false;
		} else if (!getFirstname().equals(other.getFirstname()))
			return false;
		if (c_id == null) {
			if (other.c_id != null)
				return false;
		} else if (!c_id.equals(other.c_id))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

}
