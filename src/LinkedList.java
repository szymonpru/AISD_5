/**
 * Created by Szymon - Laptop on 05.04.2017.
 */
public class LinkedList {
    Element head = new Element(null);
    int size;

    public LinkedList() {
        clear();
    }

    public void add(Object value) {
        Element last = head.getNext();
        Element nEelemnt=new Element(value);
        head.setNext(nEelemnt);
        nEelemnt.setNext(last);
        size++;
    }

    public void clear() {
        head.setNext(null);
        size = 0;
    }

    public Object delete() {
        if (head.getNext() == null) return null;
        if (head.getNext().getObject() == null) return null;
        Element el = head.getNext();
        if (head.getNext().getNext() == null) {
            head.setNext(new Element(null));
        } else {
            head.setNext(head.getNext().getNext());
        }
        size--;
        return el.getObject();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void show() {
        Element el = head;
        while (el.getNext() != null) {
            el = el.getNext();
            System.out.println(el.getObject());

        }
    }
}