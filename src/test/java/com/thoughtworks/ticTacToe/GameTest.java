package com.thoughtworks.ticTacToe;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class GameTest {
  private Game game ;
  private Player player1;
  private Player player2;


  @Before
  public void setUp() {
    game = new Game();
    player1 = new Player("Bhanu Teja", "*");
    player2 = new Player("Pavan Kalyan", "*");
  }

  @Test
  public void shouldAddPlayerToGame() throws PlayersAlreadyJoined {
    assertTrue(game.addPlayer(player1));
  }

  @Test
  public void shouldSetWinningCombinationsToPlayers() throws PlayersAlreadyJoined {
    WinningCombinations winningCombinations = new WinningCombinations();
    winningCombinations.addCombination(1,2,3);
    winningCombinations.addCombination(4,5,6);
    winningCombinations.addCombination(7,8,9);
    game.addPlayer(player1);
    game.addPlayer(player2);
    assertTrue(game.setWinningCombinations(winningCombinations));
  }

  @Test
  public void shouldNotSetWinningCombinationsToPlayerUntilBothPlayersJoin() throws PlayersAlreadyJoined {
    WinningCombinations winningCombinations = new WinningCombinations();
    winningCombinations.addCombination(1,2,3);
    winningCombinations.addCombination(4,5,6);
    winningCombinations.addCombination(7,8,9);
    game.addPlayer(player1);
    assertFalse(game.setWinningCombinations(winningCombinations));
  }

  @Test
  public void shouldSetCurrentPlayer() throws PlayersAlreadyJoined {
    game.addPlayer(player1);
    game.addPlayer(player2);
  }

  @Test
  public void shouldChangeCurrentPlayer() throws PlayersAlreadyJoined, moveAlreadyPlayed {
    game.addPlayer(player1);
    game.addPlayer(player2);
    assertEquals(game.getCurrentPlayer(),player2);
    game.addMoveToCurrentPlayer(1);
    assertEquals(game.getCurrentPlayer(),player1);
    game.addMoveToCurrentPlayer(2);
    assertEquals(game.getCurrentPlayer(),player2);
  }

  @Test
  public void shouldAddMovesToCurrentPlayer() throws PlayersAlreadyJoined, moveAlreadyPlayed {
    game.addPlayer(player1);
    game.addPlayer(player2);
    assertEquals(game.addMoveToCurrentPlayer(1),new Positions().add(1));
  }

  @Test
  public void shouldChangeCurrentPlayerWheneverPlayerMadeAMove() throws PlayersAlreadyJoined, moveAlreadyPlayed {
    game.addPlayer(player1);
    game.addPlayer(player2);
    game.addMoveToCurrentPlayer(1);
    assertThat(game.getCurrentPlayer(),is(player1));
  }

  @Test
  public void shouldAddMovesForBothPlayers() throws PlayersAlreadyJoined, moveAlreadyPlayed {
    game.addPlayer(player1);
    game.addPlayer(player2);
    game.addMoveToCurrentPlayer(1);
    game.addMoveToCurrentPlayer(2);
    assertThat(game.getCurrentPlayer(),is(player2));
  }

  @Test (expected = moveAlreadyPlayed.class)
  public void shouldNotAllowToPlayRepeatedMoves() throws PlayersAlreadyJoined, moveAlreadyPlayed {
    game.addPlayer(player1);
    game.addPlayer(player2);
    game.addMoveToCurrentPlayer(1);
    game.addMoveToCurrentPlayer(1);
  }
}