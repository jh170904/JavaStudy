package com.level1;
/*
 	����� ����
 	���� ����
	����� ������ ��� ���� ũ�Ⱑ ���� �� ����� ���� ��, ���� ���� ���� ���� ���� ����� �˴ϴ�. 2���� ��� arr1�� arr2�� �Է¹޾�, ��� ������ ����� ��ȯ�ϴ� �Լ�, solution�� �ϼ����ּ���.
	
	���� ����
	��� arr1, arr2�� ��� ���� ���̴� 500�� ���� �ʽ��ϴ�.
 */
public class Solution04 {

  public int[][] solution(int[][] arr1, int[][] arr2) {
      int[][] answer = new int[arr1.length][arr1[0].length];
      
      for(int i=0; i<arr1.length ;i++){
        for(int j=0; j<arr1[0].length ;j++){
            answer[i][j] = arr1[i][j] + arr2[i][j];
        }    
      }
      
      return answer;
  }
}