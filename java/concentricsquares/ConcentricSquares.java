import java.util.Scanner;

public class ConcentricSquares {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int rowFloor = 0;
		int colFloor = 0;
		int row = rowFloor;
		int col = colFloor;
		//The size of the array is 2 * num - 1
		int rowCeil = 2 * num - 1 - 1;
		int colCeil = 2 * num - 1 - 1;

		//1 - go right, 2 - go down, 3 - go left, 4 - go up
		int turn = 1;
		int[][] arr = new int[rowCeil + 1][colCeil + 1];
		while (num > 0) {
			while (turn == 1) {
				if (col <= colCeil) {
					arr[row][col] = num;
					++col;
				} else {
					++turn;
					row = ++rowFloor;
					col = colCeil;
				}
			}

			while (turn == 2) {
				if (row <= rowCeil) {
					arr[row][col] = num;
					++row;
				} else {
					++turn;
					col = --colCeil;
					row = rowCeil;
				}
			}

			while (turn == 3) {
				if (col >= colFloor) {
					arr[row][col] = num;
					--col;
				} else {
					++turn;
					col = colFloor;
					row = --rowCeil;
				}
			}
			while (turn == 4) {
				if (row >= rowFloor) {
					arr[row][col] = num;
					--row;
				} else {
					turn = 1;
					col = ++colFloor;
					row = rowFloor;
				}
			}
			--num;
		}

		for (int[] line : arr) {
			for (int value : line) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}
}
