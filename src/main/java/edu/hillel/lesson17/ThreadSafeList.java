package edu.hillel.lesson17;

import java.util.ArrayList;

public class ThreadSafeList<E> extends ArrayList<E> {

    @Override
    public boolean add( E e) {
        synchronized (this){
            return super.add(e);
        }
    }

    @Override
    public E get(int index) {
        synchronized (this) {
            return super.get(index);
        }
    }

    @Override
    public E remove(int index) {
        synchronized (this) {
            return super.remove(index);
        }
    }

}
