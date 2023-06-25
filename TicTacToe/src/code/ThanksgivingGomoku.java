package code;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

//this is a game: basically like tic tac toe but with 5 in a row
// simply click on the squares to play

public class ThanksgivingGomoku extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JPanel panel = new JPanel();
	private GameButtons[] buttons = new GameButtons[225];
	private int turn = 0;
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		GameButtons source = (GameButtons)actionEvent.getSource();
		
		if (turn == 0) {
			source.toggleX();
			setTitle("O Turn");
		} 
		else if (turn == 1){
			source.toggleO();
			setTitle("X Turn");
			
		}
		turn = (turn + 1) % 2;
	}

	public static void main(String[] args) {
		
		new ThanksgivingGomoku();

	}
	
	public ThanksgivingGomoku() {
		setTitle("Gomoku");
		setSize(900,900);

		setLocation(100,100);
		getContentPane().setBackground(Color.CYAN);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel.setLayout(new GridLayout(15, 15));
		panel.setBackground(new Color(30, 92, 38));
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new GameButtons();
			buttons[i].addActionListener(this);
			panel.add(buttons[i]);
		}
		add(panel);

		setVisible(true);
	}

}
