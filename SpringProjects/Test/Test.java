import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;
public class Test {

	public static void main(String[] args) {
		DateTimeFormatter dateObj = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");
		DateTimeFormatter timeObj = DateTimeFormatter.ofPattern("HH:mm a");
		LocalDateTime now = LocalDateTime.now();
		String date = now.format(dateObj);
		String time = now.format(timeObj);
        System.out.println(date);
		System.out.println(time);
	}

}


