package rosa.ribeiro.jonas.email;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import rosa.ribeiro.jonas.dto.NotasDto;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Properties;

import static rosa.ribeiro.jonas.dto.EmailMessageTemplate.messageNotasTemplate;

public class EmailSender {
    private String emailUsername;
    private String emailPassword;
    private String smtpHost;
    private String smtpPort;


    public EmailSender(String smtpPort, String smtpHost, String emailPassword, String emailUsername) {
        this.smtpPort = smtpPort;
        this.smtpHost = smtpHost;
        this.emailPassword = emailPassword;
        this.emailUsername = emailUsername;
    }

    public void sendEmail(NotasDto note, String emailSender) throws MessagingException, UnsupportedEncodingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailUsername,emailPassword);
            }
        });
        session.setDebug(true);

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(emailUsername, emailSender));

        //Defines recipients (reading from DTO email list)
        List<String> recipientEmailList = note.getEmailList();
        if(recipientEmailList == null) {
            throw new MessagingException("Recipient list is empty!");
        }

        //Convert the list of strings to an array of InternetAddress
        InternetAddress[] IArecipientEmailList = new InternetAddress[recipientEmailList.size()];
        for(int i = 0; i < recipientEmailList.size(); i++){
            IArecipientEmailList[i] = new InternetAddress(recipientEmailList.get(i).trim());
        }
        msg.setRecipients(Message.RecipientType.TO,IArecipientEmailList);

        // Email subject
        String subject = "Solicitação de Envio: Comprovantes de Retenção - NF Nº " + note.getnNota();
        msg.setSubject(subject);

        //Email body
        msg.setText(messageNotasTemplate(note));

        // Send msg
        Transport.send(msg);

    }

}
