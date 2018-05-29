import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.Years;

public class DateTimeUtils {
	public static final SimpleDateFormat sdf_yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat sdf_ddMMyyyy = new SimpleDateFormat("ddMMyyyy");
	public static final SimpleDateFormat sdf_MM_yyyy = new SimpleDateFormat("MM yyyy");
	
	
	public static int yearsInBetween(Date fromDate, Date toDate){
		return Years.yearsBetween(new DateTime(fromDate), new DateTime(toDate)).getYears();
	}
	
	public static int monthsInBetween(Date fromDate, Date toDate){
		return Months.monthsBetween(new DateTime(fromDate), new DateTime(toDate)).getMonths();
	}
	
	public static void main(String[] args) throws ParseException {
		
		Date toDate = sdf_yyyy_MM_dd.parse("1959-04-03");
		System.out.println(yearsInBetween(new Date(), toDate));
	}
	
}

