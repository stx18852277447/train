//package top.stx.train.batch.config;
//
//import org.quartz.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import top.stx.train.batch.job.TestJob;
//
//@Configuration
//public class QuartzConfig {
//
//    @Bean
//    public JobDetail jobDetail() {
//        return JobBuilder.newJob(TestJob.class)
//            .withIdentity("TestJob", "test")
//            .storeDurably()
//            .build();
//    }
//
//    @Bean
//    public Trigger trigger() {
//        return TriggerBuilder.newTrigger()
//            .forJob(jobDetail())
//            .withIdentity("trigger", "trigger")
//            .startNow()
//            .withSchedule(CronScheduleBuilder.cronSchedule("*/2 * * * * ?"))
//            .build();
//    }
//}
