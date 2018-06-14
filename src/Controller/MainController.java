package Controller;

import Model.Grid;
import Model.MainModel;
import View.MainView;

public class MainController {
	private MainModel model;
	private MainView view;
	private static final int NB = 4;
	private static int compteur = 0;
	public static boolean victory = false;
	public static boolean draw = false;
	
	
	public MainController(MainModel model, MainView view) {
		this.model = model;
		this.view = view;
	}
	
	
	public void play() {
		view.initBoard();		
	}
	
	public void rePlay() {
		// Nettoyer le model
		
		play();		
	}
	
	public void playerPlay(int colonne) {		
		int i=model.getGrid().getSize()-1;
		
		while(victory == false & draw == false) {		
			do {
				if(model.getGrid().getValue(i, colonne) == Grid.EMPTY ) {
					model.getGrid().setValue(i, colonne, model.getCurrentPlayer().getSymbole());

					checkVictory();
					checkDraw();
					
					if (victory == true) {
						System.out.println("Victoire de " + model.getCurrentPlayer().getName());
						model.switchPlayer();
						view.updateView();
					} 
					else if (draw == true) {
						System.out.println("Egalité");
						view.updateView();
					}
					
					model.switchPlayer();
					view.updateView();
					return;
				}
				i--;				
			} while(i>=0);
		}
	}
	
	public void checkVictory() {
		checkFourCol(NB, model.getCurrentPlayer().getSymbole());
		checkFourRow(NB, model.getCurrentPlayer().getSymbole());
		checkFourDiagDown(NB, model.getCurrentPlayer().getSymbole());
		checkFourDiagUp(NB, model.getCurrentPlayer().getSymbole());
	}
	
	private void checkDraw() {
		compteur++;
		if (compteur == model.getGrid().getSize()*model.getGrid().getSize()) {
			draw = true;
		}
	}
	
	private boolean checkFourRow(int nb, char symbole) {
		for(int i =0; i<model.getGrid().getSize();i++) {
			int nbSymbole = 0;
			
			for (int j=0; j<model.getGrid().getSize();j++) {
				if(model.getGrid().getValue(i, j) == symbole) {
					nbSymbole++;
				}
				else {
					nbSymbole = 0;
				}
				if(nbSymbole>=nb) {
					victory = true;
					return victory;
				}
			}
		}
		return victory;
	}
	
	private boolean checkFourCol(int nb, char symbole) {
		for(int j =0; j<model.getGrid().getSize();j++) {
			int nbSymbole = 0;
			
			for (int i=0; i<model.getGrid().getSize();i++) {
				if(model.getGrid().getValue(i, j) == symbole) {
					nbSymbole++;
				}
				else {
					nbSymbole = 0;
				}
				if(nbSymbole>=nb) {
					victory = true;
					return victory;
				}
			}
		}
		return victory;
	}
	
	private boolean checkFourDiagDown(int nb, char symbole) {
		for(int i = 0; i<model.getGrid().getSize() - (nb-1);i++) {
			int nbSymbole = 0;
			
			for (int j=0;j<model.getGrid().getSize() - (nb-1);j++) {
				for (int n=0;n<nb;n++) {
					if(model.getGrid().getValue(i+n, j+n) == symbole) {
						nbSymbole++;
					}
					else {
						nbSymbole = 0;
					}
					if(nbSymbole>=nb) {
						victory = true;
						return victory;
					}
				}
				nbSymbole = 0;
			}
		}
		
		return victory;
	}
	
	private boolean checkFourDiagUp(int nb, char symbole) {
		for(int i = model.getGrid().getSize() - (nb-1); i<model.getGrid().getSize();i++) {
			int nbSymbole = 0;
			
			for (int j=0;j<model.getGrid().getSize() - (nb-1);j++) {
				for (int n=0;n<nb;n++) {
					if(model.getGrid().getValue(i-n, j+n) == symbole) {		
						nbSymbole++;
					}
					else {
						nbSymbole = 0;
					}
					if(nbSymbole>=nb) {
						victory = true;
						return victory;
					}
				}
				nbSymbole = 0;
			}
		}
		return victory;
	}
}
