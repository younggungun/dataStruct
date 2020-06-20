package Heap;

public class text {
    public static void main(String[] args) {
        heap<String> h = new heap<>(10);
        h.insert("A");
        h.insert("B");
        h.insert("C");
        h.insert("D");
        h.insert("E");
        h.insert("F");
        h.insert("G");
        String a=null;
        while ((a=h.delMax())!=null){
            System.out.printf(a+"\t");
        }
    }
}
