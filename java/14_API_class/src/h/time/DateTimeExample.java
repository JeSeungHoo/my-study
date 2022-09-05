package h.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeExample {

	public static void main(String[] args) {
		LocalDate toDay = LocalDate.now();
		LocalTime present = LocalTime.now();
		System.out.println(toDay);
		System.out.println(present);
		
		LocalDate birthDay = LocalDate.of(1982, 06, 07);
		LocalTime birthTime = LocalTime.of(02, 02, 01);
		System.out.println(birthDay);
		System.out.println(birthTime);
		
		System.out.println(toDay.getYear());
		System.out.println(toDay.getMonthValue());
		System.out.println(toDay.getDayOfMonth());
		System.out.println(toDay.getDayOfWeek());
		System.out.println(toDay.getDayOfYear());
		System.out.println(present.getHour()+":"+present.getMinute()+":"+present.getSecond());
		// 1년전
		LocalDate target = toDay.minusYears(1);
		System.out.println(target);
		// 10년뒤
		target = toDay.plusYears(10);
		System.out.println(target);
		target = toDay.minusMonths(5);
		System.out.println(target);
		target = toDay.minusDays(20);
		System.out.println(target);
		LocalTime targetTime = present.minusHours(10);
		System.out.println(targetTime);
		targetTime = present.minusMinutes(10);
		System.out.println(targetTime);
		targetTime = present.minusSeconds(10);
		System.out.println(targetTime);
		
		LocalDateTime targetDateTime = LocalDateTime.now();
		System.out.println(targetDateTime);
		
		targetDateTime = targetDateTime
						 .withYear(2024)
						 .withMonth(10)
						 .withDayOfMonth(5)
						 .withHour(13)
						 .withMinute(30)
						 .withSecond(20);
		System.out.println(targetDateTime);
		
	}

}






