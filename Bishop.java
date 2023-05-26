package student;

public class Bishop extends Figure {
    public Bishop(boolean black) {
        super(black);
    }
    
    @Override
    public boolean canMoveTo(Position current, Position next) {
        super.rejectNullPositions(current, next);
        
        if (current.equals(next)) return false;
        
        int[] fieldsMoved = super.getAbsoluteFieldsMoved(current, next);
        int absoluteColumnsMoved = fieldsMoved[0];
        int absoluteRowsMoved = fieldsMoved[1];
        if (super.movedDiagonally(absoluteColumnsMoved, absoluteRowsMoved)) 
            return true;
        
        return false;
    }
    
    @Override
    public char getSymbol() {
        return super.getBlack() 
            ? Symbol.BLACK_BISHOP.getAsciiChar() 
            : Symbol.WHITE_BISHOP.getAsciiChar();
    }
    
    @Override
    public String getLabel() {
        return "Läufer";
    }
}