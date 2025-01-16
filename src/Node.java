public class Node<E> {
    private E data;
    private Node<E> nextNode;
    private Node<E> prevNode;

    public Node(E data) {
        this.data = data;

    }

    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<E> node) {
        this.nextNode = node;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node<E> prevNode) {
        this.prevNode = prevNode;
    }
}
