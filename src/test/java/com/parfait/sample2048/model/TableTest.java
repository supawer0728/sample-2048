package com.parfait.sample2048.model;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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

	@Test
	public void testIsContinuable() throws Exception {

		Table table = new Table();

		Block[][] blocks = new Block[Table.SIZE][Table.SIZE];
		for (int rowIndex = 0; rowIndex < Table.SIZE; rowIndex++) {
			for (int columnIndex = 0; columnIndex < Table.SIZE; columnIndex++) {

				blocks[rowIndex][columnIndex] = new Block((rowIndex + columnIndex ) % 2 == 0 ? 2 : 4);
			}
		}

		table.setBlocks(blocks);

		assertFalse(table.isContinuable());
	}
}
