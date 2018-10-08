package com.github.zerowise.leetcode;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private Map<Integer, Node> datas;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        datas = new HashMap<Integer, Node>(capacity);
    }

    public int get(int key) {
        Node node = datas.get(key);
        if (node != null) {
            remove(node);
            addHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = datas.get(key);
        if (node != null) {
            node.value = value;
            remove(node);
            addHead(node);
        } else {
            if (isFull()) {
                datas.remove(tail.key);
                remove(tail);
            }
            node = new Node(key, value);
            addHead(node);
            datas.put(key, node);
        }
    }


    private void remove(Node node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            tail = node.pre;
        }
    }

    private void addHead(Node node) {
        node.next = head;
        node.pre = null;
        if (head != null) {
            head.pre = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
    }

    private boolean isFull() {
        return capacity == datas.size();
    }

    class Node {
        int key;
        int value;

        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}