import java.util.Iterator;

public class BizimHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 1000;

    private CustomLinkedList<Entry<K, V>>[] kutucuk;
    private int kapasite;
    private boolean empty;

    public BizimHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public BizimHashMap(int capacity) {
        this.kapasite = capacity;
        this.kutucuk = new CustomLinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            kutucuk[i] = new CustomLinkedList<>();
        }
        this.empty = true;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        CustomLinkedList<Entry<K, V>> bucket = kutucuk[index];

        Iterator<Entry<K, V>> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                setEmpty(false);
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
        setEmpty(false);
    }

    public V get(K key) {
        int index = getIndex(key);
        CustomLinkedList<Entry<K, V>> bucket = kutucuk[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null;
    }

    public V getOrDefault(K key, V defaultValue) {
        int index = getIndex(key);
        CustomLinkedList<Entry<K, V>> bucket = kutucuk[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return defaultValue;
    }

    public Iterable<Entry<K, V>> getEntries() {
        CustomLinkedList<Entry<K, V>> entries = new CustomLinkedList<>();
        for (CustomLinkedList<Entry<K, V>> bucket : kutucuk) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    entries.add(entry);
                }
            }
        }
        return entries;
    }

    public Iterable<K> getKeys() {
        CustomLinkedList<K> keys = new CustomLinkedList<>();
        for (CustomLinkedList<Entry<K, V>> bucket : kutucuk) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    keys.add(entry.getKey());
                }
            }
        }
        return keys;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public boolean isEmpty() {
        return empty;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");
        for (Entry<K, V> entry : getEntries()) {
            result.append("(").append(entry.getKey()).append(", ").append(entry.getValue()).append("), ");
        }
        // Remove the trailing comma and space
        result.setLength(result.length());
        result.append("]");
        return result.toString();
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % kapasite;
    }

    protected static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
