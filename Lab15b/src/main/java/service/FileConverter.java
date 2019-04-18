package service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.LinkedHashMap;
import java.util.LinkedList;

@Service
@Scope("singleton")
public class FileConverter implements StandardlizeService {
    public final String FOLDER_IN = "E:\\Programming\\Projects Java\\ITLab\\Lab15b\\src\\main\\java\\";

    @Override
    public void convertInputToList() {
        LinkedList<String> input = new LinkedList<>();
        try {
            FileReader fileReader = new FileReader(FOLDER_IN + "input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                input.add(line);
                line = bufferedReader.readLine();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }

    }


    public String capitalize(String inString) {
        String outString;
        outString = inString.toUpperCase();
        return outString;
    }

    public String removeUnicode(String inString) {
        String outString;
        outString = Normalizer.normalize(inString, Normalizer.Form.NFKD).replaceAll("\\p{M}", "");
        return outString;
    }

    //    @Override
//    public void outputFile(LinkedList linkedList) {
//
////        System.out.println("Analyzed IP, Running time: " + (new Date().getTime() - startTime) + " (ms)");
//    }


}
