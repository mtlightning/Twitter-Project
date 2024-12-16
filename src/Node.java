public class Node<E> {
    private E data;
    private Node<E> next;
    private Node<E> prev;

    public Node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public E getData() {
        return data;
    }
}
