package com.azain.weatherapp.datastructures;


public class LinkedList<T>
{
    private Node<T> head, tail;
    private int length;

    public void add(T data)
    {
        addLast(data);
    }
    public void addLast(T data) {
        if (isEmpty()) {
            tail = head = new Node(data, null, null);
        } else {
            tail.next = new Node(data, tail, null);
            tail = tail.next;
        }

        length++;
    }

    public void addFirst(T data) {
        if (isEmpty()) {
            tail = head = new Node(data, null, null);
        } else {
            head.prev = new Node(data, null, head);
            head = head.prev;
        }

        length++;
    }

    public T removeLast() {
        if (isEmpty())
            throw new RuntimeException("List is Empty!");

        T temp = tail.data;
        tail = tail.prev;
        --length;

        if (isEmpty()) {
            head = null;
        } else {
            tail.next = null;
        }

        return temp;
    }

    public T removeFirst() {
        if (isEmpty())
            throw new RuntimeException("List is Empty!");

        T temp = head.data;
        head = head.next;
        --length;

        if (isEmpty()) {
            tail = null;
        } else {
            head.prev = null;
        }

        return temp;
    }

    public T peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is Empty!");
        }
        return tail.data;
    }

    public T peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is Empty!");
        }
        return head.data;
    }


    public boolean contains(T data)
    {
        //if the list is empty then it doesn't contains the data
        if(isEmpty())
            return false;

        //traversing from head
        Node trav = head;
        while(trav != null)
        {
            //if found
            if (trav.data == data)
                return true;

            trav = trav.next;
        }

        //if not found
        return false;
    }

    public int size()
    {
        return length;
    }

    public boolean isEmpty()
    {
        //if length is equal to zero then list is empty
        return length == 0;
    }

    @Override
    public String toString() {
        if(isEmpty())
            return null;

        StringBuilder output = new StringBuilder("List: ");
        Node trav = head;
        while(trav != null)
        {
            output.append(trav.data.toString());
            trav = trav.next;
        }

        return output.toString();
    }

    //a linked list node
    private class Node<T>
    {
        private T data;
        private Node<T> prev, next;

        public Node(T data, Node<T> prev, Node<T> next)
        {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", prev=" + prev +
                    ", next=" + next +
                    '}';
        }
    }
}
