package student;

public class King extends Figure {
    public King(boolean black) {
        super(black);
    }
    
    @Override
    public boolean canMoveTo(Position current, Position next) {
        super.rejectNullPositions(current, next);
        
        if (current.equals(next)) return false;
        
        int[] fieldsMoved = super.getAbsoluteFieldsMoved(current, next);
        int absoluteColumnsMoved = fieldsMoved[0];
        int absoluteRowsMoved = fieldsMoved[1]; 
        if (absoluteColumnsMoved <= 1 && absoluteRowsMoved <= 1) return true;
        
        return false;
    }
    
    @Override
    public char getSymbol() {
        return super.getBlack() 
            ? Symbol.BLACK_KING.getAsciiChar() 
            : Symbol.WHITE_KING.getAsciiChar();
    }
    
    @Override
    public String getLabel() {
        return "König";
    }
}