import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[][] board = new int[4][4];
		Scanner sc = new Scanner(System.in);
		Board b = new Board(board);
		Board b2 = new Board(board);
		b.createGame();
		b.printArray();
		b2.setBoard(b.getBoard());
		while(true) {
			System.out.print("enter a direction (q to quit. r to restart): ");
			String direction = sc.next();
			System.out.println();
			if(direction.equals("q")) {
				System.out.println("Are you sure? (y or n): ");
				String confirmation = sc.next();
				if(confirmation.equals("y")) {
					break;					
				}
			}
			if(direction.equals("r")) {			
				System.out.println("Are you sure? (y or n): ");
				String confirmation = sc.next();
				if(confirmation.equals("y")) {
					b.createGame();
					b2.setBoard(b.getBoard());	
					b.setValidMoves(0);
				}
			}
			b.shift(direction, true);
			b.shift(direction, false);
			if(b2.checkBoardState((b.getBoard()))){
				b.setBoard(b2.getBoard());
				if(b.isFilled()) {
					System.out.println("You lose.");
					break;
				}else if(!direction.equals("r")) {
					System.out.println("You can't make that move!");
				}
				
			}else {
				b.increaseValidMoves();
				System.out.println("Valid Moves: " + b.getValidMoves());
				System.out.println("Largest Tile: " + b.getLargestTile());
				if(b.getLargestTile() == 2048) {
					System.out.println("You Won! The game will continue.");
				}
				b2.setBoard(b.getBoard());
				b.placeNumber();
			}
			b.printArray();
		}

		
		
		System.out.println("Valid Moves: " + b.getValidMoves());
		System.out.println("Largest Tile: " + b.getLargestTile());

	}


}
