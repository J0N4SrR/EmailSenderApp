package rosa.ribeiro.jonas;

import jakarta.mail.MessagingException;
import rosa.ribeiro.jonas.config.Config;
import rosa.ribeiro.jonas.dto.NotasDto;
import rosa.ribeiro.jonas.email.EmailSender;
import rosa.ribeiro.jonas.input.CsvReader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static rosa.ribeiro.jonas.config.Config.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, MessagingException {
        CsvReader cv = new CsvReader(getCsvFilePath());
        EmailSender emailSender = new EmailSender(getSmtpPort(),getSmtpHost(),getEmailPassword(),getEmailUsername());
        List<NotasDto> listNote = cv.CreateNotas();

        //System.out.println(cv.CreateNotas().toString());
        for(NotasDto notasDto : listNote){
            emailSender.sendEmail(notasDto,getEmailUsername());
        }
    }
}