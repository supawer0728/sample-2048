package com.parfait.sample2048.service;

import com.parfait.sample2048.model.Block;
import com.parfait.sample2048.model.enums.Direction;

public interface BlockMerger {
	int mergeBlocksIfAbleToMergeAndReturnScore(Block[][] blocks, Direction direction);
	boolean isAbleToMerge(Block[][] blocks, int rowIndex, int columnIndex, Direction direction);
}
