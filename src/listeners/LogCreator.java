package listeners;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogCreator implements EventListener {

    private final String path;
    Logger logger = Logger.getLogger("log");
    FileHandler fileHandler;

    public LogCreator (String path) {
       this.path = path;
        try {
            fileHandler = new FileHandler(this.path);
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            System.out.println("error during creating log file");
            e.printStackTrace();
        }
    }

    @Override
    public void update(String eventType, String username) {
        logger.info(username + "\t" + eventType);
    }
}
