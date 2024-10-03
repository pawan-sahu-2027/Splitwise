package com.scaler.tic_tac_tao.winningstrategy;

import com.scaler.tic_tac_tao.controllers.GameController;
import com.scaler.tic_tac_tao.model.*;
import com.scaler.tic_tac_tao.winningstrategy.playerWinningstrategy.ColWinningStrategy;
import com.scaler.tic_tac_tao.winningstrategy.playerWinningstrategy.DiagonalWinningStrategy;
import com.scaler.tic_tac_tao.winningstrategy.playerWinningstrategy.RowWinningStrategy;
import com.scaler.tic_tac_tao.winningstrategy.playerWinningstrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int dimension = 3;
        List<Player> players = new ArrayList<>();
        players.add( new Player( 1,"Pawan" ,new Symbol('X') , PlayerType.HUMAN));
        players.add( new Player( 2,"jayansh", new Symbol('O'), PlayerType.HUMAN ));

        List<WinningStrategy> winningStrategies =  new ArrayList<>();
         winningStrategies.add(new RowWinningStrategy());
         winningStrategies.add(new ColWinningStrategy());
         winningStrategies.add(new DiagonalWinningStrategy());

        GameController gameController = new GameController();
        Game game = gameController.startGame( dimension , players , winningStrategies);
        while (game.getGameState().equals(GameState.INPROGRESS)){

                 gameController.printBoard(game);
                 gameController.makeMove(game);
        }
        System.out.println( gameController.getWinner(game).getName());

    }
}
