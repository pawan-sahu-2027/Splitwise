package com.scaler.tic_tac_tao.model;

import com.scaler.tic_tac_tao.exception.InvalidBotCountException;
import com.scaler.tic_tac_tao.exception.InvalidPlayerCountException;

import com.scaler.tic_tac_tao.winningstrategy.playerWinningstrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private List <WinningStrategy> winningStrategy;
    private int  nextPlayerMoveIndex;
    private Player winner;


    private Game (int dimensions , List<Player> players,List<WinningStrategy> winningStrategies){
        this.board = new Board(dimensions);
        this.players = players;
        this.moves = new ArrayList<>();
        this.winner = null;
        this.gameState = GameState.INPROGRESS;
        this.nextPlayerMoveIndex = 0;
        this.winningStrategy = winningStrategies;
    }
    public  void printBoard (){
        board.printBoard();
    }
    public void makeMove(){
        Player currentPlayer = players.get(nextPlayerMoveIndex);
        System.out.println(currentPlayer.getName() + "'S turn is there ");
         Move move = currentPlayer.makeMove(board);
         System.out.println(currentPlayer.getName() + "is making the move at  " + move.getCell().getRow() + move.getCell().getColums());
         // we can validate the move
         int row  = move.getCell().getRow();
         int col = move.getCell().getColums();
         Cell  cellToChange = board.getBoard().get(row).get(col);
         cellToChange.setCellState(CellState.Filled);
         cellToChange.setPlayer(currentPlayer);
         Move finalMoveObject = new Move(currentPlayer , cellToChange);
         moves.add(finalMoveObject);

         nextPlayerMoveIndex += 1;
         nextPlayerMoveIndex %= players.size();// we need to reset the index to 0
          // check the winner
          if (checkWinner(finalMoveObject)){
              winner =  currentPlayer;
              gameState = GameState.ENDED;
          }
          else if (moves.size()  == ( board.getDimension() * board.getDimension())){
              gameState = GameState.DRAW;
          }


    }
    private boolean checkWinner (Move move){
        for (WinningStrategy winningStrategy : winningStrategy){
            if (winningStrategy.checkWinner(move ,board)){
                return true;
            }
        }
        return false;
    }
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<WinningStrategy> getWinningStrategy() {
        return winningStrategy;
    }

    public void setWinningStrategy(List<WinningStrategy> winningStrategy) {
        this.winningStrategy = winningStrategy;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }


    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public static  Builder getBuilder (){
        return new Builder();
    }

    public static class Builder {
         private int dimension;
         private List<Player> players;
         private List<WinningStrategy> winningStrategies;

        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        private void validatePlayerCount() throws InvalidPlayerCountException {
            if ((players.size() != dimension -1)   || (players == null)){
                throw new InvalidPlayerCountException(" No of player is not correct ");
            }
        }
        private void chechBotCount () throws InvalidBotCountException {

            int botCount = 0;
            for (Player player : players){
                if (player.getPlayerType().equals(PlayerType.BOT) ){
                    botCount += 1;
                }
            }
            if (botCount > 1){
                throw new InvalidBotCountException(" the count of bouts is not correct");

            }
        }
        private void valiDate() throws InvalidBotCountException, InvalidPlayerCountException {
            chechBotCount();
            validatePlayerCount();
        }
        public  Game build (){
            // validate all the things;

            return new Game(dimension , players , winningStrategies );
        }
    }
}
