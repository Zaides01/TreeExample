package my.tree;

import java.util.Random;
import java.util.TreeSet;

/**
 * Created by sma on 18.02.2016.
 */
public class BinaryTreeExample {
    int value;
    BinaryTreeExample lchild; // левый потомок
    BinaryTreeExample rchild; // правый потомок

    public BinaryTreeExample(int value) {
        this.value = value;
        this.lchild = null;
        this.rchild = null;
    }

    public BinaryTreeExample() {
        this.value = -1; // значение для пустого узла
        this.lchild = null;
        this.rchild = null;
    }

    /* метод вставки элементов в дерево root - ссылка на текущий узел дерева valueNode - значение, которое добавляем в дерево */
    public void insertNode(BinaryTreeExample root, int valueNode) {
        // если дерево пустое
        if (root.value == -1) {
            root.value = valueNode; // записываем значение в узел
            return;
        }
        /*если значение в текущем узле больше valueNode, то переходим в левое поддерево*/
        if (root.value > valueNode) {
            //если левого потомка нет, то создаем его с значением valueNode
            if (root.lchild == null)
                root.lchild = new BinaryTreeExample(valueNode);
                // если левый потомок есть, то переходим ниже в левое поддерево
            else
                insertNode(root.lchild, valueNode);
        }
        /*если значение в текущем узле меньше  вставляемого, то переходим в правое  поддерево*/
        else if (root.value < valueNode) {
            //если правого потомка нет, то создаем его с значением valueNode
            if (root.rchild == null)
                root.rchild = new BinaryTreeExample(valueNode);
                // если правый потомок есть, то переходим ниже в правое поддерево
            else
                insertNode(root.rchild, valueNode);
        }
    }
    // метод вывода дерева на экран
    public void printBinaryTree(BinaryTreeExample root, int level) {
        if (root != null) {
            //TODO вывести левое поддерево
            printBinaryTree(root.lchild, level+2);
            for (int i = 0; i < level; i++)
                System.out.print("   ");//чем ниже уровень, тем отступ больше
            //TODO вывести значение узла
            System.out.println(root.value);
            //TODO вывести правое поддерево
            printBinaryTree(root.rchild, level+2);
        }
    }

    public static void main(String[] args) {
        // TODO создать массив значений для добавления в дерево
        Random random = new Random();
        int b[] = new int[25];
        for (int i = 0; i < b.length; i++) {
            b[i] = random.nextInt(100);
        }
        BinaryTreeExample tree = new BinaryTreeExample();
        // добавление элементов массива в дерево
        for (int i = 0; i < b.length; i++)
            tree.insertNode(tree, b[i]);
        // вывод содержимого дерева
        tree.printBinaryTree(tree, 0);


        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < b.length; i++) {
            treeSet.add(b[i]);
        }
        System.out.println(treeSet);
        
    }
}


