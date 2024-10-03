package com.scaler.tic_tac_tao.winningstrategy.BotPlayingStrategy;

import com.scaler.tic_tac_tao.model.*;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Move makeMove(Board board) {

        for(List<Cell> row : board.getBoard()) {
            for(Cell cell: row) {
                if(cell.getCellState().equals(CellState.Empty)) {
                    return new Move(null, cell);
                }
            }
        }

        return null;
    }
}