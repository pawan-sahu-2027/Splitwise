package com.scaler.tic_tac_tao.winningstrategy.playerWinningstrategy;

import com.scaler.tic_tac_tao.model.Board;
import com.scaler.tic_tac_tao.model.Move;
import com.scaler.tic_tac_tao.model.Symbol;

import java.util.HashMap;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Move move, Board board) {
        int col = move.getCell().getColums();
        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();
         HashMap<Integer , HashMap<Symbol , Integer>> counts = new HashMap();
          if (!counts.containsKey(col)){
              counts.put(col , new HashMap<>());
          }
          HashMap<Symbol , Integer> colPath = counts.get(col);
          if (!colPath.containsKey(symbol)){
               colPath.put(symbol , 0);
          }
          colPath.put(symbol , colPath.get(symbol) +1);
          if (colPath.get(symbol) == board.getDimension() -1){
              return true;
          }

        return false;
    }
}
