//Min heap
public class BinarySearchTree<T extends Comparable<T>> {
    private int nodeCount = 0;
    private Node root = null;
    
    private class Node {
        private T data;
        private Node left;
        private Node right;

        private Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public int size() { return nodeCount; }

    public boolean isEmpty() {return size() == 0;}

    public boolean add(T elem) {
        if (!contains(root, elem)) return false;
        
        root = add(root, elem);
        nodeCount++;
        return true;
    }

    private Node add(Node node, T elem) {
        if (node == null) 
            return new Node(elem, null, null);
        
        if (elem.compareTo(node.data) < 0) node.left = add(node.left, elem); 
        else node.right = add(node.right,elem);
        return node;
    }

    public boolean remove(T elem) {
        if (!contains(root, elem)) return false;
        
        root = remove(root, elem);
        nodeCount--;
        return true;
    }

    private Node remove(Node node, T elem) {
        if (node == null) return null;

        if (elem.compareTo(node.data) < 0) {
            node.left = remove(node.left, elem);
        }
        else if (elem.compareTo(node.data) > 0) {
            node.right = remove(node.right, elem);
        }
        else {
            if (node.left == null) 
                node = node.right;
            else if (node.right == null) 
                node = node.left;
            else {
                Node smallestRight = findMin(node.right);
                node.data = smallestRight.data;
                node.right = remove(node.right, smallestRight.data);               
            }
        }

        return node; 
    }

    private Node findMin(Node node) {
        while (node.left != null) node = node.left; 
        return node;
    }

    public boolean contains(T elem) {return contains(root, elem);}

    private boolean contains(Node node, T elem) {
        while (node != null) {
            if (elem.compareTo(node.data) < 0) node = node.left;
            else if (elem.compareTo(node.data) > 0) node = node.right;
            else return true;
        }

        return false;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.left;
        }
        return count;
    }

    public java.util.Iterator<T> traverse(TreeTraversalOrder order) {
        switch (order) {
            case PRE_ORDER:
                return preOrderTraversal();
            case IN_ORDER:
                return inOrderTraversal();
            case POST_ORDER:
                return postOrderTraversal();
            default:
                return null;
        }
    }

    private java.util.Iterator<T> preOrderTraversal() {
        final int expectedNodeCount = nodeCount;
        final java.util.Stack<Node> stack = new java.util.Stack<>();
        stack.push(root);
        
        return new java.util.Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
                return root!=null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
                Node middle = stack.pop();
                if (middle.right != null) stack.add(middle.right);
                if (middle.left != null) stack.add(middle.left);
                return middle.data; 
            }

            @Override
            public void remove() {
              throw new UnsupportedOperationException();
            }
        };
    }

    private java.util.Iterator<T> inOrderTraversal() {
        final int expectedNodeCount = nodeCount;
        final java.util.Stack<Node> stack = new java.util.Stack<>();
        stack.push(root);
        
        return new java.util.Iterator<T>() {
            Node trav = root; 
            
            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
                return root!=null && !stack.isEmpty();
            }

            @Override
            public T next() {
                //Dig left
                while (trav != null && trav.left != null) {
                    stack.push(trav.left);
                    trav = trav.left;
                }

                Node tmp = stack.pop();
                if (tmp.right != null) {
                    stack.push(tmp.right);
                    trav = tmp.right;
                }

                return tmp.data;
            }

            @Override
            public void remove() {
              throw new UnsupportedOperationException();
            }
        };
    }

    private java.util.Iterator<T> postOrderTraversal() {
        final int expectedNodeCount = nodeCount;
        final java.util.Stack<Node> stack1 = new java.util.Stack<>();
        final java.util.Stack<Node> stack2 = new java.util.Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            if (node != null) {
              stack2.push(node);
              if (node.right != null) stack1.push(node.right);
              if (node.left != null) stack1.push(node.left);
            }
        }

        return new java.util.Iterator<T>() {
            @Override
            public boolean hasNext() {
                if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
                return root != null && !stack2.isEmpty();
            }

            @Override
            public T next() {
                if (expectedNodeCount != nodeCount) throw new java.util.ConcurrentModificationException();
                return stack2.pop().data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }            
        };
    }
}
