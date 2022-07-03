import java.util.HashMap;

public class MyArray {
    // Java
    // Program: Building an Array in java with the methods: get, push, pop, unshift, shift, delete, slice

    int length;
    HashMap<Integer, String> data = new HashMap<Integer, String>();

    MyArray() {    // My java constructor: 1st method that gets called when an object is created & it is used to initialize an object
        length = 0;
    }

    // get
    String get(int key) {
        return this.data.get(key);
    }

    // push
    int push(String item){
        this.data.put(this.length, item);
        this.length++;
        return this.length;
    }

    // pop
    int pop() {
        this.data.remove(this.length-1);
        this.length--;
        return this.length;
    }

    // length = 4
    // {'a', 'b', 'c', 'd'}
    //   0    1    2    3
    // {'a', 'a', 'b', 'c', 'd'}
    //   0    1    2    3    4

    // unShift
    void unshift(String item) {
        for (int i=this.length; i >=0; i--){
            if (i == 0){
                this.data.put(i, item);
                break;
            }
            this.data.put(i, this.data.get(i-1));
        }
        this.length++;
    }

    // shift
    void shift() {
        this.delete(0);
        length--;
    }

    // delete
    int delete(int index){
        for (int i=index; i < this.length-1; i++){
            this.data.put(i, this.data.get(i+1));
        }
        this.data.remove(this.length-1);
        this.length--;
        return this.length;
    }

    // Slice
    MyArray slice(int first, int last) {
//        HashMap<Integer, String> slicedLit = new HashMap<Integer, String>();
        MyArray slicedList = new MyArray();

        for (int i=first; i < last; i++){
            slicedList.push(this.data.get(i));
        }
        return slicedList;
    }

    void printList () {
        System.out.println(this.data);
    }

}

class TestArray {

    public static void main (String [] args) {
        MyArray list = new MyArray();
        list.push("Daniel");
        list.push("Stanley");
        list.push("God's will");
        list.push("Precillia");
        // Result = {0=Daniel, 1=God's will, 2=Precillia}
        list.unshift("Gabriel");

        list.slice(1, 3).printList();


        // System.out.println(list.get(0));
        list.printList();
    }
}