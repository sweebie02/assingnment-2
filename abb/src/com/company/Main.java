package com.company;

import java.util.*;

import java.util.ArrayList;
import java.util.Scanner;

class MaxHeap {
    private int[] arr;
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize) {
        this.size = 0;
        arr = new int[maxsize + 1];
        this.maxsize = maxsize;
        arr[0] = 100000000;
    }

    int getParent(int pos){
        return pos / 2;
    }

    int leftChild(int pos){
        return 2 * pos;
    }
    int rightChild(int pos){
        return (2 * pos) + 1;
    }
    void insert(int value){
        arr[++size] = value;
        int cur = size;
        while(arr[cur] > arr[getParent(cur)]){
            swap(cur, getParent(cur));
            cur = getParent(cur);
        }
    }

    void swap(int pos, int pos1){
        int temp = arr[pos];
        arr[pos] = arr[pos1];
        arr[pos1] = temp;
    }

    void maxHeapify(int pos){
        if(pos > (size / 2) && pos <= size){
            return;
        }
        if(arr[pos] < arr[leftChild(pos)] || arr[pos] < arr[rightChild(pos)]){
            if(arr[leftChild(pos)] > arr[rightChild(pos)]){
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    int extractMax(){
        int temp = arr[1];
        arr[1] = arr[size--];
        maxHeapify(1);
        return temp;
    }

    int getMax(){
        return arr[1];
    }

    int size(){
        return this.size;
    }
    boolean isEmpty(){
        return !(size > 0);
    }
}

public class Main {

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(100);

        maxHeap.insert(10);
        maxHeap.insert(-100);
        maxHeap.insert(133300);
        maxHeap.insert(1337);
        maxHeap.insert(-1000000);
        maxHeap.insert(23233);

        System.out.println(maxHeap.size());

        System.out.println(maxHeap.getMax());

        maxHeap.extractMax();

        System.out.println(maxHeap.getMax());

        maxHeap.extractMax();
        System.out.println(maxHeap.getMax());
        maxHeap.extractMax();
        maxHeap.extractMax();
        maxHeap.extractMax();
        maxHeap.extractMax();

        System.out.println(maxHeap.isEmpty());

    }
}