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
				moveBlocksVertically(blocks, direction);
				break;
			case LEFT:
			case RIGHT:
				moveBlocksHorizontally(blocks, direction);
				break;
			default :
				throw new IllegalArgumentException(direction.name() + " is not valid direction");
		}
	}

	private void moveBlocksVertically(Block[][] blocks, Direction direction) {
		boolean isUp = (direction == Direction.UP);

		int start = isUp ? 0 : Table.SIZE - 1;
		int end = isUp ? Table.SIZE : -1;
		int interval = isUp ? 1 : -1;

		for (int columnIndex = 0; columnIndex < Table.SIZE; columnIndex++) {

			moveBlocksVerticallyInAColumn(blocks, columnIndex, start, end, interval);
		}
	}

	private void moveBlocksVerticallyInAColumn(Block[][] blocks, int columnIndex, int start, int end, int interval) {

		for (int rowIndex = start; rowIndex != end; rowIndex += interval) {
			Integer emptyBlockRowIndex = findEmptyBlockIndexInAColumn(blocks, columnIndex, start, end, interval);
			if (emptyBlockRowIndex == null) {
				return;
			}

			Integer valuableBlockRowIndex = findValuableBlockIndexInAColumn(blocks, columnIndex, start + interval, end, interval);
			if (valuableBlockRowIndex == null) {
				return;
			}

			swapBlocksInAColumn(blocks, columnIndex, emptyBlockRowIndex, valuableBlockRowIndex);
		}
	}

	private Integer findEmptyBlockIndexInAColumn(Block[][] blocks, int columnIndex, int start, int end, int interval) {

		for (int rowIndex = start; rowIndex != end; rowIndex += interval) {
			if (blocks[rowIndex][columnIndex] == null) {
				return rowIndex;
			}
		}

		return null;
	}

	private Integer findValuableBlockIndexInAColumn(Block[][] blocks, int columnIndex, int start, int end, int interval) {

		for (int rowIndex = start; rowIndex != end; rowIndex += interval) {
			if (blocks[rowIndex][columnIndex] != null) {
				return rowIndex;
			}
		}

		return null;
	}

	private void swapBlocksInAColumn(Block[][] blocks, int columnIndex, Integer rowIndex1, Integer rowIndex2) {
		Block tempBlock = blocks[rowIndex1][columnIndex];
		blocks[rowIndex1][columnIndex] = blocks[rowIndex2][columnIndex];
		blocks[rowIndex2][columnIndex] = tempBlock;
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

	private void moveBlocksHorizontallyInARow(Block[] blocks, int start, int end, int interval) {

		for (int columnIndex = start; columnIndex != end; columnIndex += interval) {

			Integer emptyBlockColumnIndex = findEmptyBlockIndexInARow(blocks, columnIndex, end, interval);

			if (emptyBlockColumnIndex == null) {
				return;
			}

			Integer valuableBlockColumnIndex = findValuableBlockIndexInARow(blocks, columnIndex + interval, end, interval);

			if (valuableBlockColumnIndex == null) {
				return;
			}

			swapBlocksInARow(blocks, emptyBlockColumnIndex, valuableBlockColumnIndex);
		}
	}

	private Integer findEmptyBlockIndexInARow(Block[] blocks, int start, int end, int interval) {

		for (int columnIndex = start; columnIndex != end; columnIndex += interval) {
			if (blocks[columnIndex] == null) {
				return columnIndex;
			}
		}

		return null;
	}

	private Integer findValuableBlockIndexInARow(Block[] blocks, int start, int end, int interval) {

		for (int columnIndex = start; columnIndex != end; columnIndex += interval) {

			if (blocks[columnIndex] != null) {
				return columnIndex;
			}
		}

		return null;
	}

	private void swapBlocksInARow(Block[] blocks, Integer columnIndex1, Integer columnIndex2) {

		Block tempBlock = blocks[columnIndex1];
		blocks[columnIndex1] = blocks[columnIndex2];
		blocks[columnIndex2] = tempBlock;
	}
}
