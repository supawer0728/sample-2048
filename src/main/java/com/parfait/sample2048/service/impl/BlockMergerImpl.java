package com.parfait.sample2048.service.impl;

import com.parfait.sample2048.model.Block;
import com.parfait.sample2048.model.Point;
import com.parfait.sample2048.model.Table;
import com.parfait.sample2048.model.enums.Direction;
import com.parfait.sample2048.service.BlockMerger;

public class BlockMergerImpl implements BlockMerger {
	@Override
	public int mergeBlocksIfAbleToMergeAndReturnScore(Block[][] blocks, Direction direction) {

		int sumOfScore = 0;

		MergeTraversalDetail mergeTraversalDetail = new MergeTraversalDetail(direction);

		for (int rowIndex = mergeTraversalDetail.rowStartIndex; rowIndex != mergeTraversalDetail.rowEndIndex; rowIndex += mergeTraversalDetail.rowInterval) {
			for (int columnIndex = mergeTraversalDetail.columnStartIndex; columnIndex != mergeTraversalDetail.columnEndIndex; columnIndex += mergeTraversalDetail.columnInterval) {

				Point mergeTargetPoint = getValidMergeTargetPoint(blocks, rowIndex, columnIndex, direction);

				if (mergeTargetPoint == null) {
					continue;
				}

				sumOfScore += mergeSourceIntoTargetAndReturnScore(blocks, new Point(columnIndex, rowIndex), mergeTargetPoint);
			}
		}

		return sumOfScore;
	}

	private Point getValidMergeTargetPoint(Block[][] blocks, int rowIndex, int columnIndex, Direction direction) {

		if (blocks[rowIndex][columnIndex] == null) {
			return null;
		}

		if (isDirectionFacedOutOfEdge(rowIndex, columnIndex, direction)) {
			return null;
		}

		Point mergeTargetPoint = getMergeTargetPoint(columnIndex, rowIndex, direction);

		if (blocks[mergeTargetPoint.getY()][mergeTargetPoint.getX()] == null) {
			return null;
		}

		if (blocks[rowIndex][columnIndex].getValue() != blocks[mergeTargetPoint.getY()][mergeTargetPoint.getX()].getValue()) {
			return null;
		}

		return mergeTargetPoint;
	}

	private boolean isDirectionFacedOutOfEdge(int rowIndex, int columnIndex, Direction direction) {

		if (direction == Direction.UP && rowIndex == 0) {
			return true;
		} else if (direction == Direction.DOWN && rowIndex == Table.SIZE - 1) {
			return true;
		} else if (direction == Direction.LEFT && columnIndex == 0) {
			return true;
		} else if (direction == Direction.RIGHT && columnIndex == Table.SIZE - 1) {
			return true;
		}

		return false;
	}

	private Point getMergeTargetPoint(int columnIndex, int rowIndex, Direction direction) {

		int targetRowIndex = rowIndex;
		int targetColumnIndex = columnIndex;

		switch(direction) {
			case UP :
				targetRowIndex++;
				break;
			case DOWN :
				targetRowIndex--;
				break;
			case RIGHT :
				targetColumnIndex++;
				break;
			case LEFT :
				targetColumnIndex--;
				break;
		}

		return new Point(targetColumnIndex, targetRowIndex);
	}

	private int mergeSourceIntoTargetAndReturnScore(Block[][] blocks, Point sourcePoint, Point targetPoint) {
		int value = blocks[sourcePoint.getY()][sourcePoint.getX()].getValue();
		value += blocks[targetPoint.getY()][targetPoint.getX()].getValue();
		blocks[targetPoint.getY()][targetPoint.getX()].setValue(value);
		blocks[sourcePoint.getY()][sourcePoint.getX()] = null;
		return value;
	}

	@Override
	public boolean isAbleToMerge(Block[][] blocks, int rowIndex, int columnIndex, Direction direction) {

		if (getValidMergeTargetPoint(blocks, rowIndex, columnIndex, direction) == null) {
			return false;
		}

		return true;
	}

	class MergeTraversalDetail {
		int rowStartIndex;
		int rowEndIndex;
		int columnStartIndex;
		int columnEndIndex;
		int rowInterval;
		int columnInterval;

		MergeTraversalDetail(Direction direction) {
			switch (direction) {
				case UP :
					rowStartIndex = 0;
					rowEndIndex = Table.SIZE;
					columnStartIndex = 0;
					columnEndIndex = Table.SIZE;
					rowInterval = 1;
					columnInterval = 1;
					break;
				case DOWN :
					rowStartIndex = Table.SIZE - 1;
					rowEndIndex = -1;
					columnStartIndex = 0;
					columnEndIndex = Table.SIZE;
					rowInterval = -1;
					columnInterval = 1;
					break;
				case RIGHT :
					rowStartIndex = 0;
					rowEndIndex = Table.SIZE;
					columnStartIndex = Table.SIZE - 1;
					columnEndIndex = -1;
					rowInterval = 1;
					columnInterval = -1;
					break;
				case LEFT :
					rowStartIndex = 0;
					rowEndIndex = Table.SIZE;
					columnStartIndex = 0;
					columnEndIndex = Table.SIZE;
					rowInterval = 1;
					columnInterval = 1;
					break;
			}
		}
	}
}
