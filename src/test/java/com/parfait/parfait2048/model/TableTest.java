package com.parfait.parfait2048.model;

import org.junit.Test;

public class TableTest {

	@Test
	public void testToString() {
		
		Table table = new Table();
		table.createBlockToEmptySpace();
		table.createBlockToEmptySpace();
		
		System.out.println(table.toString());
	}
}
