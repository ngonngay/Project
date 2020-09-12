package testSwing;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import scala.Array;

public class Test {
    public static void main(String[] args) {
        
       
    }
    public static List<String> validateSQLdatetime(Date sqlDate){
        String date=String.valueOf(sqlDate);
        String[] strings=date.split(" ");
        String time=strings[1].replace(".0", "");
        String datetime=strings[0];
        String[] dateArray=datetime.split("-");
        String dateMonthYear="";
        for (int i = 2; i >-1; i--) {
            if (i!=0) {
                dateMonthYear=dateMonthYear+dateArray[i]+"-";
            }else{
                dateMonthYear=dateMonthYear+dateArray[i];
            }
        }
        List<String> result=new ArrayList<>();
        result.add(time);
        result.add(dateMonthYear);
        return result;
    }
}
