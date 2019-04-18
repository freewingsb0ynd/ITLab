import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.StandardlizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.LinkedList;

@Slf4j
public class Application{
//    @Autowired
//    StandardlizeService inputConverter;

    public final String FOLDER_OUT = "E:\\Programming\\Projects Java\\ITLab\\Lab15b\\src\\main\\java\\";

    public static void main(String[] args){
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/integration/config.xml");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void run(String... args) throws Exception {
////      String res = ;
//        log.info("aaaaaaaaaaaaaaaa");
//
//
//        LinkedList<String> output = new LinkedList<>();
//        for (String line: inputConverter.convertInputToList()) {
//            String str = Normalizer.normalize(line, Normalizer.Form.NFKD);
//            output.add(str.replaceAll("\\p{M}", "").toUpperCase());
//        }
//
//        StringBuilder stringBuilder = new StringBuilder();
//        output.forEach(item -> stringBuilder.append(String.format("%s\n", item)));
//        writeFile(FOLDER_OUT + "output.txt", stringBuilder);
//    }
//
//    public static void writeFile(String fileName, CharSequence csq) {
//        try {
//            FileWriter browsersFile = new FileWriter(fileName);
//            browsersFile.append(csq);
//            browsersFile.flush();
//            browsersFile.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
