package com.chernyshov777.treesolution;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Tree tree5 = new Tree(5, null, null);
        Tree tree4 = new Tree(4, tree5, null);
        Tree tree55 = new Tree(5, tree4, null);
        Tree additionalTree = new Tree(2, null, null);
        Tree tree1 = new Tree(1, additionalTree, null);
        Tree tree6 = new Tree(6, null, null);
        Tree tree66 = new Tree(6, tree1, tree6);
        Tree root = new Tree(4, tree55, tree66);

        int solution = solution(root);
        System.out.println(solution);
    }

    public static int solution(Tree tree) {
        Set<Integer> numbersInPath = new HashSet<>(2334);
        int depth = 0;
        return getPathLength(tree, depth, numbersInPath);
    }

    /**
     * Находит самый длинный путь из отличающихся чисел в дереве.
     *
     * @param tree          дерево, самый длинный путь которого нужно найти
     * @param currentDepth  текущая длина пути из отличающихся чисел
     * @param numbersInPath коллекция, хранящая числа входящие в текущий путь
     * @return глубина самого длинного пути из отличающихся чисел в дереве.
     */
    private static int getPathLength(Tree tree, int currentDepth, Set<Integer> numbersInPath) {
        if (numbersInPath.contains(tree.x)) {
            return currentDepth;
        } else {
            numbersInPath.add(tree.x);
            currentDepth++;
            int leftTreePath = currentDepth;
            int rightTreePath = currentDepth;
            if (tree.l != null) {
                leftTreePath = getPathLength(tree.l, currentDepth, numbersInPath);
            }
            if (tree.r != null) {
                rightTreePath = getPathLength(tree.r, currentDepth, numbersInPath);
            }
            return leftTreePath > rightTreePath ? leftTreePath : rightTreePath;
        }
    }
}
