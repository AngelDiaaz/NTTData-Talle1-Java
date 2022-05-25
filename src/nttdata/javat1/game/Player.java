package nttdata.javat1.game;

import java.util.List;

/**
 * Clase Player
 * 
 * @author adiaz
 */

public class Player {

	//Propiedades
	private String name;
	private List<Ball> ball;
	
	//Constructor
	public Player(String name, List<Ball> ball) {
		super();
		this.name = name;
		this.ball = ball;
	}
	
	//Getters y setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Ball> getBall() {
		return ball;
	}
	public void setBall(List<Ball> ball) {
		this.ball = ball;
	}
	
	@Override
	public String toString() {
		return "Player [name=" + name + ", ball=" + ball + "]";
	}
}
