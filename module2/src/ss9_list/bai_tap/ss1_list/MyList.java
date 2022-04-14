package ss9_list.bai_tap.ss1_list;

import java.util.Arrays;

public class MyList<dataType> {
    /**
     *  size: Kích thước mảng
     *  DEFAULT_CAPACITY: Kích thước mặc định
     *  dataType[] list: Mảng ban đầu
     */
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private dataType[] list;

    /**
     * Khởi tạo mảng ban đầu với chiều dài mặc định
     */
    public MyList() {
        this.list = (dataType[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Khởi tạo mảng với chiều dài truyền vào
     * @param size
     */
    public MyList(int size) {
        if (size >= 0) {
            this.list = (dataType[]) new Object[size];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + size);
        }
    }

    /**
     * Tăng kích thước của mảng
     */
    private void ensureCapa() {
        if (size > list.length) {
            int newSize = this.size * 2;
            list = Arrays.copyOf(list, newSize);
        }
    }

    /**
     * Thêm phần tử mới vào mảng
     * @param element
     */
    public boolean add(dataType element) {
        size++;
        ensureCapa();
        list[size - 1] = element;
        return true;
    }

    /**
     * Thêm phần tử mới vào mảng với vị trí index
     * @param index
     * @param element
     * @return boolean
     */
    public boolean add(int index, dataType element) {
        if (index >= 0 && index <= size) {
            ensureCapa();
            if (list[index] == null) {
                list[index] = element;
                size++;
            } else {
                for (int i = size; i >= index; i--) {
                    list[i + 1] = list[i];
                }
                list[index] = element;
                size++;
            }
            return true;
        }
        return false;
    }

    /**
     * Trả về tổng só phần tử có trong mảng
     * @return int
     */
    public int size() {
        return this.size;
    }

    /**
     * Trả về giá trị của mảng tại vị trí index
     * @param index
     * @return dataType
     */
    public dataType get(int index) {
        if (index >= 0 && index < size) {
            return list[index];
        } else {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    /**
     * Xóa phần tử của mảng tại vị trí index
     * @param index
     * @return boolean
     */
    public boolean remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size; i++) {
                list[i] = list[i + 1];
            }
            size--;
            return true;
        }
        return false;
    }

    /**
     * Xóa mảng
     */
    public void clear() {
        list = (dataType[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Trả về vị trí xuất hiện đầu tiên của phần tử cần tìm
     * @param element
     * @return int
     */
    public int indexOf(dataType element) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Kiểm tra phần tử có tồn tại trong mảng hay không
     * @param element
     * @return boolean
     */
    public boolean contains(dataType element) {
        for (dataType x : list) {
            if (element.equals(x)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Trả về mảng
     * @return dataType[]
     */
    public dataType[] getList() {
        return this.list;
    }

    /**
     * Sao chép mảng ra 1 mảng mới
     * @return Mylist<dataType>
     */
    @Override
    public MyList<dataType> clone() {
        MyList<dataType> arrayClone = new MyList<>();
        arrayClone.list = Arrays.copyOf(this.list, this.size);
        arrayClone.size = this.size;
        return arrayClone;
    }
}
