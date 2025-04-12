import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        checkBounds(index);
        getNode(index).data = item;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            MyNode next = getNode(index);
            MyNode prev = next.prev;
            MyNode newNode = new MyNode(item);
            newNode.next = next;
            newNode.prev = prev;
            prev.next = newNode;
            next.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        checkBounds(index);
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        checkEmpty();
        return head.data;
    }

    @Override
    public T getLast() {
        checkEmpty();
        return tail.data;
    }

    @Override
    public void remove(int index) {
        checkBounds(index);
        MyNode node = getNode(index);
        unlink(node);
    }

    @Override
    public void removeFirst() {
        checkEmpty();
        unlink(head);
    }

    @Override
    public void removeLast() {
        checkEmpty();
        unlink(tail);
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Sort not supported in linked list");
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        for (MyNode node = head; node != null; node = node.next) {
            if (node.data.equals(object)) return index;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        for (MyNode node = tail; node != null; node = node.prev) {
            if (node.data.equals(object)) return index;
            index--;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (MyNode node = head; node != null; node = node.next) {
            array[i++] = node.data;
        }
        return array;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private MyNode getNode(int index) {
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    private void unlink(MyNode node) {
        if (node == head) {
            head = node.next;
            if (head != null) head.prev = null;
        } else if (node == tail) {
            tail = node.prev;
            if (tail != null) tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
        if (size == 0) head = tail = null;
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    private void checkEmpty() {
        if (size == 0) throw new IllegalStateException("List is empty");
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
