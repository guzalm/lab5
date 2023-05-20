import java.util.Iterator;
import java.util.Stack;
public class BST<K extends Comparable<K>, V> implements Iterable<K>{
    private Node root;
    private int size; // Variable to store the size of the BST

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
            size++;
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
    //Creating get() method
    public V get(K key) {
        return getRecursive(root, key);
    }

    private V getRecursive(Node currentNode, K key) {
        if (currentNode == null) {
            // Key not found, return null or throw an exception depending on the desired behavior
            return null;
        }

        int cmp = key.compareTo(currentNode.key);

        if (cmp < 0) {
            // Key is smaller, search in the left subtree
            return getRecursive(currentNode.left, key);
        } else if (cmp > 0) {
            // Key is greater, search in the right subtree
            return getRecursive(currentNode.right, key);
        } else {
            // Key found, return the value associated with the key
            return currentNode.value;
        }
    }
    //Creating of delete() method
    public void delete(K key) {
        root = deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node currentNode, K key) {
        if (currentNode == null) {
            // Key not found, return null or throw an exception depending on the desired behavior
            return null;
        }

        int cmp = key.compareTo(currentNode.key);

        if (cmp < 0) {
            // Key is smaller, search in the left subtree
            currentNode.left = deleteRecursive(currentNode.left, key);
        } else if (cmp > 0) {
            // Key is greater, search in the right subtree
            currentNode.right = deleteRecursive(currentNode.right, key);
        } else {
            // Key found, perform deletion
            if (currentNode.left == null) {
                size--;// Decrease the size when deleting a node
                // Case 1: No left child
                // Replace the current node with its right child
                return currentNode.right;
            } else if (currentNode.right == null) {
                size--; // Decrease the size when deleting a node
                // Case 2: No right child
                // Replace the current node with its left child
                return currentNode.left;
            } else {
                // Case 3: Two children
                // Find the minimum key in the right subtree (or maximum key in the left subtree)
                Node successor = findMin(currentNode.right);
                // Copy the successor's key and value to the current node
                currentNode.key = successor.key;
                currentNode.value = successor.value;
                // Delete the successor node from the right subtree
                currentNode.right = deleteMin(currentNode.right);
            }
        }

        // Return the updated node
        return currentNode;
    }
    //Creating of findMin method
    private Node findMin(Node node) {
        // Find the minimum key in a subtree rooted at the given node
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    // deleteMin method() to delete child node when parent Node has 2 children
    private Node deleteMin(Node node) {
        // Delete the node with the minimum key in a subtree rooted at the given node
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }
    // Iterator implementation
    private class BSTIterator implements Iterator<K> {
        private Node currentNode;
        private Stack<Node> stack;

        public BSTIterator() {
            currentNode = root;
            stack = new Stack<>();
            updateStack(currentNode);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public K next() {
            Node node = stack.pop();
            updateStack(node.right);
            return node.key;
        }
        // Helper method to update the stack with nodes in the left subtree
        private void updateStack(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

    @Override
    public Iterator<K> iterator() {

        return new BSTIterator();
    }
    // Method to get the size of the BST
    public int size() {
        return size;
    }
}
