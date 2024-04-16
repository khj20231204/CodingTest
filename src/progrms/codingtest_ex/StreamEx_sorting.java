package progrms.codingtest_ex;
import java.util.*;
import java.util.stream.*;
public class StreamEx_sorting {

   public class Student{
      String name;
      int ban;
      int totalScore;

      public Student(String n, int b, int t){
         name = n;
         ban = b;
         totalScore = t;
      }

      public String toString(){
         return "name:"+name+" ,ban:"+ban+" ,totalScore:"+totalScore;
      }
   }

   public void solution(){
      Stream<Student> studentStream = Stream.of(
            new Student("abc",34,1),
            new Student("etb",4,5),
            new Student("peb",16,3),
            new Student("egh",87,2)
      );

      //studentStream.forEach(System.out::println);

      //studentStream.sorted().forEach(System.out::println); //기본 정렬
      studentStream.sorted((s1,s2) -> s1.ban - s2.ban).forEach(System.out::println);

      studentStream = Stream.of(
            new Student("abc",34,1),
            new Student("etb",4,5),
            new Student("peb",16,3),
            new Student("egh",87,2)
      );

      studentStream.sorted((s1,s2) -> s1.name.compareTo(s2.name)).forEach(System.out::println);
   }
}
