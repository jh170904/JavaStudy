package com.level1;

import java.util.Arrays;

/*
	���� ����
	S�翡���� �� �μ��� �ʿ��� ��ǰ�� ������ �ֱ� ���� �μ����� ��ǰ�� �����ϴµ� �ʿ��� �ݾ��� �����߽��ϴ�. 
	�׷���, ��ü ������ ������ �ֱ� ������ ��� �μ��� ��ǰ�� ������ �� ���� �����ϴ�. 
	�׷��� �ִ��� ���� �μ��� ��ǰ�� ������ �� �� �ֵ��� �Ϸ��� �մϴ�.
	
	��ǰ�� ������ �� ���� �� �μ��� ��û�� �ݾ׸�ŭ�� ��� ������ ��� �մϴ�. 
	���� ��� 1,000���� ��û�� �μ����� ��Ȯ�� 1,000���� �����ؾ� �ϸ�, 1,000������ ���� �ݾ��� ������ �� ���� �����ϴ�.
	
	�μ����� ��û�� �ݾ��� ����ִ� �迭 d�� ���� budget�� �Ű������� �־��� ��, 
	�ִ� �� ���� �μ��� ��ǰ�� ������ �� �ִ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.
	
	���ѻ���
	d�� �μ����� ��û�� �ݾ��� ����ִ� �迭�̸�, ����(��ü �μ��� ����)�� 1 �̻� 100 �����Դϴ�.
	d�� �� ���Ҵ� �μ����� ��û�� �ݾ��� ��Ÿ����, �μ��� ��û �ݾ��� 1 �̻� 100,000 ������ �ڿ����Դϴ�.
	budget�� ������ ��Ÿ����, 1 �̻� 10,000,000 ������ �ڿ����Դϴ�
 */

public class Solution01 {
	
  public int solution(int[] d, int budget) {
      int answer = 0;
      int sum = 0;
      int cnt = d.length;
      Arrays.sort(d);
      for(int i : d){
          sum += i;
      }
      
      while(budget-sum<0){
        sum -= d[cnt-1];   
        cnt--;
      }           
      answer = cnt ;
      return answer;
  }
}