public class Main {
    public static void main(String[] args) {

        Josephus_permuation jp = new Josephus_permuation();
        //jp.solution();
        Seek_the_MaximumValue_Index smi = new Seek_the_MaximumValue_Index();
        int[] matter = {3,5,4,6,3,3,6,5};
        int[] answer = smi.solution1(matter);

    }
}