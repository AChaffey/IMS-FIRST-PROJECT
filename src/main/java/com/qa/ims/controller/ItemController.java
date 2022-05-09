package com.qa.ims.controller;

import java.lang.System.Logger;
import java.util.logging.LogManager;

import com.qa.ims.utils.Utils;

public class ItemController implements CrudController <items> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemDAO itemDAO;
	private Utils utils;

	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}
}
