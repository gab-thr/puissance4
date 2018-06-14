package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.JTextArea;

import Controller.MainController;
import Model.Grid;
import Model.MainModel;
import Model.Player;
import puissanceQuatre.Main;

public class MainView {
	private static final int IMG_SIZE = 50;
	
	private MainController controller;
	private MainModel model;
	
	public JFrame frame;
	private JLabel[][] board = null;
	
	public static String text = "Player 1's turn";
	public JLabel label = new JLabel(text, SwingConstants.CENTER);
	
	final float saturation = 0.36f;
	final float luminance = 0.66f;
	final float hue = 0.55f;
	final Color frameColor = Color.getHSBColor(hue, saturation, luminance);
	
	final float saturation2 = 0.05f;
	final float luminance2 = 0.7f;
	final float hue2 = 0.55f;
	final Color btnColor = Color.getHSBColor(hue2, saturation2, luminance2);
	
    public static JButton inputButton = new JButton("Send");
    public static JTextArea editTextArea = new JTextArea("Enter Player1's name");
    public static JTextArea uneditTextArea = new JTextArea();
    private String pName1;
    
    public static JButton inputButton2 = new JButton("Send");
    public static JTextArea editTextArea2 = new JTextArea("Enter Player2's name");
    public static JTextArea uneditTextArea2 = new JTextArea();
    private String pName2;

	
	public MainView() {
		frame = new JFrame();
		frame.setTitle("Connect Four");
		frame.setLocation(550, 275);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setSize(800, 475);
		frame.setResizable(false);
		frame.getContentPane().setBackground(frameColor);
	}

	public void setController(MainController controller) {
		this.controller = controller;
	}
	public void setModel(MainModel model) {
		this.model = model;
	}
	
	public void initBoard() {
		frame.getContentPane().removeAll();
		board = new JLabel[model.getGrid().getSize()][model.getGrid().getSize()];
		for (int i = 0; i < board.length; i++) {
			 for (int j = 0; j < board[0].length; j++) {
				board[i][j] = new JLabel();
				board[i][j].setBounds(j * IMG_SIZE, i * IMG_SIZE, IMG_SIZE, IMG_SIZE);
				board[i][j].setIcon(new ImageIcon(model.getEmptyIcon()));
				
				frame.getContentPane().add(board[i][j]);
			 }
		}
		
		//initialisation de chaque bouton
		JButton[] btnList= new JButton[8];
		
		for(int i=0; i < btnList.length; i++) {
			final Integer innerI = new Integer(i);
			
			btnList[i] = new JButton();
			btnList[i].setText(""+(i+1));
			btnList[i].setBounds(IMG_SIZE*i, IMG_SIZE * 8, IMG_SIZE, IMG_SIZE);
			btnList[i].setBackground(btnColor);
			//if () {
			btnList[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.playerPlay(innerI);
				}
			});
			//}
			frame.getContentPane().add(btnList[i]);
		}
		
