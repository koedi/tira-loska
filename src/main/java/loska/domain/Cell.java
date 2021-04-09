package loska.domain;

public class Cell {

    private int x;
    private int y;
    private char type;
    private boolean visited;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.type = '#';
        this.visited = false;

    }

    public Cell(int x, int y, char type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.visited = false;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ") = " + this.type; 
    }
}