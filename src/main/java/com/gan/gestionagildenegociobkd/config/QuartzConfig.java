package com.gan.gestionagildenegociobkd.config;

import com.gan.gestionagildenegociobkd.Services.jobs.JobMailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

@Configuration
public class QuartzConfig {

    @Value("${quartz.jobCron}")
    private String jobCron;

    @Value("${quartz.jobGroup}")
    private String jobGroup;


    @Bean
    CronTriggerFactoryBean mailTrigger(){

        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(mailJob().getObject());
        cronTriggerFactoryBean.setCronExpression(jobCron);
        cronTriggerFactoryBean.setGroup(jobGroup);
        return cronTriggerFactoryBean;
    }

    @Bean
    JobDetailFactoryBean mailJob() { // Tarea
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(JobMailService.class);
        jobDetailFactoryBean.setGroup(jobGroup);
        jobDetailFactoryBean.setDurability(true);
        return jobDetailFactoryBean;
    }

}
