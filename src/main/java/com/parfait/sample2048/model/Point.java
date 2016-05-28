package com.parfait.sample2048.model;

import lombok.Data;

@Data
public class Point {
	private int x;
	private int y;

	public Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}