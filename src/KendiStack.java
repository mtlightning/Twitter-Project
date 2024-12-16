class KendiStack<T> {

    private Node<T> top;

    public KendiStack() {
        this.top = null;

    }



    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (stackBosMu()) {
            throw new IllegalStateException("Stack bostur");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() {
        if (stackBosMu()) {
            throw new IllegalStateException("Stack bostur");
        }
        return top.data;
    }

    public boolean stackBosMu() {
        return top == null;
    }

    class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

}
