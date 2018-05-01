/**
* Represents all of the data and methods associated with a Player
*
* @author  Liam Davies, Kevin Lee
* @version 1.0
* @since   2018-04-12 
*/

package player;

import java.util.ArrayList;

import piece.*;

public class Player {
	public char color;
	public ArrayList<Piece> living;
	public ArrayList<Piece> dead;
	public King k;
	
	/**
	   * Creates the Player, sets default values and the color
	   * 
	   * @param c A letter representing the color of the player
	   */
	public Player(char c) {
		color = c;
		living = new ArrayList<Piece>();
		dead = new ArrayList<Piece>();
	}
	
	/**
	   * Removes a piece from the living and places it in the dead
	   * 
	   * @param p The piece to be killed
	   */
	public void kill(Piece p) {
		dead.add(p);
		living.remove(p);
	}
	
	/**
	   * Deletes the old piece and replaces it with the requested piece
	   * 
	   * @param p The piece being promoted
	   * @param type A char representing the type of piece to be upgraded to
	   * @return Piece The new piece that is being replaced
	   */
	public Piece promote(Piece p, char type) {
		dead.add(p);
		living.remove(p);
		
		switch(type){
			case 'Q':
				p = new Queen(color);
				living.add(p);
				return p;
				
			case 'B':
				p = new Bishop(color);
				living.add(p);
				return p;
				
			case 'N':
				p = new Knight(color);
				living.add(p);
				return p;
				
			case 'R':
				p = new Rook(color);
				living.add(p);
				return p;
				
			default:
				p = new Queen(color);
				living.add(p);
				return p;
				
		}
		
	}
	
}
