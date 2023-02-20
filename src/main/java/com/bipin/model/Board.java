package com.bipin.model;

import lombok.Getter;

@Getter
public class Board {
    private final int size;
    private Piece[][] cells;

    public Board(int size) {
        this.size = size;
        initializeBoard(size);
    }

    private void initializeBoard(int size) {
        this.cells = new Piece[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = Piece.DEFAULT;
            }
        }
    }
}
