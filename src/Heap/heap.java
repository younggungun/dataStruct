package Heap;

import java.sql.PreparedStatement;

public class heap<T extends Comparable<T>> {
    //成员变量
    // ------创建存储元素的数组
     T[]items;


    public int getN() {
        return N;
    }

    // ------记录元素个数
    private int N;          //N是否必须为2的幂值
    //最大容量
    private int maxSize;
    //构造方法
    public heap(int capacity) {         //由于底层由数组实现，因此整数来初始化
        maxSize=capacity;

        N=0;
        items= (T[]) new Comparable[capacity+1];
    }
    //判断是否为满isfull
    private boolean isFull(){
        if (N+1>=maxSize){
            return true;
        }else {
            return false;
        }
    }


    //成员方法
    //1------less 比较索引i出的元素是否小于j处的；
    private boolean less(int i,int j){
        boolean b = items[i].compareTo(items[j]) < 0;
        return b;
    }
    //2------交换两索引处的元素
    private void exchange(int i,int j){
        T temp=items[i];
        items[i]=items[j];
        items[j]=temp;
    }

    //3------删除堆中最大元素，并返回该元素        //讨巧 把数组最后一个元素换到items[1];
    public T delMax(){
        T temp=items[1];
        exchange(1,N);
        items[N]=null;
        N--;
        sink(1);
        return  temp;
    }

    //4------堆中插入某元素
    public boolean insert(T a){
        if (isFull()){
            return false;
        }
        items[++N]=a;
        swim(N);
        return true;
    }

    //5------上浮算法：使得索引K处的元素再堆中处于一个正确的顺序位置
    private void swim(int k){
        while (k>1){
            if (less(k<<1,k));
            exchange(k<<1,k);
            k=k<<1;
        }
    }

    //6------下沉算法：使得索引K处的元素再堆中处于一个正确的顺序位置
    private void sink(int k){
        /*while (less(k,k<<1)||less(k+1,(k<<1))){
            if (less(k,k<<1)&&less(k+1,(k<<1))){
                exchange(k,k<<1);
                k=k<<1;
            }
        }*/

        while ((k<<1)<=N){
            //2k<=N一定保证有左，但是不一定有右边
            //首先保证有右子节点  这个max设置的很到位
            int max;
            if ((k<<1)+1<=N){
                if (less((k<<1),(k<<1)+1)){
                    max=((k<<1)+1);
                }else {
                    max=(k<<1);
                }
                //if ((k<<1)+1<=N&&less((k<<1),(k<<1)+1)){ 如果又右子节点，且左比右小，则右边大，默认想等的话以左边为主；
                //                    max=((k<<1)+1);
                //                }else {
                //                    max=(k<<1);
                //                }

            }else{
                max=(k<<1);
            }
            if (!less(k,max)){
                break;
            }
            exchange(k,max);
            k=max;
           // sink(k);while就不用递归类
        }




    }


}
