package de.isys;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

import static de.isys.AbstractTestClass.SyncCode.CHANGED;
import static de.isys.AbstractTestClass.SyncCode.DELETED;
import static de.isys.AbstractTestClass.SyncCode.EQUAL;
import static de.isys.AbstractTestClass.SyncCode.NO_OBJECT;

public abstract class AbstractTestClass {
	protected final Logger logger = LoggerFactory.getLogger(getClass());

	List<String> getSyncResult(String originalValue, String receivedValue) {
		originalValue = StringUtils.stripToEmpty(StringUtils.replace(originalValue, "\r\n", "\n"));
		receivedValue = StringUtils.stripToEmpty(StringUtils.replace(receivedValue, "\r\n", "\n"));
		if (originalValue.isEmpty()) {
			logger.debug("No system value for received value:\n{}.\nSyncCode: {}", receivedValue, DELETED);
			return Collections.singletonList(DELETED.getCode());
		}

		logger.debug("Trying to compare system value:\n{}\nwith received value: {}", originalValue, receivedValue);

		if (receivedValue.isEmpty()) {
			logger.debug("No value received for system value:\n{}.\nSyncCode: {}", originalValue, NO_OBJECT);
			return Collections.singletonList(NO_OBJECT.getCode());
		}

		if (receivedValue.equals(originalValue)) {
			logger.debug("System value and received value are equal. SyncCode: {}", EQUAL);
			return Collections.singletonList(EQUAL.getCode());
		} else {
			final int distance = LevenshteinDistance.getDefaultInstance().apply(originalValue, receivedValue);
			final String difference = StringUtils.difference(originalValue, receivedValue);
			final int position = StringUtils.indexOfDifference(originalValue, receivedValue);
			logger.debug("The system and received value are different.\nDistance: {}\nDifference: {}\nPosition :{}\nSyncCode: {}", distance, difference, position, CHANGED);
			return Collections.singletonList(CHANGED.getCode());
		}
	}
	@Getter
	protected enum SyncCode {
		EXCEPTION("-4"),
		NO_OBJECT("-2"),
		CHANGED("-1"),
		DELETED("0"),
		EQUAL("1"),
		NOT_UNIQUE("2");

		private final String code;

		SyncCode(String code) {
			this.code = code;
		}

	}
}
