package nttdata.javat1.game;

import java.util.List;
import java.util.Scanner;

import nttdata.javat1.intarfaces.IGame;

/**
 * Clase Game donde se realiza el juego del pinball
 * 
 * @author adiaz
 */

public record Game(Player player) implements IGame {
	static Scanner s = new Scanner(System.in);

	/**
	 * Metodo que da la bienvenido e inicia el juego del pinball
	 * 
	 * @param balls Bolas con las que vamos a jugar
	 * @throws InterruptedException Si me quedo sin bolas para jugar
	 */

	public void launchAndStart(List<Ball> balls) throws InterruptedException {
		boolean play = true;
		int index = 0;
		System.out.println("Bienvenido al pintball " + player.getName());
		System.out.println("¿Quieres jugar la partida?");
		do {
			try {

				String opc = s.nextLine();

				if (opc.equalsIgnoreCase("si")) {
					// Voy listando toda las lista de las bolas para jugar con todas ellas si quiero
					game(balls.get(index++));

					System.out.println("¿Quieres jugar otra partida?");
				} else {
					play = false;
				}
			} catch (Exception e) {
				// Si no me quedan bolas para jugar
				System.out.println("No te quedan más bolas");
				endGame(balls);
			}
		} while (play);

		endGame(balls);
		s.close();
	}

	/**
	 * Metodo que te lista toda la puntuacion de las bolas al finalizar el juego
	 * 
	 * @param balls Lista de bolas con las que hemos jugado
	 */

	private void endGame(List<Ball> balls) {
		//Listo la puntuacion de las bolas
		for (Ball ball : balls) {
			System.out.println("Puntuacion de la bola " + ball.getId() + ": " + ball.getScore() + " puntos");
		}
		System.out.println("Fin del juego!!!");
	}

	/**
	 * Metodo que simula un juego del pinball
	 * 
	 * @param ball Bola del pintball con la que vamos a jugar
	 * @throws InterruptedException Si me quedo sin bolas para jugar
	 */

	private void game(Ball ball) throws InterruptedException {
		long point = 10;
		int bonus;
		boolean play = true;
		StringBuilder stb = new StringBuilder();
		System.out.println("La bola ha sido lanzada");
		Thread.sleep(1000);

		do {
			bonus = score(generateNumberRandom());

			if (bonus == 0) { //La bola sale si el bonus es 0
				play = false;
				System.out.println("\nLa bola se ha salido!!!");
			} else {
				System.out.println("\nLa bola ha rebotado y ha conseguido un bonus de x" + bonus);
				point *= bonus;
				stb.append("\nPuntuacion: " + point);
				System.out.println(stb);
				Thread.sleep(300);
			}

		} while (play); //Mientras la bola no salga

		System.out.println("Puntuacion total: " + point);
		ball.setScore(point);
	}

	/**
	 * Metodo que saca el bonus para multiplicar la multiplicacion, a traves de un
	 * numero random
	 * 
	 * @param random Numero random del 1 al 10
	 * @return Bonus para la puntuacion del juego
	 */

	private int score(int random) {
		int score = 0;
		if (random == 10) {
			score = 0;
		} else if (random >= 3 && random <= 6) {
			score = 2;
		} else if (random >= 7 && random <= 8) {
			score = 3;
		} else {
			score = 1;
		}
		return score;
	}

	/**
	 * Metodo que genera un numero random del 1 al 10
	 * 
	 * @return Numero random del 1 al 10
	 */

	private int generateNumberRandom() {
		return (int) ((Math.random() * 10) + 1);
	}

}
