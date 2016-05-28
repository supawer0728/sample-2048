package com.parfait.sample2048.model;

import com.parfait.sample2048.model.enums.Direction;
import com.parfait.sample2048.service.BlockMerger;
import com.parfait.sample2048.service.impl.BlockMergerImpl;
import lombok.Data;

@Data
public class Table {

	public static final String NULL_BLOCK_EXPRESSION = "*";
	public static final int SIZE = 4;
	private Block[][] blocks = new Block[SIZE][SIZE];

	public Block createBlockToEmptySpace() {

		Point emptyPoint = getEmptyPointInTable();
		Block block = Block.getInstanceWithRandomValue(2, 4);
		blocks[emptyPoint.getY()][emptyPoint.getX()] = block;

		return block;
	}

	private Point getEmptyPointInTable() {

		int randomFactor = 100;

		while(true) {
			int row = ((int)(Math.random() * randomFactor)) % SIZE;
			int col = ((int)(Math.random() * randomFactor)) % SIZE;

			if (blocks[row][col] == null) {
				return new Point(col, row);
			}
		}
	}

	public boolean isContinuable() {
		return !isFull() || hasBlocksAbleToMerge();
	}

	private boolean hasBlocksAbleToMerge() {

		BlockMerger blockMerger = new BlockMergerImpl();

		for (int rowIndex = 0; rowIndex < SIZE; rowIndex++) {
			for (int columnIndex = 0; columnIndex < SIZE; columnIndex++) {
				for (Direction direction : Direction.values()) {
					if (blockMerger.isAbleToMerge(blocks, rowIndex, columnIndex, direction)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private boolean isFull() {

		for (Block[] blockArray : blocks) {
			for (Block block : blockArray) {
				if (block == null) {
					return false;
				}
			}
		}

		return true;
	}
	
	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<SIZE; i++) {
			for (int j=0; j<SIZE; j++) {
				sb.append(blocks[i][j] == null ? NULL_BLOCK_EXPRESSION : blocks[i][j].getValue());
				sb.append(" ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
