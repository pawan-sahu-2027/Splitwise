package com.scaler.tic_tac_tao.model;

import java.util.Scanner;

public class Player {
    private int id ;
    private String name;
    private Symbol symbol;
    private PlayerType  playerType;
    private static Scanner scanner  = new Scanner(System.in);
    public   Player(int id , String name , Symbol symbol , PlayerType playerType){
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }
    public Move makeMove (Board board){
        System.out.println(" Please tell us the row count in order to make move ");
        int row  = scanner.nextInt();
        System.out.println(" Please tell us the col count in order to make move ");
        int column = scanner.nextInt();
        return new Move(this , new Cell(row , column));
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
