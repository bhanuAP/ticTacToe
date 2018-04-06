package com.thoughtworks.ticTacToe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
  private Player player;

  @Before
  public void setUp() {
    player = new Player("Bhanu", "*");
  }

  @Test
  public void shouldStorePlayedMove() {
    Positions positions = new Positions();
    assertEquals(player.addMove(1),positions.add(1));
  }

}