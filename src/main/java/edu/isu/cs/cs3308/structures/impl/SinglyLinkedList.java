package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.GameEntry;
import edu.isu.cs.cs3308.structures.List;

public class SinglyLinkedList<E> implements List<E> {
    /**
     *
     *
     * This is my node class, every node points to the one in front of it, but not the one
     * behind it.
     */

    public class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value, Node<E> next){
            this.value = value;
        }

        public void setNext(Node<E> next){
            this.next = next;
        }

        public Node<E> getNext(){
            return next;
        }

        public E getValue(){
            return value;
        }
    }
    public Node<E> head = null;
    public Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){}



// get the first node of the list
    @Override
    public E first() {
        if(isEmpty()){
            return null;
        }
        return head.getValue();
    }
// get the last node of the list
    @Override
    public E last() {
        if(isEmpty()){
            return null;
        }
        return tail.getValue();
    }
// add a node to the end of the list
    @Override
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element, null);
        if(isEmpty()){
            head = newNode;
        }
        else{
            tail.setNext((newNode));
        }
        tail = newNode;
        size++;
    }
// add a node to the start of the list
    @Override
    public void addFirst(E element) {
        head = new Node<>(element, head);
        if(size == 0){
            tail = head;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }
        E firstVal = head.getValue();
        head = head.getNext();
        size--;
        if(size == 0){
            tail = null;
        }
        return firstVal;
    }

    @Override
    public E removeLast() {
        if(head == null){
            return null;
        }
        if(head.next == null){
            head = null;
            size--;
        }
        Node<E> secondLast = head;
        while(secondLast.next.next != null){
            secondLast = secondLast.next;
        }
        secondLast.next = null;
        return secondLast.getValue();
    }

    @Override
    public void insert(E element, int index) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E get(int index) {
        Node<E> current = head;
        int i = 0;
        while(current != null){
            if(i == index){
                return current.getValue();
            }
            i++;
            current = current.next;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void printList() {

    }

}
