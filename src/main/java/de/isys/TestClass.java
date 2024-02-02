package de.isys;

import java.util.List;

public class TestClass extends AbstractTestClass {

	public List<String> doSth(String originalValue, String retrievedValue) {
		return getSyncResult(originalValue, retrievedValue);
	}
}
