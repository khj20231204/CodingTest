package progrms.codingtest_ex;

import java.util.Scanner;

public class ArrayReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,32,6,7,1,76,33,5,34,9,6,65};
		
		Scanner sc = new Scanner(System.in);
		System.out.println("인덱스 번호 2개 입력하라");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		for(int i=a ; i<b ; i++) {
			for(int j=i+1 ; j<=b ; j++) {
				System.out.println("before arr["+i+"]="+arr[i]+" ,arr["+j+"]:"+arr[j]);
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				System.out.println("after arr["+i+"]="+arr[i]+" ,arr["+j+"]:"+arr[j]);
			}
		}
		
		for(int i=a ; i<=b ; i++)
			System.out.println(arr[i]);
	}

}
