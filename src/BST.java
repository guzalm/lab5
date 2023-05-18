public class BST<K extends Comparable<K>, V> {
    private Node root;

    // Inner class representing a node in the binary search tree
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        // Constructor for creating a new node with a key-value pair
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}