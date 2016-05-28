package com.parfait.sample2048.model;

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
