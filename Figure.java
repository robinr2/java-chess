package student;

import java.lang.Math;

public class Figure {
    private boolean black;
    
    public enum Symbol {
        BASE(63),
        BLACK_PAWN(9823),
        WHITE_PAWN(9817),
        BLACK_ROOK(9820),
        WHITE_ROOK(9814),
        BLACK_KNIGHT(9822),
        WHITE_KNIGHT(9816),
        BLACK_BISHOP(9821),
        WHITE_BISHOP(9815),
        BLACK_QUEEN(9819),
        WHITE_QUEEN(9813),
        BLACK_KING(9818),
        WHITE_KING(9812);
        
        final int asciiCode;
        private Symbol(int asciiCode) {
            this.asciiCode = asciiCode;
        } 
        
        public char getAsciiChar() {
            return (char) this.asciiCode;
        }
    }
    
    public Figure(boolean black) {
        this.setBlack(black);
    }
    
    public boolean getBlack() {
        return this.black;
    }
    
    public void setBlack(boolean black) {
        this.black = black;
    }
    
    protected void rejectNullPositions(Position current, Position next) {
        if (current == null)
            throw new IllegalArgumentException("Current position is null.");
            
        if (next == null)
            throw new IllegalArgumentException("Next position is null.");
    }
    
    protected int[] getFieldsMoved(Position current, Position next) {
        int columnsMoved = next.getColumn() - current.getColumn();
        int rowsMoved = next.getRow() - current.getRow();
        return new int[] { columnsMoved, rowsMoved };
    }
    
    protected int[] getAbsoluteFieldsMoved(Position current, Position next) {
        int[] fieldsMoved = this.getFieldsMoved(current, next);
        return new int[] { Math.abs(fieldsMoved[0]), Math.abs(fieldsMoved[1]) };
    }
    
    protected boolean movedOrthogonally(int absoluteColumnsMoved, int absoluteRowsMoved) {
        return absoluteColumnsMoved * absoluteRowsMoved == 0;
    }
    
    protected boolean movedDiagonally(int absoluteColumnsMoved, int absoluteRowsMoved) {
        return absoluteColumnsMoved - absoluteRowsMoved == 0;
    }
    
    public boolean canMoveTo(Position current, Position next) {
        this.rejectNullPositions(current, next);
        return !current.equals(next);
    }
    
    public char getSymbol() {
        return Symbol.BASE.getAsciiChar();
    }
    
    public String getLabel() {
        return "Unbekannte Figur";
    }
    
    @Override
    public String toString() {
        String color = this.getBlack() ? "schwarz" : "weiß";
        return String.format("%s (%s)", this.getLabel(), color);
    }
}