package com.parfait.sample2048.model;

import com.parfait.sample2048.exception.BlockException;
import lombok.Data;

@Data
public class Block {

	private int value;

	public Block() {};
	public Block(int value) {
		this.value = value;
	}

	public void setValue(int value) {

		if (value < 0) {
			throw new BlockException("value must be positive");
		}

		this.value = value;
	}

	public static Block getInstanceWithRandomValue(int... values) {

		if (values == null) {
			throw new IllegalArgumentException("values can't be null");
		}
		
		if (values.length < 1) {
			throw new IllegalArgumentException("values length < 1");
		}
		
		int factor = ((int)(Math.random() * 10)) % 2;
		int value = (factor == 0 ? 2 : 4);
		
		Block block = new Block();
		block.setValue(value);
		
		return block;
	}


}
