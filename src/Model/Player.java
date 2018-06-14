package Model;

public class Player {
	public static final String PLAYER1_ICON = "img/red.png";
	public static final String PLAYER2_ICON = "img/black.png";
	
	private String nom;
	private char symbole;
	private String icon;
		
	public Player(String nom, char symbole, String icon) {
		this.nom = nom;
		this.symbole = symbole;
		this.icon = icon;
	}
	
	public String getName() {
		return nom;
	}
	public void setName(String nom) {
		this.nom = nom;
	}
	
	public char getSymbole() {
		return symbole;
	}
	public void setSymbole(char symbole) {
		this.symbole = symbole;
	}
	
	public String getPlayerIcon() {
		return icon;
	}
	
}
