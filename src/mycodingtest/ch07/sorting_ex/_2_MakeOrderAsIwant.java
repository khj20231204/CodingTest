package mycodingtest.ch07.sorting_ex;

import java.util.Arrays;
import java.util.Scanner;

public class _2_MakeOrderAsIwant {

	public static void main(String[] args) {
		String[] str = {"ageeg","esgeg","rgjhj","wqeg"};
		String[] str2 = new String[str.length];
		
		System.out.println("3보다 작은 정렬할 index를 입력하라:");

		Scanner sc = new Scanner(System.in);
		int index = sc.nextInt();
		
		System.out.print(index);
		
		String[] result = sortintIndex(str, index);
		
		str2 = Arrays.copyOf(str, 2);
		
		Arrays.stream(str2).forEach(System.out::println);
	}

	static String[] sortintIndex(String[] s, int index) {
		
		for(int i=0 ; i<s.length ; i++) {
			char c = s[i].charAt(index);
			s[i] = c + s[i];
		}
		
		 Arrays.sort(s);
		
		for(String ss : s) {
			System.out.println(ss);
		}
		
		return s;
	}
}
