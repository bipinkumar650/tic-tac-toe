package com.bipin.model;

public enum Piece {
  X("X"),
  O("O"),
  DEFAULT("-");

  final String label;

  Piece(String label) {
    this.label = label;
  }

  public String getLabel() {
    return this.label;
  }
}
