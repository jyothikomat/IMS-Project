package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter a customerid");
		Long c_id = utils.getLong();
		Double total_cost = 0.0;
		UserAction ua;
		List<OrderItem> list = new ArrayList<OrderItem>();
		do {
			LOGGER.info("Do you want to select an item ? yes/no ");			
             UserAction.printUserActions();	
             ua =  UserAction.getUserAction(utils);
            if(ua != UserAction.NO)  
            {
             ItemDAO itemDAO = new ItemDAO();
             List<Item> items = itemDAO.readAll();
             LOGGER.info(items);
             LOGGER.info("Select item_id ");
             Long item_id = utils.getLong();
             LOGGER.info("Select quantity");
             Long quantity = utils.getLong();
             Item item = itemDAO.read(item_id);        
            
            OrderItem orderItem = new OrderItem(null, item_id, quantity);
              list.add(orderItem);
            // orderItem = orderItemDAO.create(orderItem);
           total_cost = total_cost + item.getPrice()*quantity;
            }

		} while (ua != UserAction.NO);		
		
		Order order = orderDAO.create(new Order(c_id, total_cost));
	    for(int i=0; i < list.size(); i++)
	    {
	    	OrderItem orderItem = list.get(i);
	    	orderItem.setOrder_id(order.getOrder_id());
	    	OrderItemDAO orderItemDAO = new OrderItemDAO();
	    	 orderItemDAO.create(orderItem);
	    }
		LOGGER.info("order created");
		return order;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the Order you would like to update");
		Long order_id = utils.getLong();
		LOGGER.info("What do you want to do with order?");
		UpdateOrderAction.printUpdateOrderActions();	
		UpdateOrderAction updateAction =  UpdateOrderAction.getUpdateOrderAction(utils);
		switch (updateAction) {
		case ADD:
		  return this.addItemToOrder(order_id);								
		case DELETE:
			return this.deleteItemInOrder(order_id);			 
		default:
			return null;
		}		
	}
	public Order addItemToOrder(Long order_id) {
	 Order order = orderDAO.read(order_id) ;
	 ItemDAO itemDAO = new ItemDAO();
     List<Item> items = itemDAO.readAll();
     LOGGER.info(items);
     LOGGER.info("Select item_id ");
     Long item_id = utils.getLong();
     LOGGER.info("Select quantity");
     Long quantity = utils.getLong();
     Item item = itemDAO.read(item_id);        
    Double total_cost =  order.getTotal_cost() + item.getPrice()*quantity;
    OrderItem orderItem = new OrderItem(order_id, item_id, quantity);
		OrderItemDAO  orderItemDAO = new OrderItemDAO();
		orderItemDAO.create(orderItem);
		order.setTotal_cost(total_cost);
		return orderDAO.update(order);
	}
	
	public Order deleteItemInOrder(Long order_id) {
		 Order order = orderDAO.read(order_id) ;
		 OrderItemDAO  orderItemDAO = new OrderItemDAO();
		 List<OrderItem> orderItemList = orderItemDAO.readByOrderId(order_id);
		 LOGGER.info(orderItemList);
	     LOGGER.info("Select order_items_id to delete");
	     Long order_item_id = utils.getLong();
	     OrderItem orderItem = orderItemDAO.read(order_item_id) ;
	     orderItemDAO.delete(order_item_id);
	     ItemDAO itemDAO = new ItemDAO();
	     Item item = itemDAO.read(orderItem.getItem_id());        
	     Double total_cost =  order.getTotal_cost() - item.getPrice()*orderItem.getQuantity();
	     order.setTotal_cost(total_cost);
			return orderDAO.update(order);		 
		
	}
	
	

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		OrderItemDAO orderItemDAO = new OrderItemDAO();
		 orderItemDAO.deleteOrder(id);
		return orderDAO.delete(id);
	}

}
