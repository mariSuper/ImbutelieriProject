package imbutUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {

    public static Logger log = LogManager.getLogger(LoggerUtil.class);

    public static void startTest(String testName) {
        log.info("*** Execution started: " + testName + " ***");
    }

    public static void infoLog(String message) {
        log.info(message);
    }

    public static void errorLog(String message) {
        log.error(message);
    }

    public static void endTest(String testName) {
        log.info("*** Execution finished: " + testName + " ***");
    }
}

