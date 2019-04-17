package net.friend.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MySum {
    public String sum(String str1, String str2){
        String sumS;
        try{
            double i1 = Double.parseDouble(str1);
            double i2 = Double.parseDouble(str2);
            double sum = i1 + i2;
            sumS = Double.toString(sum);
            log.info("Sum: " + sumS);
//            Number number1 = NumberFormat.getInstance().parse(str1);
//            Number number2 = NumberFormat.getInstance().parse(str2);
//
//            Number sum = number1 + number2;
//            sumS = Integer.toString(sum);

//        } catch (ParseException e) {
//            sumS = "N/A";
        } catch (NumberFormatException e) {
            sumS = "N/A";
        }

        return sumS;
    }


//    public static void main(String[] args) {
//        System.out.println("Sum: " + sum("eee8","-8"));
//    }
}
