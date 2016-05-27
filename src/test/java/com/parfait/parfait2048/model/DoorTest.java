package com.parfait.parfait2048.model;

import org.junit.Test;

public class DoorTest {

	@Test
	public void testOpen() {
		
		Door door = new Door();
		door.open();
		assertTrue(door.isOpened());
	}
	
	@Test
	public void testClose() {
		
	}
	
	@Test
	public void testLock() {
		
	}
}
