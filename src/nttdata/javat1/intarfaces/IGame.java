package nttdata.javat1.intarfaces;

import java.util.List;

import nttdata.javat1.game.Ball;

/**
 * Interfaz de la clase Game
 * 
 * @author adiaz
 */
public interface IGame {

	/**
	 * Metodo que da la bienvenido e inicia el juego del pinball
	 * 
	 * @param balls Bolas con las que vamos a jugar
	 * @throws InterruptedException Si me quedo sin bolas para jugar
	 */
	
	public void launchAndStart(List<Ball> balls) throws InterruptedException;
}
