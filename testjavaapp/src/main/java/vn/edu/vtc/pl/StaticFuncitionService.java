package vn.edu.vtc.pl;

import vn.edu.vtc.persistance.Account;

import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StaticFuncitionService {
    public static int printMenu(ArrayList<String> nameList, Integer limitChoice) {

        for (String string : nameList) {
            System.out.println(string);
        }
        Integer choice = -1;
        do {
            System.out.print("Choice: ");
            try   {
                choice = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                System.out.println("Wrong choice!");
            }
        } while (choice < 0 || choice > limitChoice);
        return choice;
    }
    public static Account loginToSystem(){
        Account account =new Account();
        //username
        do try  {
            System.out.println("User name: ");
            String userName=new Scanner(System.in).nextLine();
            if (userName.equalsIgnoreCase("exit")){
                System.exit(0);
            }
            if(PasswordService.validateUsername(userName)){
                account.setUserName(userName);
                break;
            }else {
                System.out.println("UserName mustn't have special charater and It contains at least 8 characters and at most 20 characters.!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }while (true);
        //password
        do try  {
            System.out.println("Password: ");
            String password=new Scanner(System.in).nextLine();
            if (password.equalsIgnoreCase("exit")){
                System.exit(0);
            }
            if(PasswordService.validatePassword(password)){
                account.setPassword(password);
                break;
            }else {
                System.out.println("It contains at least 8 characters and at most 20 characters.\n" +
                        "It contains at least one digit.\n" +
                        "It contains at least one upper case alphabet.\n" +
                        "It contains at least one lower case alphabet.\n" +
                        "It doesn’t contain any white space.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }while (true);
        return account;
    }
    public static String getMd5(String input)
    {
        try {
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
    public static int inputId(){
        System.out.println("Product ID: ");
        int productId=-1;
        do try{
            productId = new Scanner(System.in).nextInt();
            break;
        } catch (Exception e){
            System.out.println("Wrong!");
        }while (true);
        return productId;
    }
}
