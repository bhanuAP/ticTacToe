package com.thoughtworks.ticTacToe;

import java.util.HashSet;

public class Positions {
  private HashSet<Position> list;

  public Positions() {
    this.list = new HashSet();
  }

  public void addPositionItems(int...numbers) {
    for (int number : numbers) {
      list.add(new Position(number));
    }
  }

  public boolean hasItem(Position position) {
    return list.contains(position);
  }
}