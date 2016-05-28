package com.parfait.sample2048.model.enums;

public enum Direction {
	UP("U"), DOWN("D"), LEFT("L"), RIGHT("R");

	private String code;

	Direction(String code) {
		this.code = code;
	}

	public static Direction getByCode(String code) {

		Direction[] directions = Direction.values();

		for (Direction direction : directions) {
			if (direction.code.equalsIgnoreCase(code)) {
				return direction;
			}
		}

		throw new IllegalArgumentException(code + " is not valid argument");
	}
}
