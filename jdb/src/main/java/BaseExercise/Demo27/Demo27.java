package BaseExercise.Demo27;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hcj on 18-7-29
 */
public class Demo27 {
    public static void main(String[] args){

        String ss="abc.cesgroup.com/123_456.html";

        Pattern compile = Pattern.compile("(.*).cesgroup.com/(\\d*)_(\\d*).html");
        Matcher matcher = compile.matcher(ss);
        if (matcher.matches()){
            System.out.println(matcher.toString());
            int i=1;
            while (i<=matcher.groupCount()){
                System.out.println(matcher.group(i));
                ++i;
                /**
                 * 1.www/htm
                   2.l  一个字符
                 * */
            }
        }else{
            System.out.println("nothing ");
        }

    }
}
