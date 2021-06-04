package com.qa.ims.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.Utils;

/**
 * Action is a collection of commands which are used to determine the type of
 * function to apply to an entity.
 *
 */
public enum UpdateOrderAction {
	ADD("Add item to the order"),DELETE("delete item in the order");

	public static final Logger LOGGER = LogManager.getLogger();

	private String description;

	UpdateOrderAction(String description) {
		this.description = description;
	}

	/**
	 * Describes the action
	 */
	public String getDescription() {
		return this.name() + ": " + this.description;
	}

	/**
	 * Prints out all possible actions
	 */
	public static void printUpdateOrderActions() {
		for (UpdateOrderAction updateOrderAction : UpdateOrderAction.values()) {
			LOGGER.info(updateOrderAction.getDescription());
		}
	}

	/**
	 * Gets an action based on a users input. If user enters a non-specified
	 * enumeration, it will ask for another input.
	 * 
	 * @return Action type
	 */
	public static UpdateOrderAction getUpdateOrderAction(Utils utils) {
		UpdateOrderAction updateOrderAction = null;
		do {
			try {
				updateOrderAction = UpdateOrderAction.valueOf(utils.getString().toUpperCase());
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		} while (updateOrderAction == null);
		return updateOrderAction;
	}

}
