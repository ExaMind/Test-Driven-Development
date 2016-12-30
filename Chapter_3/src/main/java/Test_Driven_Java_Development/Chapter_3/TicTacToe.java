package Test_Driven_Java_Development.Chapter_3;

import java.util.Arrays;

/**
 * TicTacToe game
 *
 */
public class TicTacToe {
  
	int[][] board = new int[3][3];
	int lastPlayer = 2;
	String result;
	
	public String play(int x, int y) {
		
		checkBounds(x);
		checkBounds(y);
		lastPlayer = nextPlayer();
		setMark(x,y);
		
		result = winner();
		
		return result;
	}
	
	private void checkBounds(int point){
		
		if(point<1 || point>3) throw new RuntimeException("Placed out of bounds");
	}
	
	/**
	 * Sets the mark on a box
	 */
	public void setMark(int x, int y) {
		if(board[x-1][y-1] != 0) throw new RuntimeException("Spot is taken");
		else {board[x-1][y-1] = lastPlayer;}
	
	}
	
	/**
	 * Returns the next player's turn
	 */ 
	public int nextPlayer() {
		
		if(lastPlayer == 1) return 2; //1 represents X, 2 represents O
		else return 1;
	}
	
	/**
	 * 
	 * @return
	 */
	public String winner() {
		
		String result = "No Winner";
		
		if(checkColumnsForX() == true) result = "X is the Winner";
		else  if(checkColumnsForO() == true) result = "O is the Winner";
		else  if(checkRowsForX() == true) result = "X is the Winner";
		else  if(checkRowsForO() == true) result = "O is the Winner";
		else  if(checkDiagonalForO() == true) result = "O is the Winner";
		else  if (checkDiagonalForX() == true) result ="X is the Winner";
		
		return result;
	}
	
	
	/**
	 * Checks to see if vertical columns are occupied by X mark
	 */
	private boolean checkColumnsForX(){
		
		int[] arr = new int[3];
		boolean bool = false;
		
		for(int column=0; column<3 ; column++) {
			
			for(int row=0; row<3; row++) {
				if(board[column][row]==1) arr[row]=1;
			}
			
			if(arr[0]==1 && arr[1]==1 && arr[2]==1) { bool=true; break;}
		}
		
		return bool;
	}
	
	/**
	 * 
	 */
	private boolean checkRowsForX() {
		
		int[] arr = new int[3];
		boolean bool = false;
		
		for(int column=0; column<3 ; column++) {
			
			for(int row=0; row<3; row++) {
				if(board[row][column]==1) arr[row]=1;
			}
			
			if(arr[0]==1 && arr[1]==1 && arr[2]==1) { bool=true; break;}
		}
		
		return bool;
		
	}
	
	/**
	 * 
	 */
	private boolean checkRowsForO() {
		
		int[] arr = new int[3];
		boolean bool = false;
		
		for(int column=0; column<3 ; column++) {
			
			for(int row=0; row<3; row++) {
				if(board[row][column]==2) arr[row]=1;
			}
			
			if(arr[0]==1 && arr[1]==1 && arr[2]==1) { bool=true; break;}
		}
		
		return bool;
		
	}
	
	/**
	 * Checks to see if vertical columns are occupied by same Y mark
	 */
	private boolean checkColumnsForO(){
		
		int[] arr = new int[3];
		boolean bool = false;
		
		for(int column=0; column<3 ; column++) {
			
			for(int row=0; row<3; row++) {
				if(board[column][row]==2) arr[row]=1;
			}
			
			if(arr[0]==1 && arr[1]==1 && arr[2]==1) { bool=true; break;}
		}
		
		return bool;
	}
	
	/**
	 * 
	 */
	private boolean checkDiagonalForO() {
	
		
		if(board[0][0]==2 && board[1][1]==2 && board[2][2]==2) return true;
		else return false;
		
	}
	
	/**
	 * 
	 */
	private boolean checkDiagonalForX() {
		
		if(board[0][0]==1 && board[1][1]==1 && board[2][2]==1) return true;
		else return false;
	}
}
