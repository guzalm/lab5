# lab5
BINARY SEARCH TREE

STEP 1: I started creating of BST class, first step was initializing private root and then adding of inner class representing a node in the binary search tree.

STEP 2: Adding constructor for creating a new node with a key-value pair by using "this"

STEP 3: Creating of put() method. I created put method with helper method putRecursive() to call it. And put here any statements as if the current node is null, create a new node with the given key and value. Then program should compare the given key with the key of the current node. If given is less than current, traverse to the left subtree. If more, traverse to the right subtree.

STEP 4: Creating of get() method. I created this method also with helper one which calls getRecursive(). Used statementts as if current node is null, Key not found, return null or throw an exception depending on the desired behavior. Int cmp help us to compare key with current key, and if Key is smaller, search in the left subtree, if greater, search in the right.

STEP 5: Creating of delete() method. I created put method with helper method deleteRecursive() to call it. There are also any statements like what it does when key is empty, in comparing to current node key is smaaller or greater, solvings of some situations as if there is no left or right child. And also used some other sub methods as findmin or deletemin, because to find the minimum key in the right subtree (or maximum key in the left subtree) and to delete the successor node from the right subtree.

STEP 6: How I mentioned before, we need findMin() method to find the minimum key in a subtree rooted at the given node and delete it when Node has two children.

STEP 7: To delete the node with the minimum key in a subtree rooted at the given node, after finding the min by method findMin(), it should be deleted by another new method deleteMin() where we also used if statement to show if one of nodes is empty(null), it might return second node.

STEP 8: Adding Iterable<K> iterator().This interface requires the implementation of the iterator() method, which returns an instance of the Iterator<K> interface. Calling of the updateStack() method to push all the nodes of the left subtree onto the stack. hasNext() method checks if there are any more nodes to be processed, than returns true or false.
