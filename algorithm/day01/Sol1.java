package day01;

/*
 	입력 형식
	입력으로 지도의 한 변 크기 n 과 2개의 정수 배열 arr1, arr2가 들어온다.

	- 1 ≦ n ≦ 16
	- arr1, arr2는 길이 n인 정수 배열로 주어진다.
	- 정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다. 즉, 0 ≦ x ≦ 2^n - 1을 만족한다.

	출력 형식
	- 원래의 비밀지도를 해독하여 "#", 공백으로 구성된 문자열 배열로 출력하라.
 */

public class Sol1 {

	public static void main(String[] args) {
		int n = 5; 
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};

		String[] result = new String[n];
		
		//방법1
		System.out.println("방법1");
		for(int i=0; i<n; i++){
			 int arr = arr1[i] | arr2[i];	//비트연산
			 System.out.println(Integer.toBinaryString(arr).toString().replaceAll("1", "#").replaceAll("0", " "));
			
		}
		
		//방법2
		System.out.println("방법2");
		for(int i=0;i<n;i++){
			int targetBit = 1;
			String resultString = "";
			int arr = arr1[i] | arr2[i];	//비트연산
			for(int j=0; j<n; j++){
				resultString = ((arr & targetBit) > 0 ? "#" : " ") + resultString;
				targetBit = targetBit << 1; //시프트연산
			}
			result[i] = resultString;
			System.out.println(result[i]);
		}
	}

}
