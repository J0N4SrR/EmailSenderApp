package rosa.ribeiro.jonas.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static final Properties MYCONFIG = new Properties();

    static {
        try(InputStream input = Config.class.getClassLoader().getResourceAsStream("application.properties")){
            MYCONFIG.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getEmailUsername(){
        String emailUsername = MYCONFIG.getProperty("email.username");
        if(emailUsername == null) {
            throw new IllegalArgumentException("Email Não encontrado!");
        }
        return emailUsername;
    }

    public static String getEmailPassword(){
        String emailPassword = MYCONFIG.getProperty("email.password");
        if(emailPassword == null) {
            throw new IllegalArgumentException("Senha Não encontrada!");
        }
        return emailPassword;
    }

    public static String getSmtpHost(){
        String smtpHost = MYCONFIG.getProperty("smtp.host");
        if(smtpHost == null) {
            throw new IllegalArgumentException("Host Não encontrado!");
        }
        return smtpHost;
    }

    public static String getSmtpPort(){
        String smtpPort = MYCONFIG.getProperty("smtp.port");
        if(smtpPort == null) {
            throw new IllegalArgumentException("Port Não encontrado!");
        }
        return smtpPort;
    }

    public static String getCsvFilePath(){
        String filePath = MYCONFIG.getProperty("csv.file.path");
        if(filePath == null) {
            throw new IllegalArgumentException("Path Não encontrado!");
        }
        return filePath;
    }

}
