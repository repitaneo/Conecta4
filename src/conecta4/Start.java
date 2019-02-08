package conecta4;

import java.util.Scanner;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner teclado = new Scanner(System.in);
		
		int columna = 0;
		Tablero juego = new Tablero();
		boolean winner = false;
		
		while(!winner) {
			
			juego.imprimir();
			System.out.print("Columna?_");
			columna = teclado.nextInt();
			winner = juego.colocar(columna);
		}
		juego.imprimir();
		System.out.println("WINNER");
		
		
		
		
	}

}
