import java.util.Date;

public class Logger {
    private static int count = 1;
    private static Logger logger;

    public void log(String message) {
        System.out.printf("[%1$td.%1$tm.%1$tY %1$tH:%1$tM:%1$tS]  %s%n", new Date(), count++, message);
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }


}
