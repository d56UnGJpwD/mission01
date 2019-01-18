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
        if(element != null){
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

    }
// add a node to the start of the list
    @Override
    public void addFirst(E element) {
        if(element != null){
            head = new Node<>(element, head);
            if(size == 0){
                tail = head;
                size++;
            }
        }
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
        }
        Node<E> secondLast = head;
        while(secondLast.next.next != null){
            secondLast = secondLast.next;
        }
        Node<E> temp = secondLast.getNext();
        secondLast.next = null;
        size--;
        return tail.getValue();
    }

    @Override
    public void insert(E element, int index) {
        Node<E> newNode = new Node(element, null);
        if(element != null){
            if(head == null && index !=0){}
            else if(head == null && index == 0){
                head = newNode;
                size++;
            }
            if(index == 0){
                newNode.next = head;
                head = newNode;
                size++;
            }
            Node<E> current = head;
            Node<E> prev = null;
            int i = 0;
            while(i < index && current!=null){
                prev = current;
                current = current.next;
                i++;
            }
            newNode.next = current;
            prev.next = newNode;
            size++;
        }

    }

    @Override
    public E remove(int index) {
    if(head == null){
        return null;
    }
    Node<E> temp = head;
    if(index == 0){
        head = temp.next;
        temp = null;
        return temp.getValue();
    }
    if(index < 0){
        return null;
    }
    for(int i=0; temp!=null && i<index-1; i++){
        temp = temp.next;
    }
    if(temp==null || temp.next == null){
        return null;
    }
    Node<E> next = temp.next.next;
    Node<E> del = temp.getNext();
    temp.next = next;
    size--;
    return del.getValue();
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
        Node<E> current = head;
        while(current != null){
            System.out.println(current.getValue());
            current = current.next;
        }
    }

}
