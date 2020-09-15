package vn.edu.vtc.bl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordService {
    public static boolean validateUsername(String userName){
        Pattern pattern=Pattern.compile("[\\p{Punct}]");
        Matcher matcher=pattern.matcher(userName);
        
        boolean check737=matcher.find();
        if ((!check737)&&userName.length()<20&&(userName.length()>8||userName.length()==8)){
            return true;
        }
        return false;
    }
    public static boolean validatePassword(String password){
        Pattern pattern=Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,20}$");
        Matcher matcher=pattern.matcher(password);
        if (matcher.matches()){
            return true;
        }
        return  false;
    }
}