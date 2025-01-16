import java.util.*;


public class LinkedList<E> implements Iterable<E> {
    private static int size = 0;
    private Node<E> lastReturned;
    private Node<E> next;
    private int nextIndex;

    Node<E> head = new Node<E>(null);
    Node<E> tail = new Node<E>(null);

    public void remove(E element) {
        Node<E> currentNode = head;
        if (head == null)
            return;
        while (currentNode.getNextNode() != null) {
            if (currentNode.getData().equals(element)) {
                Node<E> nextNode = currentNode.getNextNode();
                Node<E> prevNode = currentNode.getPrevNode();
                if (prevNode == null) {
                    head = nextNode;
                } else {
                    prevNode.setNextNode(nextNode);
                }
                if (nextNode == null) {
                    tail = prevNode;
                } else {
                    nextNode.setPrevNode(prevNode);
                }

                size--;
                return;

            }
            currentNode = currentNode.getNextNode();


        }


    }

    public LinkedList(Collection<? extends E> c) {
        if (c != null) {
            for (E element : c) {
                add(element);
            }
        }
    }


    public boolean add(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.head == null) {
            head = newNode;
            next = head;
            tail = newNode;
            size++;
            return true;
        } else {
            Node<E> currentNode = head;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
            newNode.setPrevNode(currentNode);
            tail = newNode;
            size++;
            return true;
        }
    }

    public void display() {
        if (head != null) {
            Node<E> currentNode = head;
            while (currentNode.getNextNode() != null) {
                System.out.println(currentNode.getData());
                currentNode = currentNode.getNextNode();
            }
            System.out.println(currentNode.getData());

        }
    }


    public void set(int position, E element) {
        Node<E> currentNode;
        if (position <= (size << 2)) {
            currentNode = head;
            for (int j = 1; j < position; j++) {
                currentNode = currentNode.getNextNode();
            }
        } else {
            currentNode = tail;
            for (int j = size - 1; j > position; j--) {
                currentNode = currentNode.getPrevNode();
            }
        }
        currentNode.setData(element);
    }


    public E getById(int position) {
        Node<E> currentNode;
        if (position <= (size << 2)) {
            currentNode = head;
            for (int j = 0; j < position; j++) {
                currentNode = currentNode.getNextNode();
            }
        } else {
            currentNode = tail;
            for (int j = size - 1; j > position; j--) {
                currentNode = currentNode.getPrevNode();
            }
        }
        return (E) currentNode.getData().toString();
    }


    public void update(E element1, E element) {
        Node<E> currentNode = head;
        Node<E> prevNode = head;

        while (currentNode.getNextNode() != null) {
            if (currentNode.getData().toString().equals(element1.toString()))
                currentNode.setData(element);

            currentNode = currentNode.getNextNode();

        }
    }


    public Node<E> getTail() {
        return tail;
    }

    public void addTail(E element) {
        Node<E> last = tail;


        Node<E> node = new Node<E>(element);
        tail = node;
        if (tail != null) {
            tail.setPrevNode(last);
            last.setNextNode(tail);
        }
    }

    public boolean contains(Object element) {
        if (head == null) return false;
        Node<E> currentNode = head;
        while (currentNode.getNextNode() != null) {
            if (currentNode.getData().equals(element)) {
                return true;
            }
            currentNode = currentNode.getNextNode();
        }
        return false;

    }


    public void getElement(String id) {

    }

    public void addHead(E element) {
        Node<E> head1 = head;
        Node<E> node = new Node<E>(element);
        head = node;
        if (head1 != null) {
            head1.setPrevNode(head);
            head.setNextNode(head1);

        }


    }

    public Node<E> getHead() {
        return head;
    }

    public void deleteTail() {
        Node<E> lastNode = tail;
        if (lastNode == null)
            throw new NoSuchElementException();
        Node<E> prevNode = lastNode.getPrevNode();

        tail = prevNode;
        if (prevNode == null)
            head = null;
        else
            prevNode.setNextNode(null);
        size--;
    }

    public void deleteHead() {
        Node<E> firtsNode = head;
        if (firtsNode == null)
            throw new NoSuchElementException();

        Node<E> next = firtsNode.getNextNode();
        head = next;
        if (next == null)
            tail = null;
        else
            next.setPrevNode(null);
        size--;
    }


    public int getSize() {
        return size;
    }

    public boolean Checkposition(int position) {
        return position >= 0;
    }
    public static <E> Node<E> mergeSort(Node<E> head, Comparator<E> comparator) {
        if (head == null || head.getNextNode() == null) {
            return head;
        }

        Node<E> middle = getMiddle(head);
        Node<E> nextOfMiddle = middle.getNextNode();
        middle.setNextNode(null);

        Node<E> left = mergeSort(head, comparator);
        Node<E> right = mergeSort(nextOfMiddle, comparator);

        return merge(left, right, comparator);
    }

    private static <E> Node<E> getMiddle(Node<E> head) {
        if (head == null) {
            return null;
        }

        Node<E> slow = head;
        Node<E> fast = head;

        while (fast.getNextNode() != null && fast.getNextNode().getNextNode() != null) {
            slow = slow.getNextNode();
            fast = fast.getNextNode().getNextNode();
        }

        return slow;
    }

    private static <E> Node<E> merge(Node<E> left, Node<E> right, Comparator<E> comparator) {
        Node<E> dummy = new Node<>(null);
        Node<E> tail = dummy;

        while (left != null && right != null) {
            if (comparator.compare(left.getData(), right.getData()) <= 0) {
                tail.setNextNode(left);
                left = left.getNextNode();
            } else {
                tail.setNextNode(right);
                right = right.getNextNode();
            }
            tail = tail.getNextNode();
        }

        if (left != null) {
            tail.setNextNode(left);
        } else {
            tail.setNextNode(right);
        }

        return dummy.getNextNode();
    }
    public void sort(Comparator<E> comparator) {
        head = mergeSort(head, comparator);
    }



    public LinkedList() {
        this.head = null;
        this.size = 0;
        this.lastReturned = null;

    }

    public class MyIterator implements Iterator<E> {
        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            if (next == null) {
                next = head;
            }

            lastReturned = next;
            next = next.getNextNode();
            nextIndex++;
            return lastReturned.getData();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }


}

