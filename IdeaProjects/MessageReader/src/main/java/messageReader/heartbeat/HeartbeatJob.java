package messageReader.heartbeat;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;


public class HeartbeatJob extends QuartzJobBean {

    private Logger logger = LoggerFactory.getLogger(HeartbeatJob.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("HeartBeat : " + context.getFireTime());
    }
}
