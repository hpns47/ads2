public class Main {
    public static void main(String[] args) {
        // Test MyArrayList
        MyList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println("MyArrayList get(1): " + arrayList.get(1)); // Output: 2

        // Test MyStack
        MyStack<String> stack = new MyStack<>();
        stack.push("A");
        stack.push("B");
        System.out.println("MyStack pop(): " + stack.pop()); // Output: B

        // Test MyQueue
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("X");
        queue.enqueue("Y");
        System.out.println("MyQueue dequeue(): " + queue.dequeue()); // Output: X

        // Test MyMinHeap
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(42);
        heap.insert(21);
        heap.insert(99);
        System.out.println("MyMinHeap getMin(): " + heap.getMin()); // Output: 21
        System.out.println("MyMinHeap extractMin(): " + heap.extractMin()); // Output: 21
        System.out.println("MyMinHeap getMin() after extract: " + heap.getMin()); // Output: 42
    }
}
