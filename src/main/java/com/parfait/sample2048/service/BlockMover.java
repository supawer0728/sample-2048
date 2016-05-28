package com.parfait.sample2048.service;

import com.parfait.sample2048.model.Block;
import com.parfait.sample2048.model.enums.Direction;

public interface BlockMover {

	void moveBlocks(Block[][] blocks, Direction direction);
}
