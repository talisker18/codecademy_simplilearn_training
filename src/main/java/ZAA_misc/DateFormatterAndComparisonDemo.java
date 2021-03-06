package ZAA_misc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Calendar;

public class DateFormatterAndComparisonDemo {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		//create Date from String. First create SimpleDateFormat obj
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Date date = format.parse("01/10/2022");
		
		//change format of that date to yyyy-MM-dd
		format = new SimpleDateFormat("yyyy-MM-dd");
		
		String converted = format.format(date);
		System.out.println(converted);
		
		
		
		
		/////////////////////////
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1AsString = "2022-02-05 10:29:30";
		String date2AsString = "2022-02-05 14:29:30";
		
		Date date1 = format.parse(date1AsString);
		Date date2 = format.parse(date2AsString);
		
		//compare
		System.out.println(date1.before(date2)); //true
		System.out.println(date2.after(date1)); //true
		System.out.println(date2.before(date1)); //false
		
		
		//convert date to string
		String str = format.format(date2);
		
		//convert today to String
		format = new SimpleDateFormat("dd.MM.yyyy");
		String dateInput = format.format(Calendar.getInstance().getTime()); //getTime returns now
		
		//convert today into this format : 27. Juni 2022 (german month text)
		format = new SimpleDateFormat("dd. MMMM yyyy", Locale.GERMAN); //using MMMM to get the months text instead of number.
		String todayAsString = format.format(Calendar.getInstance().getTime());
		
		
	}

}
