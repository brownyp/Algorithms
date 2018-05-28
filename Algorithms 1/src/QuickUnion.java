import java.util.Scanner;
/**
 * 快速合并的并查集实现的思路：(还是用数组)
 * 每个元素层都看成是一个节点,该节点有一个引用指向它的父节点。
 * 如果一个元素指向父节点那么它就和父节点连通,当这个元素本身就是根的时候，
 * 那么父节点就指向本身。
 * 由于当前只需一个用来存储父节点的空间，所以依然可以用数组来实现,此处用一个
 * int[] parent数组,里面存放的是元素要连通的父节点的索引.初始状态都连接自己
 * 注意和quick-find区别，它表示连通的时可以 4--->3--->8 表示3 4 8都连通
 * 单用quick-find的时候，就需要 元素索引4、3 、8对应的id都为一样的id号。
 *
 *
 */

public class QuickUnion {

    private int[] mParents;
    private int mCount;

    public QuickUnion(int capacity){
        mCount = capacity;
        mParents = new int[mCount];
        //初始化时每个索引对应的mParents都为自己的索引+5,表示谁也不连接
        for (int i = 0; i < mCount; i++) {
            mParents[i] = i;//初始状态为每个节点自己的索引
        }
    }

    //查找索引p在parent中对应的连通状态码,当它是在一个树的结构中时，
    //需要找到它一直往上直到根节点的对应码,因为我们联合的时候都是按照
    //根节点进行联合的
    public int find(int p){
//        if( p<0 || p>=mCount){
//            //...做一些异常处理
//        }
        //最根部的肯定是等于当前索引的.
        while(p!= mParents[p]){
            //依次往上，把指向的父索引值赋值给当前的p循环查找.
            p = mParents[p];
        }
        return p;
    }
    //是否连通
    public boolean isConnected(int p,int q){
        return find(p)==find(q);
    }
    //联合p所以和q索引对应的状态.此处的设计:
    //     1)、把p所在的树的根节点指向q所在的树的根节点
    //     2)、把q所在的树的根节点指向p所在的树的根节点
    //但从此角度考虑的话两种实现其实是一样的
    public void union(int p,int q){
        //还是先找到pId和qId。
        int pRoot= find(p);
        int qRoot = find(q);
        //如果相等的时候,证明已经联合
        if(pRoot == qRoot){
            return;
        }
        //第一版我们什么也不考虑直接把p所在的树的根节点pRoot指向q所在的树的根。
        //所以注意不是mParents[p] = qRoot,应该是p索引找到的根
        //这个根肯定这会也是指向自己的元素的索引,直接mParents[pRoot]
        //把mParents中pRoot索引对应的值变成qRoot，也就是指向qRoot.
        mParents[pRoot] = qRoot;
    }

    public int[] printnum(){
        return mParents;
    }

}
