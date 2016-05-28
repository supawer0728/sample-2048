package com.parfait.parfait2048.model;

import org.junit.Test;

import com.parfait.parfait2048.exception.BlockException;

import static org.junit.Assert.*;

/**
 * 
 * @author JHJeon
 *
 */
public class BlockTest {

	@Test
	public void testSetAndGetValue() {

		int value = 2;
		
		Block block = new Block();
		
		block.setValue(value);
		assertEquals(value, block.getValue());
	}
	
	@Test
	public void testEquals() {
		int value = 2;
		
		Block block1 = new Block();
		block1.setValue(value);
		
		Block block2 = new Block();
		block2.setValue(value);
		
		assertTrue(block1.equals(block2));
		
		Block block3 = new Block();
		block3.setValue(1);
		
		assertFalse(block1.equals(block3));
	}
	
	@Test(expected = BlockException.class)
	public void testSetNegativeValue() {
		
		int value2 = -1;
		
		Block block = new Block();
		block.setValue(value2);
	}
}
