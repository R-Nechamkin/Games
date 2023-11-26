package ticTacToe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.IllegalGameSetupException;
import exceptions.IllegalMoveException;
import gridGames.GameInfo;

/**
 * This class is intended to test the Player class
 * @author rnech
 *
 */
class PlayerTest {
	static Player human;
	
	/**
	 * Sets up the human player which will be used to play
	 * @throws IllegalGameSetupException 
	 */
	@BeforeEach
	void setUp() throws IllegalGameSetupException {
		GameInfo info = new TTTGameInfo(human, null, new TicTacToeBoard());
		human = new HumanPlayer(info);
	}
	
	@Test
	void OneLessPieceAfterPlayMethodIsCalled() {
		int startPieces = human.getNumPieces(); 
		try {
			human.play(new TTTPosition('A', '1'));
		} catch (IllegalMoveException e) {
			fail("Placing a piece in position A1 threw an IllegalMoveException\n" + e.getStackTrace());
		}
		assertEquals(startPieces - 1, human.getNumPieces());
	}
	
	@Test
	void PlayMethodReturnsProperDescriptionOfMove() throws IllegalArgumentException, IllegalMoveException {
		char[] move = {'X', 'A', '1'};
		char[] result = human.play(new TTTPosition('A', '1'));
		assertArrayEquals(move, result);
	}

}