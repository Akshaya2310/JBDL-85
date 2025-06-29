package org.gfg.annotations;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class SMSGatewayService {

    public SMSGatewayService() {
    }

    public void sendSMS(String msg){
        System.out.println("Sending:"+msg);
    }


    //@PostConstruct init method
    public void init(){
        System.out.println("Executing init method");
    }

    //@PreDestroy destroy method
    public void destroy(){
        System.out.println("Executing destroy method");
    }
}


