package com.parfait.sample2048.service;

import com.parfait.sample2048.model.Block;
import com.parfait.sample2048.model.Table;
import com.parfait.sample2048.model.enums.Direction;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNull;

public class BlockMergerTest {

	@Test
	public void testMergeRight() throws Exception {

		Block[][] blocks = createTestBlocksForMergeHorizontally();

		BlockMerger blockMerger = new BlockMergerImpl();
		blockMerger.mergeBlocks(blocks, Direction.RIGHT);

		assertNull(blocks[0][0]);
		assertEquals(4, blocks[0][1]);
	}

	private Block[][] createTestBlocksForMergeHorizontally() {

		Block[][] blocks = new Block[Table.SIZE][Table.SIZE];

		blocks[0][0] = new Block(2);
		blocks[0][1] = new Block(2);

		return blocks;
	}
}
