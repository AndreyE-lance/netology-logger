import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger instance;
    protected int num = 1;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    public void log(String msg) {
        System.out.println("[" + num++ + "] " + dateFormat.format(new Date()) + " " + msg);
    }

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }
}
