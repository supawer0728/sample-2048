package com.parfait.sample2048.service;

import com.parfait.sample2048.model.Block;
import com.parfait.sample2048.model.Table;
import com.parfait.sample2048.model.enums.Direction;
import com.parfait.sample2048.service.impl.BlockMoverImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertNotNull;

public class BlockMoverTest {

	@Test
	public void testMoveRight() throws Exception {

		Block[][] blocks = createRandomBlock2DArraysForHorizontalMovement();

		BlockMover blockMover = new BlockMoverImpl();
		blockMover.moveBlocks(blocks, Direction.RIGHT);

		for (int i = 0; i < Table.SIZE; i++) {
			assertNotNull(blocks[i][Table.SIZE - 1]);
		}
	}

	@Test
	public void testMoveLeft() throws Exception {

		Block[][] blocks = createRandomBlock2DArraysForHorizontalMovement();

		BlockMover blockMover = new BlockMoverImpl();
		blockMover.moveBlocks(blocks, Direction.LEFT);

		for (int i = 0; i < Table.SIZE; i++) {
			assertNotNull(blocks[i][0]);
		}
	}

	/**
	 *
	 * 각 행당 random번째 열에 블록을 생성
	 *
	 * @return Block[][]
	 * @throws InterruptedException
	 */
	private Block[][] createRandomBlock2DArraysForHorizontalMovement() throws InterruptedException {
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

	@Test
	public void testMoveUp() throws Exception {

		Block[][] blocks = createRandomBlock2DArraysForVerticalMovement();

		BlockMover blockMover = new BlockMoverImpl();
		blockMover.moveBlocks(blocks, Direction.UP);

		for (int i = 0; i < Table.SIZE; i++) {
			assertNotNull(blocks[0][i]);
		}
	}

	@Test
	public void testMoveDown() throws Exception {

		Block[][] blocks = createRandomBlock2DArraysForVerticalMovement();

		BlockMover blockMover = new BlockMoverImpl();
		blockMover.moveBlocks(blocks, Direction.DOWN);

		for (int i = 0; i < Table.SIZE; i++) {
			assertNotNull(blocks[Table.SIZE - 1][i]);
		}
	}

	/**
	 *
	 * 각 열당 random번째 행에 블록을 생성
	 *
	 * @return Block[][]
	 * @throws InterruptedException
	 */
	private Block[][] createRandomBlock2DArraysForVerticalMovement() throws InterruptedException {
		Block[][] blocks = new Block[Table.SIZE][Table.SIZE];

		List<Integer> columIndexList = new ArrayList<Integer>();

		for (int i = 0; i < Table.SIZE; i++) {
			columIndexList.add(i);
		}

		Collections.shuffle(columIndexList);
		Random random = new Random(System.currentTimeMillis());
		for (Integer columIndex : columIndexList) {
			int rowIndex = random.nextInt(Table.SIZE);
			blocks[rowIndex][columIndex] = new Block(2);

			Thread.sleep(1L);
		}

		return blocks;
	}
}
