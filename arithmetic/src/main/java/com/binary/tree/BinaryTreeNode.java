package com.binary.tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BinaryTreeNode<T>{
    private T value;
    private BinaryTreeNode<T> leNode;
    private BinaryTreeNode<T> riNode;
}
