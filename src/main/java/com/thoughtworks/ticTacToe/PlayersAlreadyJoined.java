package com.thoughtworks.ticTacToe;

public class PlayersAlreadyJoined extends Throwable {
  public PlayersAlreadyJoined() {
    super("Both players already joined game");
  }
}