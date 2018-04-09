package com.thoughtworks.ticTacToe;

public class gameAlreadyCompleted extends Throwable {
  public gameAlreadyCompleted() {
    super("game already completed");
  }
}