package com.parfait.sample2048.service;

import com.parfait.sample2048.model.Table;
import com.parfait.sample2048.model.enums.Direction;

public interface TableService {

	Table getInitializedTable();
	boolean isGameOver(Table table);
	void move(Table table, Direction direction);
}
