package student;

public class Knight extends Figure {
    public Knight(boolean black) {
        super(black);
    }
    
    @Override
    public boolean canMoveTo(Position current, Position next) {
        super.rejectNullPositions(current, next);
        
        if (current.equals(next)) return false;
        
        int[] fieldsMoved = super.getAbsoluteFieldsMoved(current, next);
        int absoluteColumnsMoved = fieldsMoved[0];
        int absoluteRowsMoved = fieldsMoved[1]; 
        if (absoluteColumnsMoved * absoluteRowsMoved == 2) return true;
        
        return false;
    }
    
    @Override
    public char getSymbol() {
        return super.getBlack() 
            ? Symbol.BLACK_KNIGHT.getAsciiChar() 
            : Symbol.WHITE_KNIGHT.getAsciiChar();
    }
    
    @Override
    public String getLabel() {
        return "Springer";
    }
}