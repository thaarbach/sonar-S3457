package de.isys;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static de.isys.AbstractTestClass.SyncCode.EQUAL;
import static org.junit.jupiter.api.Assertions.*;

class TestClassTest {

	@Test
	void doSth() {
		final TestClass testClass = new TestClass();
		final List<String> syncResult = testClass.getSyncResult("hello", "hello");

		assertEquals(Collections.singletonList(EQUAL.getCode()),syncResult);
	}
}