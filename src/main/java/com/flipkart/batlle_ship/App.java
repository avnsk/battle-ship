package com.flipkart.batlle_ship;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.flipkart.batlle_ship.data.model.BoardState;
import com.flipkart.batlle_ship.data.model.Carrier;
import com.flipkart.batlle_ship.data.model.Game;
import com.flipkart.batlle_ship.data.model.Player;
import com.flipkart.batlle_ship.data.model.Position;
import com.flipkart.batlle_ship.data.model.Ship;
import com.flipkart.batlle_ship.service.GameServiceImpl;
import com.flipkart.batlle_ship.service.PlayerServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
       Game game = new Game("1");
       
       Player player1 = Player.builder().id("1").email("xyz@flip.com").name("xyz").build();
       PlayerServiceImpl ps = new PlayerServiceImpl();
       Ship s1 = new Carrier("c1", 5, new Position(0, 0), new Position(0, 5));
       ps.placeShipToBoard(player1, s1);
       
       GameServiceImpl gs = new GameServiceImpl();
       
       gs.addPlayer(game, player1);
       
       Player player2 = Player.builder().id("2").email("xyz2@flip.com").name("xyz2").build();
       Ship s3 = new Carrier("c2", 5, new Position(0, 0), new Position(5, 0));
       ps.placeShipToBoard(player2, s3);
       
       gs.addPlayer(game, player2);
       
       boolean gameFinished = false;
       Player chance  = player1;
       while(!gameFinished) {
    	   System.out.println("Opponent Player board state");
    	   BoardState[][] state =  gs.getStateOfOthePlayerBoard(chance, game);
    	   for(int i = 0 ; i < state.length ; i++) {
    		   StringBuilder sb = new StringBuilder();
    		   for(int j = 0; j < state[0].length ; j++) {
    			   
    			   sb.append(state[i][j].name() + " ");
    		   }
    		   System.out.println(sb.toString());
    	   }
    	   System.out.println();
    	   System.out.println("Enter coordinates of next attack");
    	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	   String lines[] = br.readLine().split(" ");
    	   Position p = new Position(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]));
    	   BoardState bs = gs.hitShipOfOtherPlayer(chance, p, game);
    	   System.out.println("For player " + chance.getId() + " state " + bs);
    	   boolean res = gs.hasPlayerWon(chance, game);
    	   if(res) {
    		   break;
    	   }
    	   
    	   
    	   chance = chance.getId() == player1.getId() ? player2 :player1;
    	   System.out.println();
       }
       
       System.out.println("Winner of game is " + chance.getId());
    }
}
