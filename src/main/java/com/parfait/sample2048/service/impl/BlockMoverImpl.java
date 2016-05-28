package com.parfait.sample2048.service.impl;

import com.parfait.sample2048.model.Block;
import com.parfait.sample2048.model.Table;
import com.parfait.sample2048.model.enums.Direction;
import com.parfait.sample2048.service.BlockMover;

public class BlockMoverImpl implements BlockMover {

	@Override
	public void moveBlocks(Block[][] blocks, Direction direction) {

		switch (direction) {
			case UP:
			case DOWN:
				break;
			case LEFT:
			case RIGHT:
				moveBlocksHorizontally(blocks, direction);
				break;
			default :
				throw new IllegalArgumentException(direction.name() + " is not valid argument");
		}
	}

	private void moveBlocksHorizontally(Block[][] blocks, Direction direction) {
		boolean isLeft = (direction == Direction.LEFT);

		int start = isLeft ? 0 : Table.SIZE - 1;
		int end = isLeft ? Table.SIZE : -1;
		int interval = isLeft ? 1 : -1;

		for (Block[] block : blocks) {

			moveBlocksHorizontallyInARow(block, start, end, interval);
		}
	}

	private void moveBlocksHorizontallyInARow(Block[] block, int start, int end, int interval) {

		for (int i = start; i != end; i += interval) {

			Integer emptyBlockIndex = findEmptyBlockIndexInARow(block, i, end, interval);

			if (emptyBlockIndex == null) {
				return;
			}

			Integer valuableBlockIndex = findValuableBlockIndexInARow(block, i + interval, end, interval);

			if (valuableBlockIndex == null) {
				return;
			}

			swapBlocksInARow(block, emptyBlockIndex, valuableBlockIndex);
		}
	}

	private Integer findEmptyBlockIndexInARow(Block[] blocks, int start, int end, int interval) {

		for (int i = start; i != end; i += interval) {
			if (blocks[i] == null) {
				return i;
			}
		}

		return null;
	}

	private Integer findValuableBlockIndexInARow(Block[] blocks, int start, int end, int interval) {

		for (int i = start; i != end; i += interval) {

			if (blocks[i] != null) {
				return i;
			}
		}

		return null;
	}

	private void swapBlocksInARow(Block[] blocks, Integer blockIndex1, Integer blockIndex2) {

		Block tempBlock = blocks[blockIndex1];
		blocks[blockIndex1] = blocks[blockIndex2];
		blocks[blockIndex2] = tempBlock;
	}
}
