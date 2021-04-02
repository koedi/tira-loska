package loska;


public class MyStack<T extends Object> {

    private int stackSize;
    private T[] stackArray;
    private int top;

    public MyStack(int size) {
        this.stackSize = size;
        this.stackArray = (T[]) new Object[stackSize];
        this.top = -1;

    }
}