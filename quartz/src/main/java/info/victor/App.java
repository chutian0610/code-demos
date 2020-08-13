package info.victor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static info.victor.QuartzManager.addJob;
import static info.victor.QuartzManager.removeJob;

public class App {
    private static final Logger log = LoggerFactory.getLogger(QuartzManager.class);
    public static void main(String[] args) throws InterruptedException {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", "1");
        addJob(TestJob.class, "aaa", 1, map);

        map.clear();
        map.put("id", "2");
        addJob(TestJob.class, "bbb", 1, map);

        Thread.sleep(3000);
        removeJob("aaa");
        log.info("main end----------");
        Thread.sleep(3000);
        System.exit(1);
    }
}
