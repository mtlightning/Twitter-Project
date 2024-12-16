import java.util.*;

public class BizimArraylist<S> implements Iterable<String>, List<String> {
    private static final int DEFAULT_CAPACITY = 10000; // 10000 - 30000  halit değişim... 26000 ok 30000 no...
    private String[] array = new String[DEFAULT_CAPACITY];
    private int size;

    public BizimArraylist() {

        this.array = new String[DEFAULT_CAPACITY];
        this.size = 0;

    }

    public void ekle(String element) {
        if (size == array.length) {
            ensureCapacity();
        }

        array[size++] = element;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Geçersiz index: " + index);
        }
        return array[index];
    }

    public int size() {
        return size;
    }

    public boolean içeriyorMu(String element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(element, array[i])) {
                return true;
            }
        }
        return false;
    }

    public void kaldır(String element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(element, array[i])) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[--size] = null; // Diziden silinen elemanı temizle
        }
    }

    private void ensureCapacity() {
        int newCapacity = array.length * 2;
        array = Arrays.copyOf(array, newCapacity);
    }

    @Override
    public Iterator<String> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<String> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[currentIndex++];
        }
    }

    // Diğer List interfeysi metotlarına dummy implementasyonlar ekleyebilirsiniz
    @Override
    public boolean add(String s) {
        array[size] = s;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        // Implementasyonu gerekirse buraya ekleyebilirsiniz
    }

    @Override
    public String set(int index, String element) {
        return null;
    }

    @Override
    public void add(int index, String element) {

    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<String> listIterator() {
        return null;
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return içeriyorMu((String) o);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return Arrays.copyOf(array, size, (Class<? extends T[]>) a.getClass());
    }
}
