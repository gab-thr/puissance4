package Model;

public class Grid {
	public static final char EMPTY = '-';
	public static final char PLAYER1 = 'O';
	public static final char PLAYER2 = 'X';
	
	public int size;
	public char[][] grid;
	
	
	public Grid(int size) {
		this.size = size;
		
		grid = new char[size][size];
		
		for(int i = 0; i<size;i++ ) {
			for (int j=0; j<size;j++) {
				grid[i][j] = EMPTY;
			}
		}
	}
	
    public void print() {
    	for (int i =0; i<grid.length;i++) {
    		System.out.println(grid[i]);
    	}
    }
    
    public int getSize() {
    	return size;
    }
  
    public char getValue(int i, int j){
    	return grid[i][j];
    }
    
    public void setValue(int i, int j, char value) {
    	grid[i][j] = value;
    }
    

}
