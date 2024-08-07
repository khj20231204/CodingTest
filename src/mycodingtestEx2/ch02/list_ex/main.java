package mycodingtestEx2.ch02.list_ex;

import java.util.Arrays;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//최대값
		int[] arr = {34,46,56,2,6,7};
		int max = Arrays.stream(arr).max().getAsInt();

		//1~n까지 중복 없이
		int[] arr2 = {3,8,4,5,6,2};
		int[] arr3 = {2,5,8,4,7,1,3,6};
		
		System.out.println(main.checkDuplication(arr2));
		System.out.println(main.checkDuplication(arr3));
		
		//역으로 출력
		int[] reverseArr = reverInt(arr2);
		Arrays.stream(reverseArr).forEach(i -> System.out.println(i));
		reverseArr = reverInt(arr3);
		Arrays.stream(reverseArr).forEach(i -> System.out.println(i));
		
	}
	
	public static int[] reverInt(int[] arr) {
		
		int[] reverseArr = new int[arr.length];
		
		for(int i=0 ; i<arr.length ; i++) {
			reverseArr[(arr.length-1)-i] = arr[i];
		}
		
		return reverseArr;
	}
	
	public static boolean checkDuplication(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt();

		int len1 = Arrays.stream(arr).distinct().toArray().length;
		if(len1 != arr.length) return false;
		
		boolean check = false;
		for(int i=1 ; i<=max ; i++) {
			for(int j=0 ; j<arr.length ; j++) {
				if(arr[j] == i) {
					check = true;
				}
			}
			
			if(!check) return false;
		}
		
		return true;
	}

}
