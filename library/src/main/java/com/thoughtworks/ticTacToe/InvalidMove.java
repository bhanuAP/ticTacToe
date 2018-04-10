package com.thoughtworks.ticTacToe;

public class InvalidMove extends Throwable {

  public InvalidMove() {
    super("sorry!\n its an invalid move");
  }
}