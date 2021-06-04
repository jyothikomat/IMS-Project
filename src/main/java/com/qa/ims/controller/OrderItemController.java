package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class OrderItemController implements CrudController<OrderItem> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderItemDAO orderItemDAO;
	private Utils utils;

	public OrderItemController(OrderItemDAO orderitemDAO, Utils utils) {
		super();
		this.orderItemDAO = orderItemDAO;
		this.utils = utils;
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<OrderItem> readAll() {
		List<OrderItem> orderItems = orderItemDAO.readAll();
		for (OrderItem orderItem : orderItems) {
			LOGGER.info(orderItems);
		}
		return orderItems;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public OrderItem create() {
		//LOGGER.info("Please enter a firstname");
		LOGGER.info("Please enter a order_id");
		Long oder_id  = utils.getLong();
		LOGGER.info("Please enter a item_id");
		Long item_id = utils.getLong();
		LOGGER.info("Please enter a quantity");
		Long quantity = utils.getLong();
		OrderItem orderItem = orderItemDAO.create(new OrderItem(oder_id , item_id, quantity));
		LOGGER.info("OrderItem created");
		return orderItem;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public OrderItem update() {
		LOGGER.info("Please enter the id of the orderItem you would like to update");
		Long order_items_id = utils.getLong();
        Long order_id = utils.getLong();
		Long item_id = utils.getLong();;
		LOGGER.info("Please enter a Quantity");
		Long quantity = utils.getLong();;
		//LOGGER.info("Please enter a firstname");
//		String firstname = utils.getString();
//		LOGGER.info("Please enter a surname");
//		String surname = utils.getString();
		OrderItem orderItem = orderItemDAO.update(new OrderItem(order_items_id, order_id, item_id, quantity));
		LOGGER.info("OrderItem Updated");
		return orderItem;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = utils.getLong();
		return orderItemDAO.delete(id);
	}

}
