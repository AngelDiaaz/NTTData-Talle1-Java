package nttdata.javat1.game;

/**
 * Clase Ball
 * 
 * @author adiaz
 */

public class Ball {
	
	//Propiedades
	private int id;
	private long score;
	
	//Constructor
	public Ball(int id, long score) {
		super();
		this.id = id;
		this.score = score;
	}
	
	//Getters y setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getScore() {
		return score;
	}
	public void setScore(long score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Ball [id=" + id + ", score=" + score + "]";
	}
}
