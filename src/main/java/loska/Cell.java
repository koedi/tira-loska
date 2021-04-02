package loska;

public class Cell {

    private int x;
    private int y;
    private char type;


    public Cell(int x, int y, char type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }




    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ") = " + this.type; 
    }
}