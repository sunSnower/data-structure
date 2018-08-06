package com.binary.tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BinaryTree {
    BinaryTreeNode<String> root;

    /**
     * 初始化二叉树，根据指定的节点构造完全二叉树
     * @param sumNodes
     */
    public void initTree(int sumNodes){
        if(sumNodes <= 0){
            return;
        }
        else if(sumNodes == 1){
            root = new BinaryTreeNode<String>();
            root.setValue("root");
        }
        else{
            root = new BinaryTreeNode<String>();
            root.setValue("root");
            for(int i = 1; i < sumNodes; i++){
                BinaryTreeNode<String> node = new BinaryTreeNode<String>();
                node.setValue(i+"node");
                insertOnCompleteTree(root, node);
            }
        }
    }

    /**
     * 按照完全二叉树构建二叉树
     * @param tempRoot
     * @param node
     */
    public void insertOnCompleteTree(BinaryTreeNode<String> tempRoot, BinaryTreeNode<String> node){
        if(tempRoot == null){
            return;
        }
        if(tempRoot.getLeNode() == null){
            tempRoot.setLeNode(node);
            return;
        }
        else if(tempRoot.getRiNode() == null){
            tempRoot.setRiNode(node);
            return;
        }
        else{
            if(tempRoot.getLeNode().getLeNode()==null || tempRoot.getLeNode().getRiNode()==null){
                insertOnCompleteTree(tempRoot.getLeNode(), node);
            }
            else{
                insertOnCompleteTree(tempRoot.getRiNode(), node);
            }
        }
    }
    /**
     * 按有序树规则插入指定节点
     */
    public void insertNode(BinaryTreeNode<String> tempRoot, BinaryTreeNode<String> node){
        if(tempRoot == null){
            return;
        }
        if(tempRoot.getLeNode() == null && tempRoot.getValue().compareTo(node.getValue()) >= 0){
            tempRoot.setLeNode(node);
        }
        else if(tempRoot.getRiNode() == null && tempRoot.getValue().compareTo(node.getValue()) < 0){
            tempRoot.setRiNode(node);
        }
        else if(tempRoot.getLeNode() != null){
            insertNode(tempRoot.getLeNode(), node);
        }
        else{
            insertNode(tempRoot, node);
        }
    }

    /**
     * 二叉树遍历
     */
    public void recursionTraverse(BinaryTreeNode<String> tempRoot){
        /**
         * 递归遍历
         */
        if(tempRoot == null){
            return;
        }
        System.out.println(tempRoot.getValue());
        recursionTraverse(tempRoot.getLeNode());
        recursionTraverse(tempRoot.getRiNode());
    }

    /**
     * 二叉树非递归遍历
     * 用栈实现
     */
    public void stackTraverse(){
        Stack<BinaryTreeNode<String>> stack = new Stack<BinaryTreeNode<String>>();
        BinaryTreeNode<String> tempRoot = this.root;
        while(true){
            if(tempRoot != null){
                System.out.println(tempRoot.getValue());
                if(tempRoot.getRiNode() != null){
                    stack.push(tempRoot.getRiNode());
                }
                if(tempRoot.getLeNode() != null){
                    tempRoot = tempRoot.getLeNode();
                }
                else if(!stack.isEmpty()){
                    tempRoot = stack.pop();
                }
                else{
                    break;
                }
            }
        }
    }


    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.initTree(7);

        binaryTree.stackTraverse();
        binaryTree.recursionTraverse(binaryTree.getRoot());
        System.out.println("hello world!");
    }
}
