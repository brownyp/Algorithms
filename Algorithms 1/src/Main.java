
public class Main {

    public static void main(String[] args) {

        UnionFind u = new UnionFind(10);
        u.union(8,9);
        System.out.println(u.isConnected(8,9));

    }


}
