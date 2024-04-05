package tp1;

import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T>{

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

        while (aux != null) {
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

    public void insertarOrdenado(T info) {

    }

    @Override
    public MySimpleLinkedListIterator<T> iterator() {
        MySimpleLinkedListIterator<T> it = new MySimpleLinkedListIterator<>(this.first);
        return it;
    }

    public MySimpleLinkedList ordenarListas(MySimpleLinkedList l){
        MySimpleLinkedListIterator<T>it1=new MySimpleLinkedListIterator<>(this.first); //Podria ser this.iterator()
        MySimpleLinkedListIterator<T>it2=new MySimpleLinkedListIterator<>(l.first);

        MySimpleLinkedList lista=new MySimpleLinkedList();
        while(it1.hasNext() && it2.hasNext()){
            if (-1 == it1.getInfo().compareTo(it2.getInfo())){
                it1.next();
            }
            if (1 == it1.getInfo().compareTo(it2.getInfo())){
                it2.next();
            }
            if (0==it1.getInfo().compareTo(it2.getInfo())){
                lista.insertSorted(it1.getInfo());
                it1.next();
                it2.next();
            }
        }
        return lista;
    }

    public MySimpleLinkedList<T> getDiferenciaListas(MySimpleLinkedList<T> l2){
        MySimpleLinkedListIterator<T> it1 = this.iterator();
        MySimpleLinkedList<T> resultList = new MySimpleLinkedList<>();

        while (it1.hasNext()){
            MySimpleLinkedListIterator<T> it2 = l2.iterator();
            boolean found = false;
            while (it2.hasNext() && !found){
                if (it1.getInfo().compareTo(it2.getInfo()) != 0){
                    resultList.insertFront(it1.getInfo());
                    found = true;
                }
                it2.next();
            }
            it1.next();
        }

        return resultList;
    }


    public void insertSorted(T info){
        Node<T>aux=this.first;

        while(aux!=null){
            if(-1==info.compareTo(aux.getInfo())){

            }
        }
    }
}