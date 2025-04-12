/**
 * Min-heap using MyArrayList as the underlying storage.
 */
public class MyMinHeap<T extends Comparable<T>> {
    private final MyList<T> heap = new MyArrayList<>();

    public void insert(T item) {
        heap.add(item);
        heapifyUp();
    }

    public T extractMin() {
        if (heap.size() == 0) return null;
        T min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.removeLast();
        heapifyDown();
        return min;
    }

    public T getMin() {
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    private void heapifyUp() {
        int index = heap.size() - 1;
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) >= 0) break;
            swap(index, parent);
            index = parent;
        }
    }

    private void heapifyDown() {
        int index = 0;
        int size = heap.size();
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }
            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
