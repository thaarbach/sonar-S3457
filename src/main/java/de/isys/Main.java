package de.isys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		final TestClass testClass = new TestClass();

		testClass.getSyncResult("hello", "hello");


	}
}