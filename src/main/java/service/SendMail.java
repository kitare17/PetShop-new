package service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;


public class SendMail {
    public static boolean forgotPass(String emailTo, String otp) {
        String to = emailTo; // to address. It can be any like gmail, hotmail etc.
        final String from = "petshopfptv1@gmail.com"; // from address. As this is using Gmail SMTP.
        final String password = "vgigzsjhmqfropoq"; // password for from mail address.

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Dat lai mat khau ");

            String msg = "Mã xác thực của bạn là " + otp;

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setText(msg,"UTF-8");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

//            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
//            attachmentBodyPart.attachFile(new File("E://Tools//Screenshot.JPG"));
//            multipart.addBodyPart(attachmentBodyPart);
            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Mail successfully sent..");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        forgotPass("hoctapak@gmail.com", "123456");
    }
}