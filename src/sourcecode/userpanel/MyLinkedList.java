package sourcecode.userpanel;

class MyLinkedList<T> {

    // Node class to represent each element in the list
    class Node {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    // Method to add a new element to the end of the list
    public void add(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Method to remove all elements from the current list that are in the given list
    public void removeAll(MyLinkedList<Integer> pr) {
        Node current = head;

        while (current != null) {
            Node next = current.next;

            if (contains(current.data)) {
                // Remove the current node
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next; // Removing head
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev; // Removing tail
                }
            }

            current = next;
        }
    }

    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index must be non-negative.");
        }
    
        Node current = head;
        int count = 0;
    
        while (current != null) {
            if (count == index) {
                return current.data;
            }
            current = current.next;
            count++;
        }
    
        throw new IndexOutOfBoundsException("Index out of bounds.");
    }

    public boolean contains(T element) {
        Node current = head;
    
        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
    
        return false;
    }    
}
