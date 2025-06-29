package org.gfg.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service // indirect component
//@Component // direct
public class NotificationService {

    @Autowired
    private SMSGatewayService smsGatewayService;

//    public NotificationService(SMSGatewayService smsGatewayService) {
    //
//        this.smsGatewayService = smsGatewayService;
//    }


//    @Autowired
//    public void setSmsGatewayService(SMSGatewayService smsGatewayService) {
//        this.smsGatewayService = smsGatewayService;
//    }

    public void sendNotification(String msg){
        smsGatewayService.sendSMS(msg);
    }

    public SMSGatewayService getSmsGatewayService() {
        return smsGatewayService;
    }
}
