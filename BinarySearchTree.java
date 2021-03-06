package com.bridzlab;

public class BinarySearchTree<T extends Comparable<T>> {
    static Node root;

    public static void main(String[] args) {
        System.out.println("Welcome to Binary Search Tree Program");
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        int[] elements = {56, 30, 70, 40, 22, 60, 95, 65, 63, 67, 11, 16, 3};
        for (Integer i : elements) {
            binarySearchTree.add(i);
        }
        System.out.println("In the Tree is  :" + binarySearchTree.searchNode(63));
        binarySearchTree.findNode(56);
        System.out.println();
        System.out.println();
        System.out.println("InOrder Print is left-->root-->right:");
        binarySearchTree.inOrderPrint(root);
        System.out.println();
               System.out.println("Size of the elements is : " + binarySearchTree.size());
       System.out.println("PreOrder Print is root-->left-->right:");
       binarySearchTree.preOrderPrint(root);
       System.out.println();
       System.out.println("PostOrder Print is left-->right-->root:");
       binarySearchTree.postOrderPrint(root);

    }

    public Node<T> insertElements(Node<T> root, T key) {
        if (root == null) {
            root = new Node<>(key);
        }
        if (key.compareTo(root.key) < 0) {
            root.left = insertElements(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            root.right = insertElements(root.right, key);
        }
        return root;
    }

    public void add(T key) {
        root = insertElements(root, key);
    }

    public void inOrderPrint(Node<T> node) {
        if (node != null) {
            inOrderPrint(node.left);
            System.out.print(node.key + " -->");
            inOrderPrint(node.right);

        }
    }

    public boolean findingNode(Node<T> root, T key) {
        if (root == null) {
            return false;
        } else if (key.compareTo(root.key) == 0) {
            return true;
        } else {
            if (key.compareTo(root.key) < 0) {
                return findingNode(root.left, key);
            } else {
                return findingNode(root.right, key);
            }
        }
    }

    public boolean searchNode(T key) {
        System.out.println("Element :" + key);
        return findingNode(root, key);
    }
// finding node in another way following this
    public void findNode(T key) {
        if (root == null) {
            System.out.println("Tree is empty");
        }
        if (root.key.compareTo(key) == 0) {
            System.out.println(key+" : Element found in the data : ");
        } else {
            System.out.println(key+" : Element not found in the data  :");
        }
    }

}

   public void preOrderPrint(Node<T> node) {
        if (node != null) {
            System.out.print(node.key + "-->");
            preOrderPrint(node.left);
            preOrderPrint(node.right);
       }
   }

   public void postOrderPrint(Node<T> node) {
       if (node != null) {
           preOrderPrint(node.left);
           preOrderPrint(node.right);
           System.out.print(node.key + "-->");
       }
   }

   public int findingSize(Node<T> root) {
       if (root == null) {
           return 0;
       } else {
           return findingSize(root.right) + 1 + findingSize(root.left);
       }
   }

   public int size() {
       return findingSize(root);

   }
