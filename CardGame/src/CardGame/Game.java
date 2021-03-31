/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package CardGame;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Megha Patel
 */
public abstract class Game {

    private final String name;//the title of the game
    private ArrayList<RegPlayer> players;// the players of the game
    public Player winner;


    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    public void setWinner(RegPlayer player){
        winner=player;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<RegPlayer> getPlayers() {
        return players;
    }

    /**
     * add player to this game
     */
    public void setPlayer(String name,int index ) {
        players.add(new RegPlayer(name, index));
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<RegPlayer> players) {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public abstract void play();

    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    public abstract void declareWinner();

}//end class
