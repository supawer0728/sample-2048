package com.parfait.parfait2048.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BlockTest {

	@Test
	public void testSetAndGetValue() {

		int value = 2;
		
		Block block = new Block();
		
		block.setValue(value);
		assertEquals(value, block.getValue());
	}
}
