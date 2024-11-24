import java.util.*;

public class LRUCache {
    // Doubly Linked List Node
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> cache;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        
        // Dummy head and tail nodes to avoid null checks
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // Move the node to the front (just after the head)
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    // Add the node just after the head
    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    // Remove the node from the list
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // Get the value from the cache
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1; // If the key doesn't exist
        }

        // Move the accessed node to the front (just after the head)
        moveToHead(node);
        return node.value;
    }

    // Put the key-value pair into the cache
    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node == null) {
            // If the key does not exist, create a new node
            node = new Node(key, value);
            cache.put(key, node);
            addNode(node);

            if (cache.size() > capacity) {
                // If the cache is full, remove the least recently used (LRU) item
                Node tailNode = tail.prev;
                cache.remove(tailNode.key);
                removeNode(tailNode);
            }
        } else {
            // If the key exists, update the value and move it to the front
            node.value = value;
            moveToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);

        // Test put and get operations
        lruCache.put(1, 1); // cache = {1=1}
        lruCache.put(2, 2); // cache = {1=1, 2=2}
        lruCache.put(3, 3); // cache = {1=1, 2=2, 3=3}
        
        System.out.println(lruCache.get(1)); // returns 1, cache = {2=2, 3=3, 1=1}
        
        lruCache.put(4, 4); // evicts key 2, cache = {3=3, 1=1, 4=4}
        
        System.out.println(lruCache.get(2)); // returns -1 (not found)
        System.out.println(lruCache.get(3)); // returns 3, cache = {1=1, 4=4, 3=3}
        lruCache.put(5, 5); // evicts key 1, cache = {4=4, 3=3, 5=5}
        
        System.out.println(lruCache.get(1)); // returns -1 (not found)
        System.out.println(lruCache.get(3)); // returns 3, cache = {4=4, 5=5, 3=3}
    }
}
