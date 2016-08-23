package in.cozynest.cozyapis.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {

	public static void main(String gg[]) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = formatter.parse("02-03-2016");
			endDate = formatter.parse("03-02-2016");
		} catch (Exception e) {
			System.out.println(e);
		}
		List<Date> dates = getDaysBetweenDates(startDate, endDate);
	    
		for (int i = 0; i < dates.size(); i++) {
			System.out.println(dates.get(i).toString());
		}
	}

	public static List<Date> getDaysBetweenDates(Date startdate, Date enddate) {
		List<Date> dates = new ArrayList<Date>();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(startdate);

		while (calendar.getTime().before(enddate)) {
			Date result = calendar.getTime();
			dates.add(result);
			calendar.add(Calendar.DATE, 1);
		}
		return dates;
	}
}