package nttdata.javat1;

import java.util.ArrayList;
import java.util.List;

import nttdata.javat1.game.Ball;
import nttdata.javat1.game.Game;
import nttdata.javat1.game.Player;
import nttdata.javat1.intarfaces.IGame;

/**
 * Clase Main donde se ejecuta el juego, llamando a la funcion game y creando
 * los objetos necesarios para poder jugar
 * 
 * @author adiaz
 */

public class MainApp {

	public static void main(String[] args) throws InterruptedException {
		// Creo un lista para almacenar las bolas
		List<Ball> balls = new ArrayList<>();

		// Creo las bolas y las añado a la lista
		balls.add(new Ball(1, 0));
		balls.add(new Ball(2, 0));
		balls.add(new Ball(3, 0));

		// Creo un juego con un jugador llamando a la interfaz
		IGame game = new Game(new Player("Tellez", balls));

		// Ejecuto el juego del pinball
		game.launchAndStart(balls);
	}

}
