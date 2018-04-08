package com.thoughtworks.ticTacToe;

public class moveAlreadyPlayed extends Throwable {

  public moveAlreadyPlayed() {
    super("move already played");
  }
}