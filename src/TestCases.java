
public class TestCases {

    public static void main(String[] args) {
        QueueInterface<Integer> q = new ListQueue<Integer>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(1);
        q.enqueue(3);
        q.enqueue(1);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(0);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        q.enqueue(8);
        q.enqueue(9);
        q.enqueue(10);
        q.enqueue(0);
        System.out.println(q);

        StackInterface<String> s = new ListStack<String>();
        s.push("Hello World");
        s.push("hi ");
        s.push("The World is");
        s.push("yours");
        System.out.println(s);
        StackInterface<String> se = s.copy();
        System.out.println(se);
        System.out.println(s.equals(se));

        // StackInterface<Integer> s = new ListStack<Integer>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // System.out.println(s.pop());
        // s.push(4);
        // System.out.println(s.peek());
        // s.push(5);
        // s.push(6);
        // System.out.println(s);
    }

}
