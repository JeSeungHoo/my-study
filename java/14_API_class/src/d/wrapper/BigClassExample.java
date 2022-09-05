package d.wrapper;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigClassExample {

	public static void main(String[] args) {
		BigInteger bi = new BigInteger(
			"10000000000000000000000000000000000000000000"
		); 
		System.out.println(bi.toString());
		System.out.println(bi.intValue());
		
		BigInteger bi2 = new BigInteger("123456789000");
		System.out.println(bi2);
		BigInteger result = new BigInteger("0");
		// 더하기
		result = bi.add(bi2);
		System.out.println(result);
		// 빼기
		result = bi.subtract(bi2);
		System.out.println(result);
		
		// 곱하기
		result = bi.multiply(bi2);
		System.out.println(result);
		// 나누기
		result = bi.divide(bi2);
		System.out.println(result);
		
		double d = 3.141592684185163549821365489756151234568798512336458522222222222222222222221236955555555555555555555555555555555555555555555555555555555555555555555555555555555555515;
		System.out.println(d);
		
		BigDecimal bd = new BigDecimal(
			"1.66666666666666666666666666666666666666666"
		);
		System.out.println(bd);
		
		BigDecimal bd2 = new BigDecimal(
			"2.022222222222222222222222221"
		);
		System.out.println(bd2);
		System.out.println(bd.multiply(bd2));
		
		Number n = bd2;
		System.out.println(n.doubleValue());
		
	}

	
	
}





