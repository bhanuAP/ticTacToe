package com.thoughtworks.ticTacToe;

import org.junit.Test;

public class WinningCombinationTest {
  @Test
  public void shouldAddGivenWinningCombination() {
    WinningCombinations winningCombinations = new WinningCombinations();
    winningCombinations.addAsCombination(1,2,3);
  }
}