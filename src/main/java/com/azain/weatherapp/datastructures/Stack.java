package com.azain.weatherapp.datastructures;

public class Stack<T>
{
    private LinkedList<T> list;

    public Stack()
    {
        list = new LinkedList<>();
    }

    public void push(T data)
    {
        list.addFirst(data);
    }

    public T pop()
    {
        return list.removeFirst();
    }

    public T peek()
    {
        return list.peekFirst();
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public boolean contains(T data)
    {
        return list.contains(data);
    }

    public int size()
    {
        return list.size();
    }
}
