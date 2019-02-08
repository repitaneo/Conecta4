package conecta4;

public class Tablero {

	
	private final int FILAS = 8;
	private final int COLUMNAS = 8;
	
	private char [][] datos;
	private int [] donde;
	
	private int turno = 1;
	
	
	
	public Tablero() {
		
		datos = new char[FILAS][COLUMNAS];
		
		for(int i=0;i<FILAS;i++) {
			for(int j=0;j<COLUMNAS;j++) {

				datos[i][j] = 0;
			}
		}
		
		// VECTOR DE DONDE COLOCAR
		donde = new int [COLUMNAS];
		for(int j=0;j<COLUMNAS;j++) {

			donde[j] = FILAS-1;
		}		
	}
	
	
	
	
	
	
	
	
	/**
	 * 
	 * Imprimir
	 * 
	 */
	public void imprimir() {
		
		System.out.println("\n\n");
		for(int i=0;i<FILAS;i++) {
			System.out.print(i+" ");
			for(int j=0;j<COLUMNAS;j++) {

				System.out.print(datos[i][j]+" "); 
			}
			System.out.println("");
		}
		
		System.out.print("  ");
		for(int j=0;j<COLUMNAS;j++) {

			System.out.print(j+" "); 
		}
		System.out.println("");

		
		if(turno == 1) {
			
			System.out.println("\nTurno [x]");
		}
		else System.out.println("\nTurno [o]");
	}		
	
	
	
	
	
	
	public boolean colocar(int j) {
		
		boolean winner = false;
		/// las columnas tienen que estar en mi tablero
		if((j>=0)&&(j<COLUMNAS)) {
			
			/* busco un hueco para colocar la ficha
			 * este sistema usa un bucle y los bucles son lentos
			 * mejoramos el algoritmo
			int i = FILAS-1;
			while((i>=0)&&(datos[i][j]!=0)) {
				i--;
			}*/
			
			// cojo del vector de huecos libres
			// la siguiente posición libre en la columna
			int i = donde[j];
			if(i>=0) {
				// coloco la ficha en la [i,j]	
				datos[i][j] = (turno==1)?'x':'o';
				//miro si hay ganado
				winner = ganadorHorizontal(i,j);
				
				// cambio el turno
				turno = (turno==1)?2:1;
				// indico la siguiente fila libre
				donde[j]--;
			}
		}
		return winner;
	}
	
	
	
	
	


	private boolean ganadorVertical(int i, int j) {
		
		return false;
	}	

	
	
	
	
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean ganadorHorizontal(int i, int j) {
		
		int coincidencias = 0;
		boolean hayGanador = false;
		char comparar = (turno==1)?'x':'o';
		
		// desde la posición donde coloqué la última ficha -3 columnas
		// empiezo a mirar
		int columna=j-3;
		
		// me meto en un bucle a mirar hasta la pocición
		// + 3 columnas
		// salgo si llego a ese limite o si encuentro un ganador
		while((columna<=j+3)&&((!hayGanador))) {
			
			// me protejo para no salir del tablero
			if((columna>=0)&&(columna<COLUMNAS)) {
				
				// si lo que hay es lo que busco
				// aumento las coincidencias
				if(datos[i][columna] == comparar) {
					coincidencias++;
				}
				// sino las pongo a 0 ya que deben ser 4 consecutivas
				else coincidencias = 0;
				
				// si alcancé 4 coincidencias hay un ganador
				if(coincidencias==4) {
					hayGanador=true;
				}
			}
			// avanzo la columna
			columna++;
		}
		// devuelvo si encontré (o no) un ganador
		return hayGanador;
	}
	
	

		

}
