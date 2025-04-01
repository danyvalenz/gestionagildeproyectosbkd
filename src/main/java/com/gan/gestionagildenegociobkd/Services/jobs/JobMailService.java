package com.gan.gestionagildenegociobkd.Services.jobs;

import com.gan.gestionagildenegociobkd.Services.messages.MailService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class JobMailService implements Job {

    private final MailService mailService;

    public JobMailService(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {



        // HTML body
        // Template Id=81

        String body = "<h1>Alerta</h1>" + "<p>Usted tiene las siguientes alertas:!</p>" + "Visítenos en: "+ LocalDate.now()
                + "<a href='https://www.galaxy.edu.pe'>Galaxy Training</a>" + "<br/><br/>" + "Estemos en contacto por este medio";

        mailService.sendMail("jesusvalenzuelag25@gmail.com", "Demo de envio de correos", body);
    }
}
