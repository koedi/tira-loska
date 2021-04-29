package loska.domain;

public class MyStack<T extends Object> {

    private int stackSize;
    private T[] stackArray;
    private int top;

    @SuppressWarnings("unchecked")
    public MyStack(int size) {
        this.stackSize = size;
        this.stackArray = (T[]) new Object[stackSize];
        this.top = -1;
    }

    public void push(T t) {
        if (!this.isFull()) {
            stackArray[++top] = t;
        } else {
            System.out.println("Stack full!");
        }
    }

    public T pop() {
        if (!this.isEmpty()) {
            return stackArray[top--];
        } else {
            System.out.println("Stack empty!");
            return null;
        }
    }

    public T peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == stackSize - 1);
    }






}