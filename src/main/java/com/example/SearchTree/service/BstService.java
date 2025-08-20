package com.example.SearchTree.service;

import com.example.SearchTree.model.TreeEntity;
import com.example.SearchTree.repo.TreeRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BstService {
    private TreeRepo repo;
    private ObjectMapper map = new ObjectMapper();

    public BstService(TreeRepo repo) {
        this.repo = repo;
    }


    public static class Node {
        public int val;
        public Node left, right;
        public Node(int val) {this.val=val;}
    }

    public Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.left, val);
        return root;
    }

    public Node buildBST(int[] numbers) {
        Node root = null;
        for (int i : numbers) root = insert(root, i);
        return root;
    }

    public TreeEntity saveTree(String inNum, Node root) throws Exception{
        String json = map.writeValueAsString(root);
        TreeEntity e = new TreeEntity(inNum, json   );
        return repo.save(e);
    }

    public List<TreeEntity> getAllTree() {
        return repo.findAll();
    }
}
