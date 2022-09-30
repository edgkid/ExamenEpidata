package com.epidata.prueba.main;

import java.util.ArrayList;
import java.util.List;

public class Main {
	

	
	public static void main(String[] args) {
		
		int totalQueen = 0;
		// En el primer bloque se trata de completar un tablero con ocho reinas.
		// Utilizando una primera reina como pivote a partir de una coordenad al azar
		//NOta: no se validaron las diagonales bajo el presente metodo.
		Util util = new Util();
		String board [][] = new String [8][8];
		int row = util.randomRowOrColumn();
		int column = util.randomRowOrColumn();
		
		Position position = new Position(row, column);
		List<Position> listPosition= new ArrayList<Position>();
		listPosition.add(position);
		
		ChessBoard cheesBoard = new ChessBoard();
		listPosition = cheesBoard.findPosition(listPosition, 7);
		
		cheesBoard.printListPosition(listPosition, position);
		cheesBoard.fillBoard(board, listPosition);
		cheesBoard.printBoard(board);
		
		// el el siguiene bloque se busca determinar el total de posible solucuines.
		TotalSolves totalSol = new TotalSolves();
        totalSol.checkQueenOnBoard(totalQueen);
        System.out.printf("¡Hay% d soluciones en total!",totalSol.count);
		

	}
	
	

}
