package rosa.ribeiro.jonas.input;

import rosa.ribeiro.jonas.dto.NotasDto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvReader {
    private String path;
    private String csvSeparator = ",";
    private String emailSeparator = ";";

    public CsvReader(String path) {
        this.path = path;
    }

    public List<NotasDto> CreateNotas() throws IOException {
        List<NotasDto> ndList = new ArrayList<NotasDto>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null){
                if(isFirstLine){
                    isFirstLine = false;
                    continue;
                }

                String[] lineList = line.split(csvSeparator, -1);
                String rawEmails = lineList[4].trim();
                List<String> emailList = Arrays.stream(rawEmails.split(emailSeparator)).toList();
                NotasDto nd = new NotasDto(lineList[0].trim(),lineList[1].trim(),lineList[2].trim(),lineList[3].trim(),emailList);
                ndList.add(nd);
            }
            return ndList;

        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}
