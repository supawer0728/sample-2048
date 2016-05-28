package com.parfait.parfait2048.model;

public class Table {

	public static final int SIZE = 4;
	private Block[][] blocks = new Block[SIZE][SIZE];
	
	public Block[][] getBlocks() {
		return blocks;
	}
	public void setBlocks(Block[][] blocks) {
		this.blocks = blocks;
	}
	
	public Block createBlockToEmptySpace() {
		
		int row;
		int col;
		
		while(true) {
			row = ((int)(Math.random() * 100)) % SIZE;
			col = ((int)(Math.random() * 100)) % SIZE;
			
			if (blocks[row][col] == null) {
				break;
			}
		}
		
		int factor = ((int)(Math.random() * 10)) % 2;
		int value = (factor == 0 ? 2 : 4);
		
		Block block = new Block();
		block.setValue(value);
		blocks[row][col] = block;
		
		return block;
		
	}
	
	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<SIZE; i++) {
			for (int j=0; j<SIZE; j++) {
				sb.append(blocks[i][j] == null ? "*" : blocks[i][j].getValue());
				sb.append(" ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
