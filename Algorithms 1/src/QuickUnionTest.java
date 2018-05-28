public class QuickUnionTest {
    int[] id;

    public QuickUnionTest(int n) {
        this.id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        int rootP = getRoot(p);
        int rootQ = getRoot(q);
        id[rootQ] = rootP;
    }

    public boolean find(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    private int getRoot(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }
    public int[] printnum(){
        return id;
    }
}
