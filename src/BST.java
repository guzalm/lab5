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
    //Creating of put() method
    public void put(K key, V value) {
        // Call the recursive helper method to perform insertion
        root = putRecursive(root, key, value);
    }

    private Node putRecursive(Node currentNode, K key, V value) {
        // If the current node is null, create a new node with the given key and value
        if (currentNode == null) {
            return new Node(key, value);
        }

        // Compare the given key with the key of the current node
        int cmp = key.compareTo(currentNode.key);

        if (cmp < 0) {
            // If the given key is less than the current node's key, traverse to the left subtree
            currentNode.left = putRecursive(currentNode.left, key, value);
        } else if (cmp > 0) {
            // If the given key is greater than the current node's key, traverse to the right subtree
            currentNode.right = putRecursive(currentNode.right, key, value);
        } else {
            // If the given key is equal to the current node's key, update the value of the current node
            currentNode.value = value;
        }

        // Return the updated or newly created node
        return currentNode;
    }

}
