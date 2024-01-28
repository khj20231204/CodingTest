package algorithm_ex;

public class TwoArrayMerge {

    static int[] twoArrayMerge(int[] a, int[] b){
        int pA = 0;
        int pB = 0;
        int max = a.length+b.length;

        int[] mergeArray = new int[max];
        int pMerge = 0;

        for(int i : a) System.out.print(" a:"+i);
        System.out.println("");
        for(int i : b) System.out.print(" b:"+i);
        System.out.println("");

        while(pA<a.length || pB<b.length){
            if(a[pA] <= b[pB]){
                mergeArray[pMerge++] = a[pA++];
                System.out.println("pA:"+pA);
            }else{
                mergeArray[pMerge++] = b[pB++];
                System.out.println("pB:"+pB);
            }

            if(pA>=a.length){
                while(pB<b.length){
                    mergeArray[pMerge++] = b[pB++];
                }
                break;
            }

            if(pB>=b.length){
                while(pA<a.length){
                    mergeArray[pMerge++] = a[pA++];
                }
                break;
            }
        }
        return mergeArray;
    }
}
