import java.util.*;


public class LinkedList<E> implements Iterable<E> {
    private int size = 0;
    Node<E> lastReturned;

    Node<E> head = null;
    Node<E> tail = null;

    public void remove(E element) {
        Node<E> currentNode = head;
        if (head == null)
            return;
        while (currentNode!= null) {
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
                    prevNode.setNextNode(null);
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
        this();  // Вызов конструктора без параметров, чтобы инициализировать пустой список

        if (c != null) {
            for (E element : c) {
                add(element); // Добавляем каждый элемент в конец списка
            }
        }
    }



    public boolean add(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
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
                System.out.println(currentNode.getData().toString());
                currentNode = currentNode.getNextNode();
            }
            System.out.println(currentNode.getData().toString());

        }
    }


    public void set(int position, E element) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }

        Node<E> currentNode;
        // Оптимизируем выбор направления обхода
        if (position < (size >> 1)) { // Если позиция ближе к началу
            currentNode = head;
            for (int j = 0; j < position; j++) {
                currentNode = currentNode.getNextNode();
            }
        } else { // Если позиция ближе к концу
            currentNode = tail;
            for (int j = size - 1; j > position; j--) {
                currentNode = currentNode.getPrevNode();
            }
        }

        currentNode.setData(element);
    }
    private boolean isElementIndex(int position) {
        return position >= 0 && position < size;
    }




    public E get(int position) {
        if (!isElementIndex(position)) { // Проверяем, что индекс валиден
            throw new IndexOutOfBoundsException(position + " is out of bounds of the linked list");
        }

        Node<E> currentNode;
        if (position < (size >> 1)) {
            currentNode = head;
            for (int i = 0; i < position; i++) {
                currentNode = currentNode.getNextNode();
            }
        } else {
            currentNode = tail;
            for (int i = size - 1; i > position; i--) {
                currentNode = currentNode.getPrevNode();
            }
        }

        return currentNode.getData();
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
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (element == null) {
                if (currentNode.getData() == null) {
                    return true;
                }
            } else {
                if (element.equals(currentNode.getData())) {
                    return true;
                }
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


    public LinkedList() {
        this.head = null;
        this.size = 0;
        this.lastReturned = null;
    }

    public class MyIterator implements Iterator<E> {
        private Node<E> nextNode;
        private int nextIndex = 0;

        public MyIterator() {
            this.nextNode = head; // Начинаем с головы списка
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            lastReturned = nextNode;
            nextNode = nextNode.getNextNode();
            nextIndex++;

            return lastReturned.getData(); // Возвращаем данные текущего узла
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }


}

