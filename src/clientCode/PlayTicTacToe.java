package clientCode;

import java.util.Scanner;

import exceptions.IllegalGameSetupException;
import general.BoardGame;
import gridGames.GameInfo;
import ticTacToe.ComputerPlayer;
import ticTacToe.HumanPlayer;
import ticTacToe.TTTGameInfo;
import ticTacToe.TicTacToe;
import ticTacToe.TicTacToeBoard;
import validation.*;

public class PlayTicTacToe {

	public static void main(String[] args) {
		Validation val = new ConsoleValidation(new Scanner(System.in));
		
		try {
			GameInfo gInfo = new TTTGameInfo(new HumanPlayer(), new ComputerPlayer(), new TicTacToeBoard());
			
			BoardGame game = new TicTacToe(gInfo);
			do {
				game.setUpGame();
				System.out.println(game.seeBoard());
				String winner = game.startGame();
				System.out.println(winner + " won the game.");
			} while (val.askAgain("play another game", "play another game of Tic-Tac-Toe", "quit"));
		} catch (IllegalGameSetupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		System.out.println("Goodbye");
	}

}