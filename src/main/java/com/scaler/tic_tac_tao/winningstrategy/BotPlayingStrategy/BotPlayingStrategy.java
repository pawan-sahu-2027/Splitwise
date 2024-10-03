package com.scaler.tic_tac_tao.winningstrategy.BotPlayingStrategy;

import com.scaler.tic_tac_tao.model.Board;
import com.scaler.tic_tac_tao.model.Move;

public interface BotPlayingStrategy {
    Move makeMove(Board board);
}
