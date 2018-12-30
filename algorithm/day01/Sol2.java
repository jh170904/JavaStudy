package day01;

import java.util.Scanner;

/*
 	다트 게임은 총 3번의 기회로 구성된다.
	각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
	점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수^1 , 점수^2 , 점수^3 )으로 계산된다.
	옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
	스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
	스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
	스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
	Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
	스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
	0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
 */

public class Sol2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("다트 점수 입력 :");
		String val = sc.nextLine();
		
		int len = val.length(); 	//입력된 점수의 길이
		int step = 1;				//1:점수 2:보너스 3:옵션(#|*)
		int lenPos = 0;				//입력된 값의 길이
		
		int[] score = new int[3];	//점수
		int scorePos = 0; 			//점수의 포지션
		
		//1S2D*3T = 37 
		
		//입력된 길이만큼 반복 연산
		while(lenPos<len){
			String target = val.substring(lenPos, lenPos+1);
			
			if(step ==1){
				try {
					//1.1 1단계 점수처리. 숫자만 올 수 있다.
					score[scorePos] = Integer.parseInt(target);
					step++;
				} catch (Exception e) {
					//1.3 3단계 옵션처리.
					if("*".equals(target)){
						//1.3.1 스타상
						score[scorePos-1] = score[scorePos-1]*2;
						if(scorePos>1){
							score[scorePos-2] = score[scorePos-2]*2;
						}
						
					}else if("#".equals(target)){
						//1.3.2 아차상
						score[scorePos-1] = score[scorePos-1]*(-1);
					}else{
						System.out.println("유효한 다트 점수가 아닙니다.");
						return;
					}
				}
				
			}else if(step==2){
				//1.2 2단계 영역처리. Single(S), Double(D), Triple(T) 영역이 존재
				if("S".equals(target)){
					//1.2.1 Single
					score[scorePos] = (int)Math.pow(score[scorePos], 1);
				}else if("D".equals(target)){
					//1.2.2 Double
					score[scorePos] = (int)Math.pow(score[scorePos], 2);
				}else if("T".equals(target)){
					//1.2.3 Triple
					score[scorePos] = (int)Math.pow(score[scorePos], 3);
				}else if("0".equals(target)){
					//1.1.1 10점 처리
					//점수가 0~10 사이의 정수이기 때문에 0 이 나올 수 있다.
					if(score[scorePos]==1){
						score[scorePos]=10;
						//2단계 처리를 다시하기 위해서 값을 조절
						scorePos--;
						step++;
					}
				}else{
					System.out.println("유효한 다트 점수가 아닙니다.");
					return;
				}
				scorePos++;
				step--;
			}
			//다음문자처리
			lenPos++;
		}
		System.out.println(score[0]+score[1]+score[2]);
	}

}
