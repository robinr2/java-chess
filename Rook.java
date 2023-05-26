package student;

public class Rook extends Figure {
    public Rook(boolean black) {
        super(black);
    }
    
    @Override
    public boolean canMoveTo(Position current, Position next) {
        super.rejectNullPositions(current, next);
        
        if (current.equals(next)) return false;
        
        int[] fieldsMoved = super.getAbsoluteFieldsMoved(current, next);
        int absoluteColumnsMoved = fieldsMoved[0];
        int absoluteRowsMoved = fieldsMoved[1];
        if (super.movedOrthogonally(absoluteColumnsMoved, absoluteRowsMoved))
            return true;
        
        return false;
    }
    
    @Override
    public char getSymbol() {
        return super.getBlack() 
            ? Symbol.BLACK_ROOK.getAsciiChar() 
            : Symbol.WHITE_ROOK.getAsciiChar();
    }
    
    @Override
    public String getLabel() {
        return "Turm";
    }
}