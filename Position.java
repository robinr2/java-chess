package student;

import java.util.Objects;

public class Position {
    private int column;
    private int row;
    
    public Position(int column, int row) {
        this.setRow(row);
        this.setColumn(column);
    }
    
    public Position(String positionString) {
        if (positionString == null)
            throw new IllegalArgumentException("positionString is null.");
        
        if (positionString.length() != 2)
            throw new IllegalArgumentException("positionString length not equal to 2.");
        
        char firstChar = positionString.charAt(0);
        if (firstChar < 'a' || firstChar > 'z')
            throw new IllegalArgumentException("First character not between a and z.");
        
        char secondChar = positionString.charAt(1);
        if (secondChar < '1' || secondChar > '8')
            throw new IllegalArgumentException("Second character not between 1 and 8.");
        
        int column = (int) firstChar - 'a';
        int row = (int) secondChar - '1';
        
        this.setColumn(column);
        this.setRow(row);
    }
    
    public int getColumn() {
        return this.column;
    }
    
    public void setColumn(int column) {
        if (column < 0 || column > 7)
            throw new IllegalArgumentException("0 < column < 7");
        
        this.column = column;
    }
    
    public int getRow() {
        return this.row;
    }
    
    public void setRow(int row) {
        if (row < 0 || row > 7)
             throw new IllegalArgumentException("0 < row < 7");
        
        this.row = row;
    }
    
    @Override
    public String toString() {
        char firstChar = (char) (this.getColumn() + 'a');
        char secondChar = (char) (this.getRow() + '1');
        
        return "" + firstChar + secondChar;        
    }
    
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Position)) return false;
        
        Position otherPosition = (Position) other;
        
        return Objects.equals(this.getColumn(), otherPosition.getColumn())
            && Objects.equals(this.getRow(), otherPosition.getRow());
    }
}
















