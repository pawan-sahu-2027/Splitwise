package com.scaler.tic_tac_tao.model;

public class Cell {
    public int row;
    public int colums;
    public CellState cellState;
    public Player player;

    public Cell( int row , int colums){
        this.row = row;
        this.colums = colums;
        this.cellState = CellState.Empty;
    }

   public void display (){
        if (player == null){
            System.out.print( "|   |");
        }
        else  {
            System.out.print( player.getSymbol().getaChar() + "|");
        }

   }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColums() {
        return colums;
    }

    public void setColums(int colums) {
        this.colums = colums;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}