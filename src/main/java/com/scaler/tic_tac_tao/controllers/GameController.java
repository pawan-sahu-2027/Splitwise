package com.scaler.tic_tac_tao.controllers;

import com.scaler.tic_tac_tao.model.Game;
import com.scaler.tic_tac_tao.model.Player;
import com.scaler.tic_tac_tao.winningstrategy.playerWinningstrategy.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame (int dimension , List<Player> players , List<WinningStrategy> winningStrategies){
        Game game = Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
        return  game;
    }
    public void makeMove (Game game){
            game.makeMove();
    }
    public void printBoard(Game game){
        game.printBoard();
    }
    public Player getWinner(Game game){
        return game.getWinner();
    }

}
