package student;

import java.lang.Math;

public class Pawn extends Figure {
    private enum StartingRow {
        BLACK(6),
        WHITE(1);
        
        final int row;
        private StartingRow(int row) {
            this.row = row;
        } 
        
        public int getRow() {
            return this.row;
        }
    }
    
    public Pawn(boolean black) {
        super(black);
    }
    
    @Override
    public boolean canMoveTo(Position current, Position next) {
        super.rejectNullPositions(current, next);
        
        if (current.equals(next) || current.getColumn() != next.getColumn()) 
            return false;
            
        int[] fieldsMoved = super.getFieldsMoved(current, next);
        int rowsMoved = fieldsMoved[1];
        
        if (super.getBlack() && rowsMoved > -1) return false;
        if (!super.getBlack() && rowsMoved < 1) return false;
        
        int absoluteRowsMoved = Math.abs(rowsMoved);
        int startingRow = super.getBlack() 
            ? StartingRow.BLACK.getRow()
            : StartingRow.WHITE.getRow();
        if ((current.getRow() == startingRow && absoluteRowsMoved > 2)
            || (current.getRow() != startingRow && absoluteRowsMoved > 1))
            return false;
        
        return true;
    }
    
    @Override
    public char getSymbol() {
        return super.getBlack() 
            ? Symbol.BLACK_PAWN.getAsciiChar() 
            : Symbol.WHITE_PAWN.getAsciiChar();
    }
    
    @Override
    public String getLabel() {
        return "Bauer";
    }
}