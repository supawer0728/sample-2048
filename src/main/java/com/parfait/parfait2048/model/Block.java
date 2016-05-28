package com.parfait.parfait2048.model;

import com.parfait.parfait2048.exception.BlockException;

public class Block {

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) throws BlockException {
		
		if (value < 0) {
			throw new BlockException("value can't be less than 0");
		}
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Block other = (Block) obj;
		if (value != other.value)
			return false;
		return true;
	}
	
	
}
