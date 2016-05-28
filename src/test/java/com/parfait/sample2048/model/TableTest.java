package com.parfait.sample2048.model;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TableTest {

	@Test
	public void testCreateBlocks() {

		Table table = new Table();

		int createBlockRepeatCount = 10;

		for (int i = 0; i < createBlockRepeatCount; i++) {
			table.createBlockToEmptySpace();
		}

		String[] values = StringUtils.split(table.toString(), " \n");
		int sumOfPositiveValues = 0;
		for(String value : values) {

			if (!Table.NULL_BLOCK_EXPRESSION.equals(value)) {
				sumOfPositiveValues++;
			}
		}

		assertEquals(createBlockRepeatCount, sumOfPositiveValues);
	}
}
