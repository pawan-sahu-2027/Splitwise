package com.scaler.tic_tac_tao.model;

import com.scaler.tic_tac_tao.factory.BotPlayingStrategyFactory;
import com.scaler.tic_tac_tao.winningstrategy.BotPlayingStrategy.BotPlayingStrategy;
import com.scaler.tic_tac_tao.winningstrategy.BotPlayingStrategy.EasyBotPlayingStrategy;
import com.scaler.tic_tac_tao.winningstrategy.BotPlayingStrategy.HardtBotPlayingStrategy;
import com.scaler.tic_tac_tao.winningstrategy.BotPlayingStrategy.MediumBotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;



    public  Bot (int id, String name, Symbol symbol, PlayerType playerType , BotDifficultyLevel botDifficultyLevel) {
        super (id, name, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Symbol getSymbol() {
        return super.getSymbol();
    }

    @Override
    public void setSymbol(Symbol symbol) {
        super.setSymbol(symbol);
    }

    @Override
    public PlayerType getPlayerType() {
        return super.getPlayerType();
    }

    @Override
    public void setPlayerType(PlayerType playerType) {
        super.setPlayerType(playerType);
    }
    @Override
    public Move makeMove (Board board){
        Move move = botPlayingStrategy.makeMove(board);
        move.setPlayer(this);
        return move;
    }
}
