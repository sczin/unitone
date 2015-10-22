package com.bayviewglen.unitone;

public class SodukuChecker {
	private static final int[][] PUZZLE = {
			{9,0,0,1,7,4,0,5,8},
			{1,7,8,0,2,5,6,4,0},
			{2,5,0,6,8,9,0,3,1},
			{0,2,1,4,0,7,5,0,6},
			{4,9,6,8,5,2,3,1,0},
			{7,3,0,9,6,0,8,2,0},
			{5,8,9,0,1,3,4,6,2},
			{3,0,7,2,0,6,9,0,5},
			{6,0,0,5,9,0,1,7,3}
	};
	private static final int[][] SOLUTION_ONE = {
			{9,6,3,1,7,4,2,5,8},
			{1,7,8,3,2,5,6,4,9},
			{2,5,4,6,8,9,7,3,1},
			{8,2,1,4,3,7,5,9,6},
			{4,9,6,8,5,2,3,1,7},
			{7,3,5,9,6,1,8,2,4},
			{5,8,9,7,1,3,4,6,2},
			{3,1,7,2,4,6,9,8,5},
			{6,4,2,5,9,8,1,7,3}
	};
	private static final int[][] SOLUTION_TWO = {
			{9,6,3,1,7,4,2,5,8},
			{1,7,8,3,2,5,6,4,9},
			{2,5,4,6,8,9,7,3,1},
			{8,2,1,4,3,9,5,9,6},
			{4,9,6,8,5,2,3,1,7},
			{7,3,5,9,6,1,8,2,5},
			{5,8,9,7,1,3,4,6,2},
			{3,1,7,2,4,6,9,8,5},
			{6,4,2,5,9,8,1,7,3}
	};
	public static void main(String[] args) {
	if(checkValid(SOLUTION_ONE)){
		if(solutionFitsPuzzle(SOLUTION_ONE, PUZZLE))
		System.out.println("VALID SOLUTION");
		else 
			System.out.println("INVALID SOLUTION");
	}else
		System.out.println("INVALID SOLUTION");
	}
	private static boolean solutionFitsPuzzle(int[][] solutionOne, int[][] puzzle2) {
		for (int i = 0;  i < puzzle2.length; i++) {
			for (int j = 0; j < puzzle2.length; j++) {
				if(puzzle2[i][j]!=0&&puzzle2[i][j]!=solutionOne[i][j])
					return false;
			}
		}
		return true;
	}
	public static boolean checkValid(int[][] solution){
		boolean valid = true;
		for (int i = 0; i < solution.length; i++) {
			for (int j = 0; j < solution.length; j++) {
				if(!checkVertical(i,j, solution)||
					!checkHorizontal(i,j, solution)||
					!checkSquare(i,j, solution))
					valid=false;
			}
		}
		return valid;
	}
	private static boolean checkSquare(int i, int j3, int[][] soduku) {
		for (int j = (i/3)*3; j <= (i/3)*3+2; j++) {
			for (int j2 = (j3/3)*3; j2 <= (j3/3)*3+2; j2++) {
				if(soduku[i][j3]==soduku[j][j2]&&j!=i&&j3!=j2)
					return false;
			}
			
		}
		return true;
	}
	private static boolean checkHorizontal(int i, int j3, int[][] soduku) {
			for (int j2 = 0; j2 < soduku.length; j2++) {
				if(soduku[i][j3]==soduku[i][j2]&&j3!=j2)
					return false;
			}
		return true;
	}
	private static boolean checkVertical(int i, int j3, int[][] soduku) {
			for (int j2 = 0; j2 < soduku.length; j2++) {
				if(soduku[i][j3]==soduku[j2][j3]&&j2!=i)
					return false;
			}

		return true;
	}
}
