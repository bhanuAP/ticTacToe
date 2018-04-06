package com.thoughtworks.ticTacToe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PositionsTest {
  @Test
  public void shouldStoreGivenIntegerAsPosition() {
    Positions positions = new Positions();
    positions.add(1,2,3);
    Positions expected = new Positions();
    expected.add(1,2,3);
    assertEquals(positions,expected);
  }

  @Test
  public void shouldStoreOnlyGivenIntegersAsPosition() {
    Positions positions = new Positions();
    positions.add(1,2);
    Positions expected = new Positions();
    expected.add(1,2,3);
    assertNotEquals(positions,expected);
  }
}