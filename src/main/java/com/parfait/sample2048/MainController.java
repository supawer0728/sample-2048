package com.parfait.sample2048;

import com.parfait.sample2048.model.Table;
import com.parfait.sample2048.model.enums.Direction;
import com.parfait.sample2048.service.BlockMerger;
import com.parfait.sample2048.service.BlockMover;
import com.parfait.sample2048.service.TableService;
import com.parfait.sample2048.service.impl.BlockMergerImpl;
import com.parfait.sample2048.service.impl.BlockMoverImpl;
import com.parfait.sample2048.service.impl.TableServiceImpl;

import java.util.Scanner;

public class MainController {

	private static TableService tableService = new TableServiceImpl();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Table table = tableService.getInitializedTable();

		while(true) {
			if (tableService.isGameOver(table)) {
				printGameOver(table);
				return;
			}
			printTable(table);
			moveTable(table);
		}
	}

	private static void moveTable(Table table) {

		Direction direction = getInputedDirection();
		tableService.move(table, direction);
	}

	private static Direction getInputedDirection() {
		while(true) {
			try {
				System.out.println("(U)p, (D)own, (L)eft, (R)ight : ");
				String code = scanner.nextLine();
				Direction direction = Direction.getByCode(code);
				return direction;
			} catch (IllegalArgumentException e) {
				System.out.println("Please, input only U, D, L, R.");
			}
		}
	}

	private static void printGameOver(Table table) {
		System.out.println("***** GAME OVER *****");
		System.out.println("score : " + table.getScore());
		System.out.println(table);
	}

	private static void printTable(Table table) {
		System.out.println();
		System.out.println(table);
	}
}
