package com.thoughtworks.ticTacToe;

import org.junit.Ignore;
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
    winningCombinations.addCombination(1,2,3);
    WinningCombinations expected = new WinningCombinations();
    expected.addCombination(1,2,3);
    expected.addCombination(4,5,6);
    assertNotEquals(winningCombinations,expected);
  }
}