package com.thoughtworks.ticTacToe;

import org.junit.Test;

import static org.junit.Assert.*;


public class WinningCombinationTest {
  @Test
  public void shouldAddGivenWinningCombination() {
    WinningCombinations winningCombinations = new WinningCombinations();
    winningCombinations.addCombination(1,2,3);
    winningCombinations.addCombination(4,5,6);
    WinningCombinations expected = new WinningCombinations();
    expected.addCombination(1,2,3);
    expected.addCombination(4,5,6);
    assertEquals(winningCombinations,expected);
  }

  @Test
  public void shouldAddOnlyGivenWinningCombination() {
    WinningCombinations winningCombinations = new WinningCombinations();
    winningCombinations.addCombination(1,8,3);
    winningCombinations.addCombination(4,2,6);
    winningCombinations.addCombination(7,5,9);
    Positions positions = new Positions();
    Positions moves = positions.add(1, 2, 3);
    assertFalse(moves.isSubset(winningCombinations));
  }

  @Test
  public void shouldCheckSubsetBehaviourForASetWhichIsNotSubset() {
    WinningCombinations winningCombinations = new WinningCombinations();
    winningCombinations.addCombination(1,5,3);
    winningCombinations.addCombination(4,2,6);
    Positions positions = new Positions();
    Positions moves = positions.add(1, 2, 3);
    assertFalse(moves.isSubset(winningCombinations));
  }
}