package com.sort;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


//유닛테스트 활용
public class Test1 {
	
	//1. int형 배열 정렬
	@Test
	public void sortInts(){
		final int[] numbers = {-3,-5,1,7,4,-2};
		final int[] expected1 = {-5,-3,-2,1,4,7};
		
		Arrays.sort(numbers);
		assertArrayEquals(expected1,numbers);
	}

	//2. String형 배열 정렬
	@Test
	public void sortObjects(){
		final String[] strings = {"z", "x", "y", "abc", "zzz", "zazzy"};
		final String[] expected2 = {"abc", "x", "y", "z", "zazzy", "zzz"};
		
		Arrays.sort(strings);
		assertArrayEquals(expected2,strings);
	}	
    
    //3. Comparable 인터페이스 사용하지 않고 정렬하기
    @Test
    public void sortNotComparable() {
        final List<NotComparable> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            objects.add(new NotComparable(i));
        }

        try {
            Arrays.sort(objects.toArray());
        } catch (Exception e) {
            // correct behavior �� cannot sort
            return;
        }

        fail();
    }
	
	//3-1. 이너클래스 생성
    private static class NotComparable {
        private int i;
        private NotComparable(final int i) {//생성자로 변수 초기화
            this.i = i;
        }
    }
	
	//4. 사용자가 지정한 순서로 정렬하기
	@Test
	public void customSort(){
		final List<Integer> numbers = Arrays.asList(4,7,1,6,3,5,4);
		final List<Integer> expected3 = Arrays.asList(7,6,5,4,4,3,1);
		
		Collections.sort(numbers,new ReverseNumericalOrder());
		assertEquals(expected3,numbers);
	}	
	
}

class ReverseNumericalOrder implements Comparator<Integer>{
	@Override
	public int compare(Integer arg0, Integer arg1) {
		return arg1 - arg0;
	}
}


