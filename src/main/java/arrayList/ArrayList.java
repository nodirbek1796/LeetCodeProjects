package arrayList;

public class ArrayList {
    private int[] items;
    private int count;

    public ArrayList() {
    }

    public ArrayList(int length) {
        items = new int[length];
    }

    // Time complexity O(n)
    public void insert(int item){
        // resize item
        if (items.length == count) {
            int[] newItems = new int[count * 2];
            System.arraycopy(items, 0, newItems, 0, count);
            items = newItems;
        }
        // add items
        items[count++] = item;
    }

    // Time complexity O(n)
    public void print(){
        for (int i = 0; i < count; i++){
            System.out.print(items[i] + " ");
        }
    }

    // Time complexity O(n)
    public int indexOf(int item){
        for (int i = 0; i < count; i++) {
            if (items[i] == item)
                return i;
        }
        return -1;
    }

    // Time complexity O(n)
    public int lastIndexOf(int item){
        for (int i = count - 1; i >= 0; i--) {
            if (items[i] == item)
                return i;
        }
        return  -1;
    }

    // Time complexity O(n)
    public void insertAt(int index, int item){
        // resize items
        if (items.length == count) {
            int[] newItems = new int[count * 2];
            System.arraycopy(items, 0, newItems, 0, count);
            items = newItems;
        }

        // shift items
        if (count - index >= 0)
            System.arraycopy(items, index, items, index + 1, count - index);
        count++;
        items[index] = item;

    }

    // Time complexity O(n)
    public void remove(int index){
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        System.arraycopy(items, index + 1, items, index, count - index);
        count--;
    }

    // Time complexity O(n)
    public int maxItem(){
        int max = items[0];
        for (int i = 0; i < count; i++) {
            if (items[i] > max)
                max = items[i];
        }
        return max;
    }

    // Time complexity O(n)
    public int minItem(){
        int min = items[0];
        for (int i = 0; i < count; i++) {
            if (items[i] < min)
                min = items[i];
        }
        return min;
    }

    // Time complexity O(n)
    public void reverse(){
        int temp;
        int len = count  - 1;
        for (int i = 0; i <= len / 2; i++) {
            temp = items[i];
            items[i] = items[len-i];
            items[len - i] = temp;
        }
    }

    // Time complexity O(n^2)
    public int[] intersection(int[] ints){
        int len = Math.min(ints.length, count);
        int[] cache = new int[len];
        int index = 0;
        for (int i = 0; i < count; i++){
            for (int anInt : ints) {
                if (items[i] == anInt)
                    cache[index++] = items[i];
            }
        }
        int[] result = new int[index];
        System.arraycopy(cache, 0, result, 0, index);
        return result;
    }

    // Time complexity O(1)
    public int size(){
        return count;
    }
}
