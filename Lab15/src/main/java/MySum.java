import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MySum {
    @Autowired
    String string1;
    @Autowired
    String string2;



    public static String sum(String str1, String str2){
        String sumS;
        try{
            int i1 = Integer.parseInt(str1);
            int i2 = Integer.parseInt(str2);
            int sum = i1 + i2;
            sumS = Integer.toString(sum);

        } catch (NumberFormatException e){
            sumS = "N/A";
        }

        return sumS;
    }


    public static void main(String[] args) {
        System.out.println("Sum: " + sum("rerrrrr","-8"));
    }

}
