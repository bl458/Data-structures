package ds;

public class BinarySearchTree<T extends Comparable<T>> {
    private class Node {
        T val;
        Node left;
        Node right; 

        public Node(T val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public String toString() { return val.toString(); }
    }

    private Node root = null;
    private int size = 0;

    public int size() { return size; }

    public boolean isEmpty() { return size() == 0; }

    //O(logn), worst case O(n) if tree is very unbalanced
    public boolean add(T elem) {
        if (contains(elem)) return false;

        root = add(root, elem);
        size++;
        return true;
    }

    private Node add(Node node, T elem) {
        if (node == null) return new Node(elem, null, null);

        if (node.val.compareTo(elem) < 0) node.left = add(node.left, elem);
        else node.right = add(node.right, elem);

        return node;
    }

    //O(logn), worst case O(n) if tree is very unbalanced
    public boolean remove(T elem) {
        if (!contains(elem)) return false;

        root = remove(root, elem);
        size--;
        return true;
    }

    private Node remove(Node node, T elem) {
        if (node.val.compareTo(elem) < 0) node.left = remove(node.left, elem);
        else if (node.val.compareTo(elem) > 0) node.right = remove(node.right, elem);
        else {
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;
            else {
                Node biggestLeft = findMax(node.left);
                node.val = biggestLeft.val;
                node.left = remove(node.left, biggestLeft.val);
            }
        }

        return node;
    }

    private Node findMax(Node node) {
        if (node.right == null) return node;
        return node.right;
    }
    
    //O(n)
    public int height() { return height(root); }

    private int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
    
    //O(logn), worst case O(n) if tree is very unbalanced
    public boolean contains(T elem) {
        if (elem == null) return false;
        return contains(root, elem);
    }

    private boolean contains(Node node, T elem) {
        if (node == null) return false;
        
        if (node.val.compareTo(elem) < 0) return contains(node.left, elem);
        else if (node.val.compareTo(elem) > 0) return contains(node.right, elem);
        else return true;
    }

    public void preOrderRecurs() { preOrderRecurs(root); }

    private void preOrderRecurs(Node node) {
        System.out.print(node + " ");
        preOrderRecurs(node.left);
        preOrderRecurs(node.right);
    }

    public void preOrderIter() {
        Stack<Node> nodeStack = new Stack<>();
        if (root != null) nodeStack.push(root);
        
        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.pop();
            System.out.print(node + " ");
            if (node.right != null) nodeStack.push(node.right);
            if (node.left != null) nodeStack.push(node.left);
        }
    }


    public void inOrderRecurs() { inOrderRecurs(root);}

    private void inOrderRecurs(Node node) {
        preOrderRecurs(node.left);
        System.out.print(node + " ");
        preOrderRecurs(node.right);
    }

    public void inOrderIter() {
        Stack<Node> nodeStack = new Stack<>();
        Node curr = root; 

        while (curr != null || !nodeStack.isEmpty()) {
            while (curr != null) { 
                nodeStack.push(curr);
                curr = curr.left;
            }
            
            curr = nodeStack.pop();
            System.out.print(curr + " ");
            curr = curr.right;
        }
    }


    public void postOrderRecurs() { postOrderRecurs(root);}

    private void postOrderRecurs(Node node) {
        preOrderRecurs(node.left);
        preOrderRecurs(node.right);
        System.out.print(node + " ");
    }

    public void postOrderIterOneStack() {
        Stack<Node> nodeStack = new Stack<>();
        if (root != null) nodeStack.push(root);
        Node prev = null;
        
        while (!nodeStack.isEmpty()) {
            Node curr = nodeStack.peek();
            //Going down the tree to find leaf
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) nodeStack.push(curr.left);
                else if (curr.right != null) nodeStack.push(curr.right);
                else {
                    nodeStack.pop();
                    System.out.print(curr + " ");
                }
            }
            //Going up the tree from left
            else if (curr.left == prev) {
                if (curr.right != null) nodeStack.push(curr.right);
                else {
                    nodeStack.pop();
                    System.out.print(curr + " ");
                }
            }
            //Going up the tree from right
            else if (curr.right == prev) {
                nodeStack.pop();
                System.out.print(curr + " ");
            }

            prev = curr;
        }

    }

    public void postOrderIterTwoStack() {
        Stack<Node> nodeStack1 = new Stack<>();
        Stack<Node> nodeStack2 = new Stack<>();
        if (root != null) nodeStack1.push(root);
        
        while (!nodeStack1.isEmpty()) {
            Node node = nodeStack1.pop();
            nodeStack2.push(node);
            if (node.left != null) nodeStack2.push(node.left);
            if (node.right != null) nodeStack2.push(node.right);
        }

        while (!nodeStack2.isEmpty()) {
            Node node = nodeStack2.pop();
            System.out.print(node + " ");
        }
    }

    //O(n)
    public void levelOrderIter() {
        Queue<Node> q = new Queue<>();
        if (root != null) q.offer(root);

        while (!q.isEmpty()) {
            Node node = q.poll();
            System.out.print(node + " ");
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
    }

    //O(n^2) worst case, O(n) best case
    public void levelOrderRecurs() { 
        int height = height();
        for (int level=1; level<=height; level++)
            printLevel(root, level); 
    }
    
    private void printLevel(Node node, int level) {
        if (node == null) return;

        if (level == 1) System.out.print(node + " ");
        else if (level > 1) {
            printLevel(node.left, level - 1);
            printLevel(node.right, level - 1);
        }
    }
}
