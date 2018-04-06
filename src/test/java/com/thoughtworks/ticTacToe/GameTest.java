package com.thoughtworks.ticTacToe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
  @Test
  public void shouldAddPlayerToGame() {
    Game game = new Game();
    Player player = new Player("Bhanu Teja", "*");
    assertEquals(game.addPlayer(player),player);
  }
}