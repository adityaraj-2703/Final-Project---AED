/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

/**
 *
 * @author adityaraj
 */
public class TwilioSMSUtil {
    public static String sendTextMessage(String Phonenumber, String msg){

       try{
      String ACCOUNT_SID = "AC0619f2b5840e216c628c3b4ef5a4742a" ;//System.getenv("TWILIO_SID");
      String AUTH_TOKEN = "5389d849e1443214189b0cb30b89e202" ;// System.getenv("TWILIO_KEY");

      Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
       Message message = Message.creator(
               new com.twilio.type.PhoneNumber(Phonenumber),
               new com.twilio.type.PhoneNumber("+18573761902"),
               msg)
           .create();

       System.out.println(message.getSid());

       }
       catch(Exception ex){
           System.out.println(ex);
       }
       return "Message Sent to " + Phonenumber;
   }

}
