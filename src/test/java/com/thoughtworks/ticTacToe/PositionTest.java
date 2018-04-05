package com.thoughtworks.ticTacToe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PositionTest {
  @Test
  public void shouldCreateNewPosition() {
    assertEquals(new Position(2),new Position(2));
  }

  @Test
  public void shouldReturnFalseForObjectsWithDifferentValues() {
    assertNotEquals(new Position(1),new Position(2));
  }
}

