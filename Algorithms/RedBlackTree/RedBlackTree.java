public class RedBlackTree<T extends Comparable<T>> {
    private Node<T> root;

    private enum Color {
        RED,
        BLACK
    }

    public RedBlackTree() {
        root = null;
    }

    public Node<T> insert(T value) {
        root = insert(root, value);
        root.color = Color.BLACK;
        return root;
    }
    
    private Node<T> insert(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value, Color.RED);
        }
    
        int cmp = value.compareTo(current.value);
        if (cmp < 0) {
            current.left = insert(current.left, value);
        } else if (cmp > 0) {
            current.right = insert(current.right, value);
        } else {
            return current;
        }
    
        if (isRed(current.right) && !isRed(current.left)) {
            current = rotateLeft(current);
        }

        if (isRed(current.left) && isRed(current.left.left)) {
            current = rotateRight(current);
        }

        if (isRed(current.left) && isRed(current.right)) {
            flipColors(current);
        }
    
        return current;
    }
    
    private Node<T> rotateLeft(Node<T> current) {
        Node<T> newRoot = current.right;
        current.right = newRoot.left;
        newRoot.left = current;
        newRoot.color = current.color;
        current.color = Color.RED;
        return newRoot;
    }

    private Node<T> rotateRight(Node<T> current) {
        Node<T> newRoot = current.left;
        current.left = newRoot.right;
        newRoot.right = current;
        newRoot.color = current.color;
        current.color = Color.RED;
        return newRoot;
    }

    private void flipColors(Node<T> current) {
        current.color = Color.RED;
        current.left.color = Color.BLACK;
        current.right.color = Color.BLACK;
    }

    private boolean isRed(Node<T> node) {
        if (node == null) {
            return false;
        }
        return node.color == Color.RED;
    }

    public void printTree() {
        printTree(root, "", true);
    }
    
    private void printTree(Node<T> node, String prefix, boolean isRight) {
        if (node != null) {
            printTree(node.right, prefix + (isRight ? "    " : "|   "), true);
            System.out.println(prefix + (isRight ? "┌───" : "└───") + node.value + "(" + (node.color == Color.RED ? "R" : "B") + ")");
            printTree(node.left, prefix + (isRight ? "|   " : "    "), false);
        }
    }

    public boolean isValid(Node<T> node) {
        if (node == null) {
            return true;
        }
    
        // Условие: корень дерева всегда черный
        if (node == root && node.color != Color.BLACK) {
            return false;
        }
    
        // Условие: красные ноды могут быть только левым ребенком
        if (isRed(node) && (isRed(node.left) || isRed(node.right))) {
            return false;
        }
    
        // Условие: у красной ноды все дети черного цвета
        int blackHeightLeft = countBlackHeight(node.left);
        int blackHeightRight = countBlackHeight(node.right);
    
        // Условие: каждый путь от корня до листа содержит одинаковое количество черных нод
        if (blackHeightLeft != blackHeightRight) {
            return false;
        }
    
        return isValid(node.left) && isValid(node.right);
    }
    
    public int countBlackHeight(Node<T> node) {
        if (node == null) {
            return 1;
        }
    
        int leftBlackHeight = countBlackHeight(node.left);
        int rightBlackHeight = countBlackHeight(node.right);
    
        return node.color == Color.BLACK ? Math.max(leftBlackHeight, rightBlackHeight) + 1 : Math.max(leftBlackHeight, rightBlackHeight);
    }
    
    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;
        Color color;

        Node(T value, Color color) {
            this.value = value;
            left = null;
            right = null;
            this.color = color;
        }
    }

    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<>();

        System.out.println(tree.isValid(tree.insert(10)));
        System.out.println(tree.isValid(tree.insert(20)));
        System.out.println(tree.isValid(tree.insert(30)));
        System.out.println(tree.isValid(tree.insert(40)));
        System.out.println(tree.isValid(tree.insert(50)));
        System.out.println(tree.isValid(tree.insert(60)));
        System.out.println(tree.isValid(tree.insert(70)));
        System.out.println(tree.isValid(tree.insert(80)));
        System.out.println(tree.isValid(tree.insert(90)));
        System.out.println(tree.isValid(tree.insert(100)));
        System.out.println(tree.isValid(tree.insert(110)));

        tree.printTree();
    }
}