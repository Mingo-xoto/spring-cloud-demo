import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MyTest {

    public static void main(String[] args) {
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1991,8,14,0,0,0);
        Date time = calendar.getTime();
//        Date time = new Date(527000400000L);
        System.out.println(timeZone.inDaylightTime(calendar.getTime()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        System.out.println(sdf.getTimeZone()+"--->"+sdf.format(time));
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        System.out.println(sdf.getTimeZone()+"--->"+sdf.format(time));
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        System.out.println(sdf.getTimeZone()+"--->"+sdf.format(time));
    }
}
