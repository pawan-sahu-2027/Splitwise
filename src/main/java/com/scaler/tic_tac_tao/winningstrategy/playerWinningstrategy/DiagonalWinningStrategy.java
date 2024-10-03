package com.scaler.tic_tac_tao.winningstrategy.playerWinningstrategy;

import com.scaler.tic_tac_tao.model.Board;
import com.scaler.tic_tac_tao.model.Move;
import com.scaler.tic_tac_tao.model.Symbol;

import java.util.HashMap;

public class DiagonalWinningStrategy implements  WinningStrategy{
    HashMap<Symbol , Integer> rightDiagonal = new HashMap();
    HashMap<Symbol , Integer> leftDiagonal = new HashMap();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        int col = move.getCell().getColums();
        Symbol symbol = move.getPlayer().getSymbol();
        if (row == col){ // if row == col that means it is a right diagonal
            if (!rightDiagonal.containsKey(symbol)){
                  rightDiagonal.put(symbol , 0);
            }

                 rightDiagonal.put(symbol , rightDiagonal.get(symbol)+ 1);
            if (rightDiagonal.get(symbol) ==  board.getDimension() ){
                return true;
            }
            return false;
        }
           if (row + col == board.getDimension() -1){
                if (!leftDiagonal.containsKey(symbol)){
                    leftDiagonal.put(symbol , 0);
                }
               leftDiagonal.put(symbol, leftDiagonal.get(symbol) + 1);
                if (leftDiagonal.get(symbol) == board.getDimension() ){
                    return true;
                }
                return false;
           }
        return false;
    }
}
