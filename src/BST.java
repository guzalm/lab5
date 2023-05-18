public class BST<K extends Comparable<K>, V> {
    private Node root;

    // Inner class representing a node in the binary search tree
    private class Node {
        private K key;
        private V value;
        private Node left, right;
    }
}