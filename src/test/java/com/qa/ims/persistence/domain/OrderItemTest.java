package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderItemTest {
	private  OrderItem orderItem ;
	        Long order_items_id=(long) 1;
			Long order_id=(long) 1;
		    Long item_id=(long) 1;
	 	    Long quantity=(long) 25.00;
		 
	
//Long id=(long) 1;
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Order.class).verify();
	}
	
	@Test
	public void ConstructorOneTest()
	
	
	{
		orderItem=new OrderItem(order_items_id,order_id,item_id,quantity);
		
		assertEquals(order_items_id,orderItem.getOrder_items_id());
		assertEquals(order_id,orderItem.getOrder_id());
		assertEquals(item_id,orderItem.getItem_id());
		assertEquals(quantity,orderItem.getQuantity());
		
		assertTrue(orderItem instanceof OrderItem);
		assertNotNull(orderItem);
	}

	@Test
	public void ConstructorTwoTest()
	
	{
orderItem=new OrderItem(order_id,item_id,quantity);
		
		//assertEquals(order_items_id,orderItem.getOrder_items_id());
		assertEquals(order_id,orderItem.getOrder_id());
		assertEquals(item_id,orderItem.getItem_id());
		assertEquals(quantity,orderItem.getQuantity());
	}

	
	

}