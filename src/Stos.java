import java.util.EmptyStackException;

/**
 * Created by Szymon - Laptop on 05.04.2017.
 */
public class Stos implements Stack{

    private final LinkedList list;

    public Stos(){
        list  = new LinkedList();
    }

    public void push(Object value) {
        list.add(value);
    }

    public Object pop() throws EmptyStackException {
        if (empty()) {
            throw new EmptyStackException();
        }
        return list.delete();
    }

    public Object peek() throws EmptyStackException {
        Object result = pop();
        push(result);
        return result; }

    public void enqueue(Object value) {
        push(value); }

    public Object dequeue() throws EmptyStackException {
        try { return pop();
        } catch (EmptyStackException e)
        { throw new EmptyStackException(); } }

    public void clear() {
        list.clear(); }

    public int size() {
        return list.size(); }

    public boolean empty() {
        return list.isEmpty(); }


}
