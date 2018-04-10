package com.thoughtworks.ticTacToe;

import org.junit.Assert;
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
    player2 = new Player("Pavan Kalyan", "#");
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

//  @Test
//  public void shouldChangeCurrentPlayer() throws PlayersAlreadyJoined, InvalidMove, gameAlreadyCompleted {
//    game.addPlayer(player1);
//    game.addPlayer(player2);
//    Assert.assertEquals(game.getCurrentPlayer(),player2);
//    game.addMoveToCurrentPlayer(1);
//    Assert.assertEquals(game.getCurrentPlayer(),player1);
//    game.addMoveToCurrentPlayer(2);
//    Assert.assertEquals(game.getCurrentPlayer(),player2);
//  }

//  @Test
//  public void shouldChangeCurrentPlayerWheneverPlayerMadeAMove() throws PlayersAlreadyJoined, InvalidMove, gameAlreadyCompleted {
//    game.addPlayer(player1);
//    game.addPlayer(player2);
//    game.addMoveToCurrentPlayer(1);
//    assertThat(game.getCurrentPlayer(), Is.is(player1));
//  }
//
//  @Test
//  public void shouldAddMovesForBothPlayers() throws PlayersAlreadyJoined, InvalidMove, gameAlreadyCompleted {
//    game.addPlayer(player1);
//    game.addPlayer(player2);
//    game.addMoveToCurrentPlayer(1);
//    game.addMoveToCurrentPlayer(2);
//    assertThat(game.getCurrentPlayer(), Is.is(player2));
//  }

  @Test
  public void shouldAddMovesToCurrentPlayer() throws PlayersAlreadyJoined, InvalidMove, gameAlreadyCompleted {
    game.addPlayer(player1);
    game.addPlayer(player2);
    Assert.assertEquals(game.addMoveToCurrentPlayer(1),new Positions().add(1));
  }

  @Test (expected = InvalidMove.class)
  public void shouldNotAllowToPlayRepeatedMoves() throws PlayersAlreadyJoined, InvalidMove, gameAlreadyCompleted {
    game.addPlayer(player1);
    game.addPlayer(player2);
    game.addMoveToCurrentPlayer(1);
    game.addMoveToCurrentPlayer(1);
  }

  @Test
  public void shouldTellWhetherPlayerHasWon() throws PlayersAlreadyJoined, InvalidMove, gameAlreadyCompleted {
    game.addPlayer(player1);
    game.addPlayer(player2);
    WinningCombinations winningCombinations = new WinningCombinations();
    winningCombinations.addCombination(1,2,3);
    winningCombinations.addCombination(4,5,6);
    game.setWinningCombinations(winningCombinations);
    game.addMoveToCurrentPlayer(1);
    game.addMoveToCurrentPlayer(5);
    game.addMoveToCurrentPlayer(2);
    game.addMoveToCurrentPlayer(6);
    game.addMoveToCurrentPlayer(3);
    assertTrue(game.player1HasWon());
  }

  @Test
  public void shouldCheckForPlayerNotWonConditions() throws PlayersAlreadyJoined, InvalidMove, gameAlreadyCompleted {
    game.addPlayer(player1);
    game.addPlayer(player2);
    WinningCombinations winningCombinations = new WinningCombinations();
    winningCombinations.addCombination(1,2,3);
    winningCombinations.addCombination(4,5,6);
    game.setWinningCombinations(winningCombinations);
    game.addMoveToCurrentPlayer(1);
    game.addMoveToCurrentPlayer(4);
    game.addMoveToCurrentPlayer(2);
    game.addMoveToCurrentPlayer(5);
    game.addMoveToCurrentPlayer(3);
    assertFalse(game.player2HasWon());
  }

  @Test
  public void shouldCheckWhetherGameHasDrawn() throws PlayersAlreadyJoined, InvalidMove, gameAlreadyCompleted {
    game.addPlayer(player1);
    game.addPlayer(player2);
    game.addMoveToCurrentPlayer(1);
    game.addMoveToCurrentPlayer(2);
    game.addMoveToCurrentPlayer(3);
    game.addMoveToCurrentPlayer(5);
    game.addMoveToCurrentPlayer(4);
    game.addMoveToCurrentPlayer(6);
    game.addMoveToCurrentPlayer(8);
    game.addMoveToCurrentPlayer(7);
    game.addMoveToCurrentPlayer(9);
    assertTrue(game.isDrawn());
  }

  @Test
  public void shouldCheckStatusOfGame() throws PlayersAlreadyJoined, InvalidMove, gameAlreadyCompleted {
    game.addPlayer(player1);
    game.addPlayer(player2);
    WinningCombinations winningCombinations = new WinningCombinations();
    winningCombinations.addCombination(1,2,3);
    winningCombinations.addCombination(4,5,6);
    game.setWinningCombinations(winningCombinations);
    assertThat(game.getStatus(),is("started"));
    game.addMoveToCurrentPlayer(1);
    game.addMoveToCurrentPlayer(5);
    game.addMoveToCurrentPlayer(2);
    game.addMoveToCurrentPlayer(9);
    game.addMoveToCurrentPlayer(3);
    game.updateStatus();
    assertThat(game.getStatus(),is("player1 has won"));
  }

  @Test (expected = gameAlreadyCompleted.class)
  public void shouldNotAllowPlayerToPlayTurnOnceStatusHasChanged() throws PlayersAlreadyJoined, InvalidMove, gameAlreadyCompleted {
    game.addPlayer(player1);
    game.addPlayer(player2);
    WinningCombinations winningCombinations = new WinningCombinations();
    winningCombinations.addCombination(1,2,3);
    winningCombinations.addCombination(4,5,6);
    game.setWinningCombinations(winningCombinations);
    game.addMoveToCurrentPlayer(1);
    game.addMoveToCurrentPlayer(4);
    game.addMoveToCurrentPlayer(2);
    game.addMoveToCurrentPlayer(5);
    game.addMoveToCurrentPlayer(3);
    game.updateStatus();
    game.addMoveToCurrentPlayer(6);
    System.out.println(game.getStatus());
  }
}