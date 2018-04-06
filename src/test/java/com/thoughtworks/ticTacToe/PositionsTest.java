package com.thoughtworks.ticTacToe;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PositionsTest {
  @Test
  public void shouldStoreGivenIntegerAsPosition() {
    Positions positions = new Positions();
    positions.addPositionItems(1,2,3,4,5);
    assertTrue(positions.hasItem(new Position(3)));
  }
}