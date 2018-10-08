package com.github.zerowise.leetcode;

/**
 ** @createtime : 2018/10/8下午12:14
 **/
public class MyCircularQueue {

    private int head = -1;// 头部指针
    private int tail = -1;//尾部指针
    private int[] nodeArray;//数组
    private int capacity;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        capacity = k;
        nodeArray = new int[capacity];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        if (head == -1) {
            head = 0;
        }
        tail = (tail + 1) % capacity;
        nodeArray[tail] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        nodeArray[head] = 0;
        if (head == tail) {
            head = tail = -1;
            return true;
        }
        head = (head + 1) % capacity;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty())
            return -1;
        return nodeArray[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty())
            return -1;
        return nodeArray[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return head == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }


    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为3

        circularQueue.enQueue(1);  // 返回true

        circularQueue.enQueue(2);  // 返回true

        circularQueue.enQueue(3);  // 返回true

        circularQueue.enQueue(4);  // 返回false,队列已满

        circularQueue.Rear();  // 返回3

        circularQueue.isFull();  // 返回true

        circularQueue.deQueue();  // 返回true

        circularQueue.enQueue(4);  // 返回true

        circularQueue.Rear();  // 返回4
    }
}
