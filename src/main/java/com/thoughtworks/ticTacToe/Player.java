package com.thoughtworks.ticTacToe;

public class Player {
  private final String name;
  private final String symbol;
  private Positions playedMoves;

  public Player(String name, String symbol) {

    this.name = name;
    this.symbol = symbol;
    this.playedMoves = new Positions();
  }

  public Positions addMove(int move) {
    return playedMoves.add(move);
  }
}