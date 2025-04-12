/**
 * Stack implementation using MyArrayList (LIFO behavior).
 */
public class MyStack<T> {
    private final MyList<T> list = new MyArrayList<>();

    public void push(T item) {
        list.addLast(item);
    }

    public T pop() {
        T last = list.getLast();
        list.removeLast();
        return last;
    }

    public T peek() {
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }
}
