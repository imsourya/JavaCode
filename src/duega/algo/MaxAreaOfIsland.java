package duega.algo;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxAreaOfIsland {
	
	static class Cell{
		int row;
		int col;
		Cell(int row, int col){
			this.row = row;
			this.col = col;
		}
	}
	
	private static boolean isSafe(int[][] grid, Cell c, boolean visited[][]) {
		return (c.row >=0 && c.row<grid.length) && 
				(c.col>=0 && c.col<grid[0].length) && 
				(grid[c.row][c.col]==1) && 
				(! visited[c.row][c.col]);
	}
	
	private static int countArea(int[][] grid, int row, int col, boolean visited[][]) {

		int hMove[] = {0,0, 1,-1};
		int vMove[] = {1,-1,0, 0};
		
		Queue<Cell> q = new ArrayDeque<Cell>();
		q.add(new Cell(row,col));
		 
		int Area = 1;  // 1 for the added Cell in Queue
		visited[row][col] = true;
		// BFS way to iterate all area
		while(! q.isEmpty()) {
			Cell c = q.poll();
			for(int i = 0; i<4;i++) {
				Cell c1 = new Cell(c.row+hMove[i], c.col+vMove[i]);
				if(isSafe(grid,c1, visited)) {
					q.add(c1);
					Area++;
					visited[c1.row][c1.col] = true;
				}
			}
		}
		
		return Area;
	}
	
	private static int maxAreaOfIsland(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;
		boolean visited[][] = new boolean[m][n];
		
		for(int i=0;i<m;i++) {
			for(int j=0; j<n; j++) {
				visited[i][j] = false;
			}
		}
		
		int maxArea = 0;
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j] == 1 && (!visited[i][j])) {
					int currArea = countArea(grid, i, j, visited);
					if(currArea > maxArea) {
						maxArea = currArea;
					}
				}
			}
		}
		
		return maxArea;
	}
	
	public static void main(String[] args) {
	
		int grid[][] = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
		//int grid[][] = {{0,0,1}, {0,0,1}, {0,0,1}};
		System.out.println(maxAreaOfIsland(grid));
	}
}
