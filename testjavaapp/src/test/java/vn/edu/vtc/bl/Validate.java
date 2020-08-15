package vn.edu.vtc.bl;

import org.junit.Assert;
import org.junit.Test;

import vn.edu.vtc.service.PasswordService;
import vn.edu.vtc.service.StaticFuncitionService;



public class Validate {
    @Test
    public void validateUsername(){
        //correct username form
        Assert.assertTrue(PasswordService.validateUsername("Nguyenquyetthang"));
    }
    @Test
    public void validateUsername2(){
         
        //have special character
        Assert.assertFalse(PasswordService.validateUsername("Nguyenquyetthang123%"));
    }
    @Test
    public void validateUsername3(){
         
        //less than 8 character
        Assert.assertFalse(PasswordService.validateUsername("Nguy"));
    }
    @Test
    public void validateUsername4(){
         
        //more than 20 character
        Assert.assertFalse(PasswordService.validateUsername("Nguyenquyetthang123asdvghasdvghasvghasvdhvas"));
    }
    @Test
    public void validatePassword(){
         
        //correct password
        Assert.assertTrue(PasswordService.validatePassword("Thangnguyenquyet123"));
    }
    @Test
    public void validatePassword2(){
         
        //It wasn't contains at least one digit.
        Assert.assertFalse(PasswordService.validatePassword("Thangnguyenquyet"));
    }
    @Test
    public void validatePassword3(){
         
        //It wasn't contains at least upper case alphabet.
        Assert.assertFalse(PasswordService.validatePassword("thangnguyenquyet123"));
    }
    @Test
    public void validatePassword4(){
         
        //It wasn't contains at least lower case alphabet.
        Assert.assertFalse(PasswordService.validatePassword("THANGNGUYENQUYET"));
    }
    @Test
    public void testMD5(){
        String result=StaticFuncitionService.getMd5("Thangnguyenquyet123");
        String expected="16c0ce36e334e22fda8caca1b10c2f9c";
        Assert.assertTrue(result.equals(expected));
    }
}