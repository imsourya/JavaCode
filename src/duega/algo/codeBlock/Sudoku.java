package duega.algo.codeBlock;

public class Sudoku {

	public boolean canBePlacedHere(char[][] board, int num, int i, int j) {

		return false;
	}

	public void solveSudokuRec( char[][] board, int row) {

		if(row == board.length-1) {
			for(int i=0; i<board[0].length;i++) {
				if(board[row][i]!='.') {

				}
			}
		}

		for(int col = 0; col < board.length; col++) {
			if(board[row][col] != '.') continue;
			for(int num = 1; num<=9; num++) {
				if(canBePlacedHere(board, num, row, col)) {
					
				}
			}
		}


	}

	public void solveSudoku(char[][] board) {
		solveSudokuRec(board,0);
	}

	public static void main(String[] args) {

		Sudoku s = new Sudoku();

		char board[][] = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

		s.solveSudoku(board);
	}
}
