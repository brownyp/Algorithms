
public class Main {

    public static void main(String[] args) {

//        QuickFind u = new QuickFind(10);
//        u.union(5,8);

//          QuickUnion u = new QuickUnion(10);
        QuickUnionTest u = new QuickUnionTest(10);
          u.union(5,8);
        for(int i=0;i<u.printnum().length;i++){
            System.out.println(u.printnum()[i]);
        }

    }


}
