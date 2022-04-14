package ss9_list.bai_tap.ss2_linked_list;

public class MyLinkedList<dataType> {

    private class Node {
        private Node next;
        private Object data;

        public Node(Object element) {
            this.data = element;
        }

        private Object getData() {
            return this.data;
        }
    }

    /**
     * Phần tử đầu tiên của linkedlist
     */
    private Node head;
    /**
     * Số lượng phần tử trong danh sách
     */
    private int numNodes = 0;

    public MyLinkedList() {
    }

    /**
     * Thêm phần tử vào Node ở vị trí đầu tiên
     *
     * @param element
     */
    public void addFirst(dataType element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    /**
     * Thêm phần tử vào vị trí cuối
     *
     * @param element
     */
    public void addLast(dataType element) {
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;
    }

    /**
     * Thêm 1 node vào qua vị trí index
     */
    public void add(int index, dataType element) {
        Node temp = head;

        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    /**
     * Lấy vị giá trị ở vị trí index
     */
    public Object get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    /**
     * Trả về số lượng node
     */
    public int size() {
        return numNodes;
    }

    /**
     * Xóa node ở vị trí index
     *
     * @param index
     * @return
     */
    public dataType remove(int index) {
        if (index < 0 || index > numNodes) {
            throw new IllegalArgumentException("Index: " + index);
        }
        Node temp = head;

        Object data;

        if (index == 0) {
            data = temp.data;
            head = head.next;
            numNodes--;
        } else {
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
            numNodes--;
        }
        return (dataType) data;
    }

    /**
     * @param element
     * @return
     */
    public boolean remove(dataType element) {
        if (head.data.equals(element)) {
            remove(0);
            return true;
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.next.data.equals(element)) {
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    /**
     * Sao chép 1 linkedlist
     *
     * @return
     */
    @Override
    public MyLinkedList<dataType> clone() {
        if (numNodes == 0) {
            throw new NullPointerException("Linkedlist is null");
        }
        MyLinkedList<dataType> myCloneLinkedList = new MyLinkedList<>();
        Node temp = head;
        myCloneLinkedList.addFirst((dataType) temp.data);
        temp = temp.next;
        while (temp != null) {
            myCloneLinkedList.addLast((dataType) temp.data);
            temp = temp.next;
        }
        return myCloneLinkedList;
    }

    /**
     * Tìm phần tử có tồn tại trong linkedlist
     *
     * @param element
     * @return
     */
    public boolean contains(dataType element) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.data.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * Trả về phần vị trí xuất hiện đầu tiên của phần tử
     *
     * @param element
     * @return
     */
    public int indexOf(dataType element) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Trả về phần tử ở vị trí đầu tiên
     * @return
     */
    public dataType getFirst() {
        Node temp = head;
        return (dataType) temp.data;
    }

    /**
     * Trả về phần tử ở vị trí cuối cùng
     * @return
     */
    public dataType getLast() {
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        return (dataType) temp.data;
    }

    /**
     * Xóa toàn bộ node
     */
    public void clear() {
        Node temp = head;
        while (temp.next != null) {
            temp.data = null;
            temp = temp.next;
        }
        numNodes = 0;
    }
}

























