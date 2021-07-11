package chess;
public class Chess {

	ChessBoard chessBoard;
	Player[] player;
	Player currentPlayer;
	List<Move> movesList;
	GameStatus gameStatus;

	public boolean playerMove(CellPosition fromPosition, CellPositionb toPosition, Piece piece); 
	public boolean endGame();
	private void changeTurn();

}

public class Player {

	Account account;
	Color color;
	Time timeLeft;

}

public class Time {

	int mins;
	int secs;

}

public enum Color {

	BLACK, WHITE;
	
}

public class Account {

	String username;
	String password;

	String name;
	String email;
	String phone;
}

public enum GameStatus {

	ACTIVE, PAUSED, FORTFEIGHT, BLACK_WIN, WHITE_WIN;
}

public class ChessBoard {

	List<List<Cell>>> board;

	public void resetBoard();
	public void updateBoard(Move move);
}

public class Cell {

	Color color;
	Piece piece;
	CellPosition position;
}

public class CellPosition {

	Char ch;
	int i;
}

public class Move {

	Player turn;
	Piece piece;
	Piece killedPiece;
	CellPosition startPosition;
	CellPosition endPosition;

}

public abstract class Piece {

	Color color;

	public boolean move(CellPosition fromPosition, CellPositionb toPosition);
	public List<CellPosition> possibleMoves(CellPosition fromPosition);
	public boolean validate(CellPosition fromPosition, CellPositionb toPosition);
}

public class Knight extends Piece {

	public boolean move(CellPosition fromPosition, CellPositionb toPosition);
	public List<CellPosition> possibleMoves(CellPosition fromPosition);
	public boolean validate(CellPosition fromPosition, CellPositionb toPosition);

}

public class Bishop extends Piece {
	
	public boolean move(CellPosition fromPosition, CellPositionb toPosition);
	public List<CellPosition> possibleMoves(CellPosition fromPosition);
	public boolean validate(CellPosition fromPosition, CellPositionb toPosition);

}

public class rook extends Piece {
	
	public boolean move(CellPosition fromPosition, CellPositionb toPosition);
	public List<CellPosition> possibleMoves(CellPosition fromPosition);
	public boolean validate(CellPosition fromPosition, CellPositionb toPosition);

}

public class King extends Piece {
	
	public boolean move(CellPosition fromPosition, CellPositionb toPosition);
	public List<CellPosition> possibleMoves(CellPosition fromPosition);
	public boolean validate(CellPosition fromPosition, CellPositionb toPosition);

}

public class Queen extends Piece {
	
	public boolean move(CellPosition fromPosition, CellPositionb toPosition);
	public List<CellPosition> possibleMoves(CellPosition fromPosition);
	public boolean validate(CellPosition fromPosition, CellPositionb toPosition);

}

public class Pawn extends Piece {
	
	public boolean move(CellPosition fromPosition, CellPositionb toPosition);
	public List<CellPosition> possibleMoves(CellPosition fromPosition);
	public boolean validate(CellPosition fromPosition, CellPositionb toPosition);

}