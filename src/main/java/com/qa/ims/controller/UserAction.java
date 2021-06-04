package com.qa.ims.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.Utils;

/**
 * Action is a collection of commands which are used to determine the type of
 * function to apply to an entity.
 *
 */
public enum UserAction {
	YES("to enter item to the order"),NO("finish item selection");

	public static final Logger LOGGER = LogManager.getLogger();

	private String description;

	UserAction(String description) {
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
	public static void printUserActions() {
		for (UserAction useraction : UserAction.values()) {
			LOGGER.info(useraction.getDescription());
		}
	}

	/**
	 * Gets an action based on a users input. If user enters a non-specified
	 * enumeration, it will ask for another input.
	 * 
	 * @return Action type
	 */
	public static UserAction getUserAction(Utils utils) {
		UserAction useraction = null;
		do {
			try {
				useraction = UserAction.valueOf(utils.getString().toUpperCase());
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		} while (useraction == null);
		return useraction;
	}

}
