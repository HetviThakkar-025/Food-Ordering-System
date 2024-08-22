package sourcecode.adminpanel;

public class MyArrayList<T> {
    private T[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public MyArrayList() {
        array = (T[]) new Object[10];  // initial capacity of 10
        size = 0;
    }

    public int size() {
        return size;
    }
    
    // Add method
    public void add(T element) {
        if (size == array.length) {
            resizeArray();
        }
        array[size] = element;
        size++;
    }

    // Get method
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return array[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Helper method to resize array when it is full
    @SuppressWarnings("unchecked")
    private void resizeArray() {
        T[] newArray = (T[]) new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}
