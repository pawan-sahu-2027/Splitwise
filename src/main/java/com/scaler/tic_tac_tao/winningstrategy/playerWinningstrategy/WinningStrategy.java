package com.scaler.tic_tac_tao.winningstrategy.playerWinningstrategy;

import com.scaler.tic_tac_tao.model.Board;
import com.scaler.tic_tac_tao.model.Move;

public interface WinningStrategy {
    boolean checkWinner (Move move , Board board);

}
