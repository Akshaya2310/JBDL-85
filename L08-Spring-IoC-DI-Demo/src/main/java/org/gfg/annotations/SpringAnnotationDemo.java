package org.gfg.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationDemo {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.gfg.annotations");
        NotificationService notificationService1 = applicationContext.getBean("notificationService", NotificationService.class);
        notificationService1.sendNotification("OTP:1234");
        SMSGatewayService  smsGatewayService = applicationContext.getBean("SMSGatewayService", SMSGatewayService.class);

        System.out.println(smsGatewayService == notificationService1.getSmsGatewayService());
    }
}
