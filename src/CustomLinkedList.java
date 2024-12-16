
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedList<E> implements Iterable<E> {
    private Node head;
    private Node tail;
    private int size;
    public CustomLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void bastan_sona_tarama() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public void traverseBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
    }

    public void basina_ekleme(E data) {
        Node donucu = new Node(data);
        if (head == null) {
            head = donucu;
            tail = donucu;
        } else {
            donucu.next = head;
            head.prev = donucu;
            head = donucu;
        }
    }

    public void araya_ekleme(E data, int position) {
        Node donucu = new Node(data);
        if (position == 1) {
            basina_ekleme(data);
        } else {
            Node current = head;
            int currPosition = 1;
            while (current != null && currPosition < position) {
                current = current.next;
                currPosition++;
            }
            if (current == null) {
                sona_ekleme(data);
            } else {
                donucu.next = current;
                donucu.prev = current.prev;
                current.prev.next = donucu;
                current.prev = donucu;
            }
        }
    }

    public void sona_ekleme(E data) {
        Node donucu = new Node(data);
        if (tail == null) {
            head = donucu;
            tail = donucu;
        } else {
            tail.next = donucu;
            donucu.prev = tail;
            tail = donucu;
        }
    }

    public void bastan_sil() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node donucu = head;
        head = head.next;
        head.prev = null;
        donucu.next = null;
    }

    public void aradan_sil(int pos) {
        if (head == null) {
            return;
        }

        if (pos == 1) {
            bastan_sil();
            return;
        }

        Node current = head;
        int count = 1;

        while (current != null && count != pos) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position wrong");
            return;
        }

        if (current == tail) {
            sondan_sil();
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.prev = null;
        current.next = null;
    }

    public void sondan_sil() {
        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node donucu = tail;
        tail = tail.prev;
        tail.next = null;
        donucu.prev = null;
    }

    @Override
    public Iterator<E> iterator() {
        return new CustomIterator();
    }

    public void addAll(Iterable<? extends E> elements) {
        for (E element : elements) {
            add(element);
        }
    }

    private class Node {
        private E data;
        private Node next;
        private Node prev;

        public Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public E getData() {
            return data;
        }
    }
    public void add(E data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    private class CustomIterator implements Iterator<E> {
        private Node current;

        public CustomIterator() {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}
