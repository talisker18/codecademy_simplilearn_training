package ZAA_misc;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//java.util.Date class from package java.util
		long millis = System.currentTimeMillis();
		
		Date date = new Date(millis);
		
		System.out.println(date);
		
		
		//for arithmetic operations on dates, we can use GregorianCalendar class
		//also useful for scheduled activity
		
		Calendar calendar = new GregorianCalendar();
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		
		
		//another way, only time
		LocalTime currentTime = LocalTime.now();
		System.out.println("Current Time : " + currentTime);
		LocalTime localTimeZone = LocalTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println("Current Time at America/Los_Angeles : " + localTimeZone);
		
		//same for date+time
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("Current Date Time : " + localDateTime);
		LocalDateTime localDateTimeZone = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println("Current Date Time at America/Los_Angeles : " + localDateTimeZone);
		
		
		//same for only date
		LocalDate localDateToday = LocalDate.now();
		System.out.println("Today's Date : "+localDateToday);
		LocalDate localDateZone = LocalDate.now(ZoneId.of("America/Los_Angeles"));
		System.out.println("Today's Date at Zone America/Los_Angeles : "+localDateZone);

		
		//show difference between 2 dates with period class
		LocalDate localDate1 = LocalDate.of(2016, 06, 16);
		LocalDate localDate2 = LocalDate.of(2017, 10, 15);
		Period period = Period.between(localDate1, localDate2);
		System.out.println("difference between dates: years: "+period.getYears()+", months: "+period.getMonths()+", days: "+period.getDays());
		
		
		//formatting dates
		DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss z");
		DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("dd/MMM/YYYY");
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		String formatter1 = dateTimeFormatter1.format(zonedDateTime);
		String formatter2 = dateTimeFormatter2.format(zonedDateTime);
		String formatter3 = dateTimeFormatter3.format(zonedDateTime);
		System.out.println(formatter1);
		System.out.println(formatter2);
		System.out.println(formatter3);




	}

}
