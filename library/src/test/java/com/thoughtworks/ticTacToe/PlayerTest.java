package com.thoughtworks.ticTacToe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
  private Player player;

  @Before
  public void setUp() {
    player = new Player("Bhanu", "*");
  }

  @Test
  public void shouldStorePlayedMove() {
    Positions positions = new Positions();
    Assert.assertEquals(player.addMove(1),positions.add(1));
    Assert.assertEquals(player.addMove(2),positions.add(1,2));
  }

  @Test
  public void ShouldSetSetWinningCombinations() {
    WinningCombinations winningCombinations = new WinningCombinations();
    winningCombinations.addCombination(1,2,3);
    winningCombinations.addCombination(4,5,6);
    winningCombinations.addCombination(7,8,9);
    WinningCombinations expectedResult = new WinningCombinations();
    expectedResult.addCombination(1,2,3);
    expectedResult.addCombination(4,5,6);
    expectedResult.addCombination(7,8,9);
    WinningCombinations playerWinningCombinations = player.setWinningCombinationsAs(winningCombinations);
    Assert.assertEquals(playerWinningCombinations,expectedResult);
  }

  @Test
  public void shouldCheckWhetherPlayerHasWon() {
    player.addMove(1);
    player.addMove(2);
    player.addMove(3);
    WinningCombinations winningCombinations = new WinningCombinations();
    winningCombinations.addCombination(1,2,3);
    winningCombinations.addCombination(4,5,6);
    player.setWinningCombinationsAs(winningCombinations);
    assertTrue(player.hasWon());
  }

  @Test
  public void shouldCheckPlayerWinningConditionWithWrongCombination() {
    player.addMove(1);
    player.addMove(2);
    player.addMove(3);
    WinningCombinations winningCombinations = new WinningCombinations();
    winningCombinations.addCombination(1,5,3);
    winningCombinations.addCombination(4,2,6);
    player.setWinningCombinationsAs(winningCombinations);
    assertFalse(player.hasWon());
  }
}