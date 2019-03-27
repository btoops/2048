

public class Board {

	private int[][] board = new int[4][4];
	private int validMoves = 0;

	Board(int[][] board){
		this.board = board;
	}

	public void increaseValidMoves() {
		validMoves++;
	}

	public int getValidMoves() {
		return validMoves;
	}

	public void setValidMoves(int i) {
		validMoves = i;
	}

	public void createGame() {
		board = new int[4][4];
		validMoves = 0;
		placeNumber();
		placeNumber();
	}

	public int getLargestTile() {
		int max = 0;
		for(int i[] : board) {
			for(int n : i) {
				if(n > max) {
					max = n;
				}
			}
		}
		return max;
	}
	public void printArray() {
		System.out.println();
		for(int r = 0; r < board.length; r++) {
			for(int c = 0; c < board[r].length; c++) {
				if(board[r][c] == 0) {
					System.out.printf("%-5s", "*");
				}
				else
					System.out.printf("%-5d", board[r][c]);
			}
			System.out.println();
		}
		System.out.println();

	}


	public int generateNumber() {
		int random = (int) (Math.random() * 10 + 1); //probablity that 2 is generated
		if(random > 8) {
			return 4;
		}
		else
			return 2;
	}

	public boolean isFilled() {
		for(int r = 0; r < 4; r ++) {
			for(int c = 0; c < 4; c++) {
				try {
					if(board[r][c] == 0 || board[r][c] == board[r+1][c] ||board[r][c] == board[r][c+1]) {
						return false;
					}
				}catch(IndexOutOfBoundsException e) {}
			}
		}
		return true;
	}
	
	public void placeNumber(){
		int num = generateNumber();
		int row, column;
		do {
			row = (int) (Math.random() * 4);
			column = (int) (Math.random() * 4);
			if(board[row][column] == 0) {
				board[row][column] = num;
				break;
			}
		}while (board[row][column] != 0);
	}

	public boolean checkBoardState(int[][] b) {
		for(int r = 0; r < 4; r ++) {
			for(int c = 0; c < 4; c ++){
				if(this.board[r][c] != b[r][c]) {
					return false;
				}
			}
		}
		return true;
	}

	public int[][] getBoard(){
		return board;
	}
	public void setBoard(int[][] board) {
		this.board = board;
	}

	public void shift(String direction, boolean add) {

		if(direction.equals("a")) {//shift left
			int[][] temp = new int[4][4];


			for(int r = 0; r < 4; r++) { 
				int c = 0;
				int column = 0;
				while(column < 4) {
					if(board[r][column] != 0) {

						temp[r][c] = board[r][column];
						c++;
					}
					column++;
				}
			}
			if(add) {
				for(int r = 0; r < 4; r ++) {
					for(int c = 0; c < 3; c ++) {
						if(temp[r][c] == temp[r][c + 1]) {
							temp[r][c] += temp[r][c];
							temp[r][c + 1] = 0;
						}
					}
				}
			}
			this.board = temp;
		}
		else if(direction.equals("d")) { //shift right
			int[][] temp = new int[4][4];
			for(int r = 0; r < 4; r++) { 
				int c = 3;
				int column = 3;
				while(column > -1) {
					if(board[r][column] != 0) {
						temp[r][c] = board[r][column];
						c--;
					}
					column--;
				}
			}
			if(add) {
				for(int r = 0; r < 4; r ++) {
					for(int c = 3; c > 0; c -- ) {
						if(temp[r][c] == temp[r][c - 1]) {
							temp[r][c] += temp[r][c];
							temp[r][c - 1] = 0;
						}
					}
				}
			}
			this.board = temp;
		}
		else if(direction.equals("w")) {//shift up
			int[][] temp = new int[4][4];
			for(int c = 0; c < 4; c++) { 
				//System.out.println("c: " + c);
				int r = 0;
				int row = 0;
				while(row < 4) {
					//	System.out.println("row: " + row);
					if(board[row][c] != 0) {
						temp[r][c] = board[row][c];
						r++;
					}
					row++;
				}
			}
			if(add) {
				for(int c = 0; c < 4; c++) {
					for(int r = 0; r < 3; r++) {
						if(temp[r][c] == temp[r + 1][c]) {
							temp[r][c] += temp[r][c];
							temp[r + 1][c] = 0;
						}
					}
				}
			}
			this.board = temp;
		}
		else if(direction.equals("s")) {//shift down
			int[][] temp = new int[4][4];
			for(int c = 0; c < 4; c++) { 
				int r = 3;
				int row = 3;
				while(row > -1) {
					if(board[row][c] != 0) {
						temp[r][c] = board[row][c];
						r--;
					}
					row--;
				}
			}
			if(add) {
				for(int c = 0; c < 4; c++) {
					for(int r = 3; r > 0; r--) {
						if(temp[r][c] == temp[r - 1][c]) {
							temp[r][c] += temp[r][c];
							temp[r - 1][c] = 0;
						}
					}
				}
			}
			this.board = temp;

		}


	}




}
