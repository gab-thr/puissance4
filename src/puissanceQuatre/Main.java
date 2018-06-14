package puissanceQuatre;

import Controller.MainController;
//import Model.GUI;
//import Model.Game;
//import Model.Grid;
import Model.MainModel;
//import Model.Player;
import View.MainView;

public class Main {
	public final static int SIZE = 8;
	
	public static void main(String[] args) {

		initGame();

	}
	
	public static void initGame() {
		MainModel model = new MainModel(SIZE);
		MainView view = new MainView();
		MainController controller = new MainController(model,view);
		view.setController(controller);
		view.setModel(model);
		
		controller.play();
	}

}
