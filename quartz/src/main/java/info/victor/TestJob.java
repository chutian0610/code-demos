package info.victor;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJob implements Job {
    private static final Logger log = LoggerFactory.getLogger(TestJob.class);

    @Override
    public void execute(JobExecutionContext jobexecutioncontext) throws JobExecutionException {
        String id = jobexecutioncontext.getJobDetail().getJobDataMap().getString("id");
        log.info("threadId: " + Thread.currentThread().getId() + ", id: " + id);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("job error:",e);
        }
    }
}
