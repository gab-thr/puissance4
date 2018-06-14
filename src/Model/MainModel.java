package Model;

public class MainModel {	
	private Grid grid;
	private Player player1;
	private Player player2;
	private Player currentPlayer;
	private static final String EMPTY_ICON = "img/empty.png"; 
	
	public MainModel(int gridSize) {
		grid = new Grid(gridSize);
		
		player1 = new Player("Player 1", Grid.PLAYER1, Player.PLAYER1_ICON);
		player2 = new Player("Player 2", Grid.PLAYER2, Player.PLAYER2_ICON);
		
		currentPlayer = player1;
	}
	
	public String getEmptyIcon() {
		return EMPTY_ICON;
	}
	
	public Grid getGrid() {
		return grid;
	}
	
	public Player getPlayer1() {
		return player1;
	}
	
	public Player getPlayer2() {
		return player2;
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void switchPlayer() {
		if (currentPlayer == player1) {
			currentPlayer = player2; 
		}
		else if(currentPlayer == player2) {
			currentPlayer = player1;
		}
	}
	public void clearModel(int gridSize) {
		grid = new Grid(gridSize);
		
		player1 = new Player("Player 1", Grid.PLAYER1, Player.PLAYER1_ICON);
		player2 = new Player("Player 2", Grid.PLAYER2, Player.PLAYER2_ICON);
		
		currentPlayer = player1;
	}
}
