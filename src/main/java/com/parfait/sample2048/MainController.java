package com.parfait.sample2048;

import com.parfait.sample2048.model.Table;
import com.parfait.sample2048.model.enums.Direction;
import com.parfait.sample2048.service.BlockMerger;
import com.parfait.sample2048.service.BlockMover;
import com.parfait.sample2048.service.impl.BlockMergerImpl;
import com.parfait.sample2048.service.impl.BlockMoverImpl;

import java.util.Scanner;

public class MainController {

	public static final int INITAL_BLOCK_COUNT = 2;
	private static Scanner scanner = new Scanner(System.in);
	private static BlockMover blockMover = new BlockMoverImpl();
	private static BlockMerger blockMerger = new BlockMergerImpl();

	public static void main(String[] args) {

		Table table = getInitializedTable();

		while(true) {
			if (!table.isContinuable()) {
				printGameOver(table);
				return;
			}

			printTable(table);
			moveTable(table);
		}
	}

	private static void moveTable(Table table) {
		String code;
		Direction direction;
		while(true) {
			try {
				System.out.println("(U)p, (D)own, (L)eft, (R)ight : ");
				code = scanner.nextLine();
				direction = Direction.getByCode(code);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Please, input only U, D, L, R.");
			}
		}

		blockMover.moveBlocks(table.getBlocks(), direction);
		int score = blockMerger.mergeBlocksIfAbleToMergeAndReturnScore(table.getBlocks(), direction);
		blockMover.moveBlocks(table.getBlocks(), direction);

		table.addScore(score);

		if (score != 0) {
			table.createBlockToEmptySpace();
		}
	}

	private static void printGameOver(Table table) {
		System.out.println("***** GAME OVER *****");
		System.out.println(table);
	}

	private static void printTable(Table table) {
		System.out.println();
		System.out.println(table);
	}

	private static Table getInitializedTable() {
		Table table = new Table();
		for (int i = 0; i < INITAL_BLOCK_COUNT; i++) {
			table.createBlockToEmptySpace();
		}

		return table;
	}
}
