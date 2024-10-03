package com.scaler.tic_tac_tao.winningstrategy.playerWinningstrategy;

import com.scaler.tic_tac_tao.model.Board;
import com.scaler.tic_tac_tao.model.Move;
import com.scaler.tic_tac_tao.model.Symbol;

import java.util.HashMap;

public class ColWinningStrategy implements  WinningStrategy{
    private HashMap<Integer, HashMap<Symbol, Integer>> counts = new HashMap<>();

    @Override
    public boolean checkWinner(Move move, Board board) {
        int row = move.getCell().getRow();
        Symbol sym = move.getPlayer().getSymbol();
         if (!counts.containsKey(row)){
             counts.put(row , new HashMap<>());
         }
         HashMap <Symbol , Integer> rowMap = counts.get(row);

         if (!rowMap.containsKey(sym)){
             rowMap.put(sym , 0);
         }
         rowMap.put(sym , rowMap.get(sym) +1);
         if (rowMap.get(sym) == (board.getDimension())){
             return true;
         }
        return false;
    }
}
