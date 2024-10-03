package com.scaler.tic_tac_tao.factory;

import com.scaler.tic_tac_tao.winningstrategy.BotPlayingStrategy.BotPlayingStrategy;
import com.scaler.tic_tac_tao.winningstrategy.BotPlayingStrategy.EasyBotPlayingStrategy;
import com.scaler.tic_tac_tao.winningstrategy.BotPlayingStrategy.HardtBotPlayingStrategy;
import com.scaler.tic_tac_tao.winningstrategy.BotPlayingStrategy.MediumBotPlayingStrategy;
import com.scaler.tic_tac_tao.model.BotDifficultyLevel;

public class BotPlayingStrategyFactory {


    public  static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel){

        if (botDifficultyLevel.equals(BotDifficultyLevel.EASY)){
                 return new EasyBotPlayingStrategy();

        }
        else if (botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)){
                 return new MediumBotPlayingStrategy();
        }
        else if (botDifficultyLevel.equals(BotDifficultyLevel.HARD)){
                return new HardtBotPlayingStrategy();

                }
        return null;


        }
    }