//		JButton btn0 = new JButton();
//		btn0.setText("1");
//		btn0.setBounds(0, IMG_SIZE * 8, IMG_SIZE, IMG_SIZE);
//		btn0.setBackground(btnColor);
//		btn0.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {	
//				controller.playerPlay(0);
//			}
//		});
//		
//		frame.getContentPane().add(btn0);
//		
//		JButton btn1 = new JButton();
//		btn1.setText("2");
//		btn1.setBounds(IMG_SIZE, IMG_SIZE * 8, IMG_SIZE, IMG_SIZE);
//		btn1.setBackground(btnColor);
//		btn1.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {	
//				controller.playerPlay(1);
//			}
//		});
//		
//		frame.getContentPane().add(btn1);
//		
//		JButton btn2 = new JButton();
//		btn2.setText("3");
//		btn2.setBounds(IMG_SIZE*2, IMG_SIZE * 8, IMG_SIZE, IMG_SIZE);
//		btn2.setBackground(btnColor);
//		btn2.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {	
//				controller.playerPlay(2);
//			}
//		});
//		
//		frame.getContentPane().add(btn2);
//		
//		JButton btn3 = new JButton();
//		btn3.setText("4");
//		btn3.setBounds(IMG_SIZE*3, IMG_SIZE * 8, IMG_SIZE, IMG_SIZE);
//		btn3.setBackground(btnColor);
//		btn3.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {	
//				controller.playerPlay(3);
//			}
//		});
//		
//		frame.getContentPane().add(btn3);
//		
//		JButton btn4 = new JButton();
//		btn4.setText("5");
//		btn4.setBounds(IMG_SIZE*4, IMG_SIZE * 8, IMG_SIZE, IMG_SIZE);
//		btn4.setBackground(btnColor);
//		btn4.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {	
//				controller.playerPlay(4);
//			}
//		});
//		
//		frame.getContentPane().add(btn4);
//		
//		JButton btn5 = new JButton();
//		btn5.setText("6");
//		btn5.setBounds(IMG_SIZE*5, IMG_SIZE * 8, IMG_SIZE, IMG_SIZE);
//		btn5.setBackground(btnColor);
//		btn5.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {	
//				controller.playerPlay(5);
//			}
//		});
//		
//		frame.getContentPane().add(btn5);
//		
//		JButton btn6 = new JButton();
//		btn6.setText("7");
//		btn6.setBounds(IMG_SIZE*6, IMG_SIZE * 8, IMG_SIZE, IMG_SIZE);
//		btn6.setBackground(btnColor);
//		btn6.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {	
//				controller.playerPlay(6);
//			}
//		});
//		
//		frame.getContentPane().add(btn6);
//		
//		JButton btn7 = new JButton();
//		btn7.setText("8");
//		btn7.setBounds(IMG_SIZE*7, IMG_SIZE * 8, IMG_SIZE, IMG_SIZE);
//		btn7.setBackground(btnColor);
//		btn7.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {	
//				controller.playerPlay(7);
//			}
//		});
//		
//		frame.getContentPane().add(btn7);
		
		// replay and exit buttons
		JButton playBtn = new JButton();
		playBtn.setText("Play Again");
		playBtn.setBounds(IMG_SIZE*11, 275 , 100, IMG_SIZE);
		playBtn.setBackground(btnColor);
		playBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text = "Player 1's turn";
				MainController.victory = false;
				MainController.draw = false;
				frame.setVisible(false);
				frame.dispose();
				Main.initGame();
			}
		});
		
		frame.getContentPane().add(playBtn);
		
		JButton quit = new JButton();
		quit.setText("Exit");
		quit.setBounds(IMG_SIZE*11, IMG_SIZE*7, 100, IMG_SIZE);
		quit.setBackground(btnColor);
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				frame.setVisible(false);
				frame.dispose(); 
			}
		});
		
		frame.getContentPane().add(quit);
		
		//Label with auto-update
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		label.setBorder(border);
		label.setBounds(IMG_SIZE*10, 125, 200, IMG_SIZE);
		label.setBackground(Color.WHITE);
		label.setOpaque(true);
		frame.getContentPane().add(label);
		
		JLabel title = new JLabel("<html><span style='font-size:20px'>"+ "Connect Four" +"</span></html>", SwingConstants.CENTER);
		title.setBounds(IMG_SIZE*10, IMG_SIZE*1 , 200, IMG_SIZE);
		frame.getContentPane().add(title);
		
		//text field to enter player's name
		inputButton.setBounds(625, IMG_SIZE*4, 76, IMG_SIZE/2 +1);
		inputButton.setBackground(btnColor);
		frame.add(inputButton);
		editTextArea.setBounds(IMG_SIZE*10, IMG_SIZE*4, 125, IMG_SIZE/2);
		frame.add(editTextArea);
		inputButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				pName1 = editTextArea.getText();
				editTextArea.setText("");
				System.out.println(pName1);
				model.getPlayer1().setName(pName1);
				updateView();
			}
		});
		
		inputButton2.setBounds(625, 226, 76, IMG_SIZE/2 +1);
		inputButton2.setBackground(btnColor);
		frame.add(inputButton2);
		editTextArea2.setBounds(IMG_SIZE*10, 226, 125, IMG_SIZE/2);
		frame.add(editTextArea2);
		inputButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				pName2 = editTextArea2.getText();
				editTextArea2.setText("");
				System.out.println(pName2);
				model.getPlayer2().setName(pName2);
				updateView();
			}
		});
		
		frame.setVisible(true);
	}


	public void updateView() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				 
				switch(model.getGrid().getValue(i, j)) {
				case Grid.EMPTY:
					board[i][j].setIcon(new ImageIcon(model.getEmptyIcon()));
					break;
				case Grid.PLAYER1:
					board[i][j].setIcon(new ImageIcon(Player.PLAYER1_ICON));
					break;
				case Grid.PLAYER2:
					board[i][j].setIcon(new ImageIcon(Player.PLAYER2_ICON));
					break;
				}
			}
		}
		
		if (MainController.victory == true) {
			text = model.getCurrentPlayer().getName() + " won";
			label.setText(text);
		}
		else if (MainController.draw == true) {
			text = "Draw";
			label.setText(text);
		}
		else if (MainController.victory == false & MainController.draw == false) {
			text = model.getCurrentPlayer().getName() + "'s turn";
			label.setText(text);
		}
		
	}
	
}