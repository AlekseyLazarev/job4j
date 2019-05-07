package ru.alazarev.parser;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import ru.alazarev.array.Config;

import java.io.InputStream;
import java.util.Properties;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Class ParserApp решение задачи Парсер вакансий на sql.ru [#1731].
 *
 * @author Aleksey Lazarev
 * @since 30.04.2019
 */
public class ParserApp implements Job {
    static Properties properties = new Properties();
    private static final Logger LOGGER = LogManager.getLogger(ParserApp.class.getName());

    /**
     * Default start method.
     *
     * @param args arguments.
     */
    public static void main(String[] args) throws Exception {
        int version = 1;
        LOGGER.trace("trace message {}", version);
        LOGGER.debug("trace message {}", version);
        LOGGER.info("trace message {}", version);
        LOGGER.warn("trace message {}", version);
        LOGGER.error("trace message {}", version);
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream(args[0])) {
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        JobDetail job = newJob(ParserApp.class)
                .withIdentity("parseer")
                .build();
        Trigger trigger = newTrigger()
                .withIdentity("trigger1")
                .withSchedule(cronSchedule(properties.getProperty("cron.expression")))
                .build();
        scheduler.scheduleJob(job, trigger);
    }

    /**
     * Method run parse.
     *
     * @param jobExecutionContext Job context.
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SqlDataBase sqlDataBase = new SqlDataBase(properties);
        sqlDataBase.init();
        SqlParser sqlParser = new SqlParser(sqlDataBase);
        sqlParser.parse();
    }
}
