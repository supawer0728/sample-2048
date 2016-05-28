package com.parfait.sample2048.service;

import com.parfait.sample2048.model.Block;
import com.parfait.sample2048.model.Table;
import com.parfait.sample2048.model.enums.Direction;
import com.parfait.sample2048.service.impl.BlockMoverImpl;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertNotNull;

public class BlockMoverTest {

	@Test
	public void testMoveRight() throws Exception {

		Block[][] blocks = createRandomBlock2DArrays();

		BlockMover blockMover = new BlockMoverImpl();
		blockMover.moveBlocks(blocks, Direction.RIGHT);

		for (int i = 0; i < Table.SIZE; i++) {
			assertNotNull(blocks[i][Table.SIZE - 1]);
		}
	}

	@Test
	public void testMoveLeft() throws Exception {

		Block[][] blocks = createRandomBlock2DArrays();

		BlockMover blockMover = new BlockMoverImpl();
		blockMover.moveBlocks(blocks, Direction.LEFT);

		for (int i = 0; i < Table.SIZE; i++) {
			assertNotNull(blocks[i][0]);
		}
	}

	private Block[][] createRandomBlock2DArrays() throws InterruptedException {
		Block[][] blocks = new Block[Table.SIZE][Table.SIZE];

		Random random = new Random(System.currentTimeMillis());
		for (int i=0; i<Table.SIZE; i++) {
			int createIndex = random.nextInt(Table.SIZE);
			blocks[i][createIndex] = new Block(2);

			// 랜덤을 위한 대기시간 1 millisec
			Thread.sleep(1L);
		}

		return blocks;
	}
}
