package com.epidata.prueba.main;

import java.util.List;

public class ChessBoard {
	
	public boolean validPosition (List<Position> board, int x, int y) {
		
		boolean value = false;
		
		// Copruebo filas y columnas
		for (int row = 0; row< 8; row ++) {
			if (row != x) {
				for (int column = 0; column < 8; column ++ ) {
					if (column != y) {
						
						for (int j= 0; j < board.size(); j ++) {
							
							if (board.get(j).getX() == x || board.get(j).getY() == y) {
								value = false;
								break;
							}else {
								value = true;
								
							}
							
						}
						
					}
				}	
			}
		}
		

		return value;
	}
	
	public List<Position> findPosition (List<Position> board, int totalQueens ) {
		
		
		int x =new  Util().randomRowOrColumn();
		int y =new  Util().randomRowOrColumn();
		
		if (totalQueens != 0) {
			
			if (validPosition(board, x, y)) {
				
				Position newPosition = new Position(x,y);
				board.add(newPosition);
				totalQueens --;
				findPosition(board, totalQueens);
				
			}else {
				findPosition(board, totalQueens);
			}
			
		}else {
			return board;
		}
		
		return board;
	}
	
	public void fillBoard(String[][] board, List<Position> listPosition) {
		
		for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				
				for( int j=0; j<listPosition.size(); j++) {
					
					if (listPosition.get(j).getX()==x && listPosition.get(j).getY() == y) {
						
						board[x][y]= "R";
						break;
					}else {
						board[x][y]= "|_";
					}
					
				}
				
			}
		}
		
	}
	
	public void printBoard(String [][] board) {
		
		for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				
					System.out.print(board[x][y]);
					
			}
			System.out.println();	
		}

	}
	
	public void printListPosition(List<Position> listPosition, Position position) {
		
		System.out.println("Reina Pivote " +  "x: " + position.getX() +"y: " + position.getY());
		
		System.out.println("******* Posiciones para colocar a la Reina **********");
		for (int x= 0; x < listPosition.size(); x ++) {
			
			System.out.println("Reina ("+ x +") x: " + listPosition.get(x).getX() + " y: " + listPosition.get(x).getY());
			
		}
		System.out.println("*********************************************************");
		
	}

}
