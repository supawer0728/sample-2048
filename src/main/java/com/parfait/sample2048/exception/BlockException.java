package com.parfait.sample2048.exception;

public class BlockException extends RuntimeException {

	public BlockException() {}
	public BlockException(String message) {
		super(message);
	}
}
