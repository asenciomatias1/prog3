package tp1;

import java.util.Iterator;

public class MySimpleLinkedListIterator<T> implements Iterator<T> {
    private Node<T> currentNode;
    private int contador;

    public MySimpleLinkedListIterator (Node<T> head) {
        this.currentNode = head;
        this.contador = 0;
    }

    @Override
    public boolean hasNext() {
        return this.currentNode != null;
    }

    @Override
    public T next() {
        if (this.hasNext()) {
            T info = currentNode.getInfo();
            this.currentNode = currentNode.getNext();
            this.contador++;
            return info;
        }
        return null;
    }

    public T getInfo(){
        return currentNode.getInfo();
    }

    public int getContador() {
        return this.contador;
    }
}
