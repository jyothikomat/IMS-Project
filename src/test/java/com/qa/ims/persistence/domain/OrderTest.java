package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {
	private  Order order ;
	 Long order_id=(long) 1;
			Long c_id=(long) 1;
		 //Long item_id1=(long) 1;
	 //String item_name="phone";
		//Long quantity=(long) 25.00;
		 Double total_cost=1.25;
	
//Long id=(long) 1;
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Order.class).verify();
	}
	
	@Test
	public void ConstructorOneTest()
	
	{
		order=new Order(order_id,c_id,total_cost);
		
		assertEquals(order_id,order.getOrder_id());
		assertEquals(c_id,order.getC_id());
		assertEquals(total_cost,order.getTotal_cost());
		
		assertTrue(order instanceof Order);
		assertNotNull(order);
	}

	@Test
	public void ConstructorTwoTest()
	
	{
		order=new Order(c_id, total_cost);
		
		//assertEquals(order_id,order.getOrder_id());
		assertEquals(c_id,order.getC_id());
		
		assertEquals(total_cost,order.getTotal_cost());
		
		assertTrue(order instanceof Order);
		assertNotNull(order);
	}

	
	

}