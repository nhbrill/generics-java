/*
* AUTHOR: Nate Brill
* FILE: ListQueue.java
* PURPOSE: To implement a queue backed by a linked list with generic's.
*/
public class ListQueue<E> implements QueueInterface<E> {
    private Node<E> front;

    public ListQueue() {
        /*
         * PURPOSE: To initialize a ListQueue ADT by setting the front equal
         * to null.
         */
        this.front = null;
    }

    @Override
    public void enqueue(E value) {
        /*
         * PURPOSE: To add to the linked list by iterating to the end of the
         * list and then setting the next node to a node with the passed in
         * value as it's stored data.
         * 
         * @param value, a value being added to the list.
         */
        Node<E> newNode = new Node<E>(value, null);
        if (this.front == null) {
            this.front = newNode;
        } else {
            Node<E> temp = this.front;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    @Override
    public E dequeue() {
        /*
         * PURPOSE: To remove the first node in the list, returning null if
         * there are no nodes in the list.
         * 
         * @return value, the data being removed from the front of the stack.
         */
        if (this.front == null) {
            return null;
        } else {
            E value = this.front.data;
            this.front = this.front.next;
            return value;
        }
    }

    @Override
    public E peek() {
        /*
         * PURPOSE: Returns the first value in the list.
         * 
         * @return E, the data of the first node in the list.
         */
        if (this.front == null) {
            return null;
        } else {
            return this.front.data;
        }
    }

    @Override
    public boolean isEmpty() {
        /*
         * PURPOSE: To determine if the list is empty.
         * 
         * @return boolean, returns true if the list is empty and false if not.
         */
        if (this.front == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        /*
         * PURPOSE: To return the size of the list by iterating through every
         * node and keeping track of how many iterations.
         * 
         * @return size, the size of the list.
         */
        Node<E> temp = this.front;
        int size = 0;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    @Override
    public void clear() {
        /*
         * PURPOSE: To clear the list by resetting the front node to null.
         */
        this.front = null;
    }

    public ListQueue<E> copy() {
        /*
         * PURPOSE: To return an exact copy of the queue, by creating a new
         * queue and putting all the values in the current queue in the new
         * queue.
         * 
         * @return newQueue, a new ListQueue with all the values.
         */
        ListQueue<E> newQueue = new ListQueue<E>();
        Node<E> temp = this.front;
        while (temp.next != null) {
            newQueue.enqueue(temp.data);
            temp = temp.next;
        }
        newQueue.enqueue(temp.data);
        return newQueue;
    }

    @Override
    public String toString() {
        /*
         * PURPOSE: To create a string representation of the linked list.
         * 
         * @return stringQ, the string representation of the linked list.
         */
        String stringQ = "{ ";
        Node<E> temp = this.front;
        while (temp.next != null) {
            stringQ += temp.data + ", ";
            temp = temp.next;
        }
        stringQ += "}";
        return stringQ;
    }

    @Override
    public boolean equals(Object o) {
        /*
         * PURPOSE: Determines whether an object is an ListQueue and then
         * whether the size is the same, as well as all the nodes in the
         * linked list have equivalent data.
         * 
         * @param o, an object.
         * 
         * @return boolean, if the object is equal return true if not return
         * false.
         */
        if (!(o instanceof ListQueue)) { // If the object is an ListQueue.
            return false;
        }
        ListQueue<E> other = (ListQueue<E>) o;
        if (this.size() == other.size()) { // If the object has the same size.
            Node<E> temp1 = this.front;
            Node<E> temp2 = other.front;
            while (temp1.next != null) {
                // If the object has the same element at the same position.
                if (temp1.data != temp2.data) {
                    return false;
                }
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return true;
        } else {
            return false;
        }
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

}
