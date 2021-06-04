package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;

	@InjectMocks
	private OrderController controller;

	@Test
	public void testCreate() {
		//final Long order_id = (long) 1;
		final Long c_id = (long) 1;
		//final Double total_cost = (double) 1;
		final Long item_id=(long)1;
		final Long quantity=(long)2;
		final  Double price=75D;
		final Order created = new Order( c_id,price*quantity);
		Mockito.when(this.utils.getLong()).thenReturn(c_id);
		Mockito.when(this.utils.getLong()).thenReturn(item_id);
		Mockito.when(this.utils.getLong()).thenReturn(quantity);
		//Mockito.when(this.utils.getDouble()).thenReturn(total_cost);
		//Mockito.when(utils.getLong()).thenReturn(order_id , c_id,total_cost);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		
		orders.add(new Order(1L, 1L, null));
		//customers.add(new Order(1L, "jordan", "harrison"));

		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	/*
	 * @Test public void testUpdate() { Order updated = new Order(1L, 1L, null);
	 * 
	 * Mockito.when(this.utils.getLong()).thenReturn(1L);
	 * Mockito.when(this.utils.getLong()).thenReturn( updated.getItem_id1()
	 * ,null,updated.getQuantity(),null);
	 * Mockito.when(this.dao.update(updated)).thenReturn(updated);
	 * 
	 * assertEquals(updated, this.controller.update());
	 * 
	 * Mockito.verify(this.utils, Mockito.times(1)).getLong();
	 * Mockito.verify(this.utils, Mockito.times(2)).getString();
	 * Mockito.verify(this.dao, Mockito.times(1)).update(updated); }
	 */

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

}