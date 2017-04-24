/**
 * Created by Szymon - Laptop on 05.04.2017.
 */
public class Element {
    private Object object;
    private Element next;

    public Element(Object object){
        this(object,null);
    }
    public Element(Object object, Element el){
        this.object=object;
        next=el;
    }
    public Object getObject(){
        return object;
    }
    public Element getNext(){
        return next;
    }
    public void setNext(Element n){
        next=n;
    }
    public void setCard(Object o){
        object=o;
    }
}
