package ch9.tree_ex;

public class ch9_Main {

    public static void main(String[] args){
        TreeEx te = new TreeEx();
        //te.treeEx();
        //te.treeUseMyData();

        HeapEx he = new HeapEx();
        //he.heapEx();;
        //he.heapUseMyData();

        int[][] twoArray = {{3, 6}, {4, 7}, {5, 2}};

        for(int[] two : twoArray){
            System.out.println("two[0]:"+two[0]);
            System.out.println("two[1]:"+two[1]);
        }



        int[] oneArray = {4,2,1,5};
        for(int one : oneArray){
            System.out.println("one:"+one);
        }
    }
}
