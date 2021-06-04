package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {
	private  Customer customer ;
	String firstname="jaya";
	String surname="laxmi";
Long id=(long) 1;
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}
	
	@Test
	public void ConstructorOneTest()
	
	{
		customer=new Customer(firstname, surname);
		
		assertEquals(firstname,customer.getFirstname());
		assertEquals(surname,customer.getSurname());
		//assertEquals("Ram",customer.getSurname());
		
		assertTrue(customer instanceof Customer);
		assertNotNull(customer);
	}

	
	@Test
	public void ConstructorTwoTest()
	
	{
		customer=new Customer(id,firstname, surname);
		
		
		assertEquals(id,customer.getC_id());
		//assertEquals(id,customer.setId());
		assertEquals(firstname,customer.getFirstname());
		assertEquals(surname,customer.getSurname());
		//assertEquals("Ram",customer.getSurname());
		
		assertTrue(customer instanceof Customer);
		assertNotNull(customer);
	}
	
	
	

}
