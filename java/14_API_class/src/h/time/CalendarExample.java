package h.time;

import java.util.Calendar;

public class CalendarExample {

	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		// 년도
		int year = now.get(Calendar.YEAR);
		// 월 1~12;
		// 월 0~11; 0 : 1월  11 : 12월
		int month = now.get(Calendar.MONTH)+1;
		// 월 중 날짜
		int day = now.get(Calendar.DAY_OF_MONTH);
		// 주중 날짜
		int week = now.get(Calendar.DAY_OF_WEEK);
		System.out.println(Calendar.SUNDAY);	// 1
		System.out.println(Calendar.SATURDAY);  // 7
		String strWeek = "";
		switch(week) {
			case Calendar.MONDAY : 
				strWeek = "월";
				break;
			case Calendar.TUESDAY : 
				strWeek = "화";
				break;
			case Calendar.WEDNESDAY : 
				strWeek = "수";break;
			case Calendar.THURSDAY : 
				strWeek = "목";break;
			case Calendar.FRIDAY : 
				strWeek = "금";break;
			case Calendar.SATURDAY : 
				strWeek = "토";break;
			case Calendar.SUNDAY : 
				strWeek = "일";break;
		}
		
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		System.out.println(year+"년"+month+"월"+day+"일"+hour+"시"+minute+"분"+second+"초 ("+strWeek+")요일");
		
	}

}











