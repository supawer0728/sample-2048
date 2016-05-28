package com.parfait.sample2048.service;

import com.parfait.sample2048.model.Block;
import com.parfait.sample2048.model.Table;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertNotNull;

public class BlockMoverTest {

	@Test
	public void testMoveRight() throws Exception {

		Block[][] blocks = new Block[Table.SIZE][Table.SIZE];

		Random random = new Random(System.currentTimeMillis());
		int createIndex = random.nextInt(Table.SIZE);
		for (int i=0; i<Table.SIZE; i++) {
			blocks[i][createIndex] = new Block(2);
		}

		BlockMover blockMover = new BlockMoverImpl();
		blockMover.moveBlocks(blocks);

		for (int i = 0; i < Table.SIZE; i++) {
			assertNotNull(blocks[i][Table.SIZE - 1]);
		}
	}
}
