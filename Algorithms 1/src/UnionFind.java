public class UnionFind {

    //此处用一个id数组来表示每个节点的连通性。
    //当节点连接到一起的时候那么它们有相同的id号
    private int[] mIds;
    //表示描述的节点的规模,总共有多少个
    private int mCount;

    //构造中实例化用来保存连通状态的数组,并初始化连通状态
    //传入的并查集要表示多少个元素
    public UnionFind(int capacity){
        mCount = capacity;
        mIds = new int[mCount];
        //初始为每个点都不连通,此处i不同就表示不连通,想要连通是就把i设置为同一个即可
        //同时也隐含着mCount各节点元素,每个节点元素的对应索引0...n，连通性,此处默认赋值都不连通
        for (int i = 0; i < mCount; i++) {
            mIds[i] = i+5;//注意id代表的含义不要和索引混了
        }
    }
    //寻找p索引对应的连通性的状态,可以看到查找某个元素的连通状态码
    //是非常的快的，直接在数组中索引即可时间复杂度O(1)
    public int find(int p){
        if( p<0 || p>=mCount){
            //...做一些异常处理
        }
        //直接返回当前索引所对应的元素的连通性,
        //此处设计的是每个连通性默认是索引号.
        return mIds[p];
    }
    //此处设计是用的数组存储元素,传入的是数组内元素的索引,注意这个数组不是指mIds.
    public boolean isConnected(int p,int q){
        //返回p和q在ids数组中对应的连通状态码是否一致。
        return find(p) == find(q);
    }
    //联合的整体思路:
    //   要么把p索引在mIds中的状态变成q的，
    //   要么把q索引在mIds中的状态变成p的
    //mIds中的状态代表了连通性,id号相等就代表连通。
    //此时就遍历mIds数组,然后把p/q索引对应的id进行相关赋值
    public void union(int p,int q){

        //先拿到p和q的id
        int pId = find(p);
        int qId = find(q);

        //如果已经相等那么直接返回

        if( pId == qId ){
            return;
        }
        //注意如下为什么不直接mIds[p] = qId,不要被初始状态迷惑
        //此处的设计思想quick-find查找快，但想要改变连通性的时候
        //需要把所有的节点中的和pId相等的状态码，全部变成qId的状态码
        //只有这样才能算是完全的连通了，你不能只改一个啊！！
        //这种设计模式下的union的时间复杂度是O(n).
        for(int i=0;i<mCount;i++){
            if(mIds[i] == pId){
                mIds[i] = qId;
            }
        }
    }
}

