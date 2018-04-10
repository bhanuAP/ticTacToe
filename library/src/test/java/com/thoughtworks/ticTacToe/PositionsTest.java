package com.thoughtworks.ticTacToe;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionsTest {
  @Test
  public void shouldStoreGivenIntegerAsPosition() {
    Positions positions = new Positions();
    positions.add(1,2,3);
    Positions expected = new Positions();
    expected.add(1,2,3);
    Assert.assertEquals(positions,expected);
  }

  @Test
  public void shouldStoreOnlyGivenIntegersAsPosition() {
    Positions positions = new Positions();
    positions.add(1,2);
    Positions expected = new Positions();
    expected.add(1,2,3);
    Assert.assertNotEquals(positions,expected);
  }

  @Test
  public void shouldCheckForSubset() {
    WinningCombinations winningCombinations = new WinningCombinations();
    winningCombinations.addCombination(1,2,3);
    winningCombinations.addCombination(4,5,6);
    winningCombinations.addCombination(7,8,9);
    Positions positions = new Positions();
    Positions moves = positions.add(1, 2, 3);
    assertTrue(moves.isSubset(winningCombinations));
  }

  @Test
  public void shouldCheckForNotASubset() {
    WinningCombinations winningCombinations = new WinningCombinations();
    winningCombinations.addCombination(1,2,3);
    WinningCombinations expected = new WinningCombinations();
    expected.addCombination(1,2,3);
    expected.addCombination(4,5,6);
    Assert.assertNotEquals(winningCombinations,expected);
  }
}