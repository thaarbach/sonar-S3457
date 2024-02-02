package de.isys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Thomas Haarbach
 * Date: 02.02.24
 * Time: 14:32
 * Copyright 2024 iSYS-Software GmbH Munich
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
	static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		LOGGER.atInfo().log("Hello world");

		for (int i = 1; i <= 5; i++) {
			LOGGER.info("i = {}", i);
		}


	}
}