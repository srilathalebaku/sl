class MyCircularDeque {
    private int[] deque;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyCircularDeque(int k) {
        capacity = k;
        deque = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;

        if (isEmpty()) {
            front = rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }

        deque[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }

        deque[rear] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;

        if (front == rear) {  // Only one element
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }

        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;

        if (front == rear) {  // Only one element
            front = rear = -1;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }

        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : deque[front];
    }

    public int getRear() {
        return isEmpty() ? -1 : deque[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
