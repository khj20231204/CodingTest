public class Main {
    public static void main(String[] args) {

        Josephus_permuation jp = new Josephus_permuation();
        //jp.solution();
        _2_1_Seek_the_MaximumValue_Index smi = new _2_1_Seek_the_MaximumValue_Index();
        int[] matter = {3,5,4,6,3,3,6,5};
        int[] smi_answer = smi.solution1(matter);

        _2_2_order_check oc = new _2_2_order_check();
        boolean oc_answer = oc.solution1(matter);
        System.out.println("oc_answer:" + oc_answer);
    }
}