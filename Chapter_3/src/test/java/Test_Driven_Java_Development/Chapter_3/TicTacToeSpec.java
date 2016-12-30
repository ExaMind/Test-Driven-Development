package Test_Driven_Java_Development.Chapter_3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import org.junit.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Tests for the TicTacToe game.
 */
public class TicTacToeSpec {
	
    @Rule
    public ExpectedException exception = ExpectedException.none();
    private TicTacToe ticTacToe;
    
    @Before
    public final void before() {
    	ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXisOutsideOfBoardThenRuntimeException() {
    	
    	exception.expect(RuntimeException.class);
    	ticTacToe.play(4,1);
    	
    }
    
    @Test
    public void whenYisOutsideOfBoardThenRuntimeException() {
    	
    	exception.expect(RuntimeException.class);
    	ticTacToe.play(1,4);
    }
    
    @Test
    public void whenSpaceTakenThenRuntimeException() {
    	
    	ticTacToe.play(1,1);
    	exception.expect(RuntimeException.class);
    	ticTacToe.play(1,1);
    }
   
    @Test
    public void givenFirstTurnThenX() {

    	assertEquals(1, ticTacToe.nextPlayer()); //1 represents X
    }
    
    @Test
    public void givenLastTurnWasX_NextPlayerIsO () {
    	
    	ticTacToe.play(2,3);
    	assertEquals(2, ticTacToe.nextPlayer()); //0 represents O
    }
    
    @Test
    public void givenLastTurnWasO_NextPlayerIsX () {
    	
    	ticTacToe.play(2, 2);
    	ticTacToe.play(3, 3);
    	assertEquals(1, ticTacToe.nextPlayer());
    }
    
    @Test
    public void givenThatOnlyOnePlayerhasPlayed_thenNoWinner() {
    	
    	String result = ticTacToe.play(1,1);
    	assertEquals("No Winner", result);
    }
    
    @Test
    public void whenColumnIsFilledWithX_thenWinnerIsX() {
    	
    	ticTacToe.play(1, 1); //X
    	ticTacToe.play(2, 1);//O
    	ticTacToe.play(1, 2);//X
    	ticTacToe.play(3, 1);//O

    	String result = ticTacToe.play(1, 3);//X
    	
    	assertEquals("X is the Winner", result);
    }
    
    @Test
    public void whenColumnIsFilledWithY_thenWinnerIsO() {
    	
    	ticTacToe.play(2,1);//X
    	ticTacToe.play(1,1);//o
    	ticTacToe.play(3,1);//x
    	ticTacToe.play(1, 2);//o
    	ticTacToe.play(3, 2);//x
    	
    	String result = ticTacToe.play(1,3);//o
    	
    	assertEquals("O is the Winner", result);
    }
    
    @Test
    public void whenRowIsFilledWithX_thenWinnerIsX() {
    	
    	ticTacToe.play(1,1);//X
    	ticTacToe.play(1,2);//o
    	ticTacToe.play(2,1);//X
    	ticTacToe.play(1,3);//o
    	String result = ticTacToe.play(3,1);//X
    	
    	assertEquals("X is the Winner", result);
    	
    }
    
    @Test
    public void whenRowIsFilledWithY_thenWinnerIsO() {
    	
    	ticTacToe.play(1,1);//X
    	ticTacToe.play(1,2);//O
    	ticTacToe.play(2,1);//X
    	ticTacToe.play(2,2);//O
    	ticTacToe.play(1,3);//X
    	String result = ticTacToe.play(3,2);
    	
    	assertEquals("O is the Winner", result);
    }
    
    @Test
    public void whenDiagonalIsFilledWithO_thenWinnerIsO() {
    	
    	ticTacToe.play(2,1);//x
    	ticTacToe.play(1,1);//o
    	ticTacToe.play(3,1);//x
    	ticTacToe.play(2,2);//o
    	ticTacToe.play(2,3);//x
    	String result = ticTacToe.play(3,3);
    	
    	assertEquals("O is the Winner", result);
    }
    
    @Test
    public void whenDiagonalIsFilledWithX_thenWinnerIsX() {
    	
    	ticTacToe.play(1,1);//x
    	ticTacToe.play(2,1);//o
    	ticTacToe.play(2,2);//x
    	ticTacToe.play(3,1);//o
    	String result = ticTacToe.play(3,3);//x
    	
    	assertEquals("X is the Winner", result);
    	
    }
    
}
