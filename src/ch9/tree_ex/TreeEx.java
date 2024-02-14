package ch9.tree_ex;

import java.util.*;

/*
* HashSet은 내부적으로 hashTable을 사용하기 때문에 hashcode와 equals를 오버라이딩 해야 하고
* TreeSet은 내부적으로 BinarySearchTree를 사용하고 BST는 값들의 대소관계를 이용하기 때문에
* comparable을 상속받아서 오버라이딩 해줘야 한다.
*/

public class TreeEx {
    void treeEx(){
        Set<Integer> set = new HashSet<>(); //HashSet은 내부적으로 hashtable를 이용하여 중복 검사
        set.add(1);
        set.add(2);
        set.add(3);

        //hashtable을 참조하여 중복 검사
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println(set);

        Set<Integer> set2 = new TreeSet<>(); //TreeSet은 내부적으로 Binary Search Tree를 이용하여 중복 검사
        set2.add(1);
        set2.add(2);
        set2.add(3);

        //BST로 중복 검사
        set2.add(1);
        set2.add(2);
        set2.add(3);

        System.out.println(set2);
    }

    void treeUseMyData(){

        ////MyData사용

        //TreeSet은 내부적으로 BST를 사용하고 BST의 값을 비교하기 위해서는 대소관를 알아야 하고
        //대소관계를 비교 하기 위해서는 comparable을 상속 받아야 한다.
        Set<MyData> data = new TreeSet<>();
        //data.add(new MyData(3));  //error

        //Hashtable을 사용하기 때문에 정확한 값을 비교하기 위해서는 hashcode를 오버라이딩 한다.
        Set<MyData> data2 = new HashSet<>();
        //MyData는 hashcode를 오버라이딩 안했기 때문에 중복 제거가 안 됨.
        data2.add(new MyData(3));
        data2.add(new MyData(3));

        ////MyDataTreeSet 사용
        //Comparable를 오버라이딩 한 것만으로도 정상 사용
        Set<MyDataTreeSet> data3 = new TreeSet<>();
        data3.add(new MyDataTreeSet(2));
        data3.add(new MyDataTreeSet(5));

        data3.add(new MyDataTreeSet(2));
        data3.add(new MyDataTreeSet(5));

        System.out.println(data3);

        ////MyDataHashSet 사용
        //hashcode와 equals를 오버라이딩
        Set<MyDataHashSet> data4 = new HashSet<>();

        data4.add(new MyDataHashSet(3));
        data4.add(new MyDataHashSet(6));

        data4.add(new MyDataHashSet(3));
        data4.add(new MyDataHashSet(6));

        System.out.println(data4);
    }

    class MyData{  //MyData
        int v;

        public MyData(int v){ this.v = v;}

        @Override
        public String toString() {
            return String.valueOf(v);
        }
    }

    class MyDataTreeSet implements Comparable<MyDataTreeSet>{  //TreeSet
        int v;

        public MyDataTreeSet(int v){ this.v = v;}

        @Override
        public String toString() {
            return String.valueOf(v);
        }

        @Override
        public int compareTo(MyDataTreeSet o) {
            //return v - o.v;
            return Integer.compare(v, o.v);
        }
    }

    class MyDataHashSet{ //HashSet
        int v;

        public MyDataHashSet(int v){ this.v = v;}

        @Override
        public String toString() {
            return String.valueOf(v);
        }

        @Override
        public int hashCode() {
            return Objects.hash(v);
        }

        @Override
        public boolean equals(Object obj) {
            return v == ((MyDataHashSet)obj).v;
        }
    }
}
