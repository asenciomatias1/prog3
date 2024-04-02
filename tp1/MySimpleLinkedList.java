package tp1;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T>{

    protected Node<T> first;

    public MySimpleLinkedList() {
        this.first = null;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info,null);
        tmp.setNext(this.first);
        this.first = tmp;
    }

    public T extractFront() {
        Node<T> tmp = new Node<>(this.first.getInfo(), this.first.getNext());
        this.first = tmp.getNext();
        return tmp.getInfo();
    }

    public boolean isEmpty() {
        if (this.first == null)
            return true;

        return false;
    }

    public T get(int index) {
        Node<T> aux = this.first;
        int pos = 0;

        while ((aux != null) && (aux.getNext() != null)) {
            if (pos == index){
                return aux.getInfo();
            }
            pos++;
            aux = aux.getNext();
        }
        return null;
    }

    public int indexOf(T info) {
        Node<T> aux = this.first;
        int pos = 0;

        while ((aux != null) && (aux.getNext() != null)) {
            if (aux.getInfo() == info) {
                return pos;
            }
            pos++;
            aux = aux.getNext();
        }
        return -1;
    }

    public int size() {
        Node<T>  aux = this.first;
        int size = 0;

        while ((aux != null) && (aux.getNext() != null)) {
            aux = aux.getNext();
            size++;
        }
        return size;
    }

    @Override
    public String toString() {
        Node<T> aux = this.first;
        String res = "";

        while ((aux != null) && (aux.getNext() != null)) {
            res = res + aux.getInfo().toString() + "->";
            aux = aux.getNext();
        }

        return res;
    }

    @Override
    public Iterator<T> iterator() {
        MySimpleLinkedListIterator<T> it = new MySimpleLinkedListIterator<>(this.first);
        return it;
    }
}