package i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Mr.Yang
 * @date 2020/03/10
 **/
public class I18nTest {
    @Test
    public void testLocale(){
//        Locale aDefault = Locale.getDefault();
//        System.out.println("aDefault = " + aDefault);

//        for (Locale availableLocale : Locale.getAvailableLocales()) {
//            System.out.println("availableLocale = " + availableLocale);
//        }

        System.out.println(Locale.CHINA);
//        System.out.println(Locale.CHINESE);
        System.out.println(Locale.US);
//        System.out.println(Locale.ENGLISH);
    }

    @Test
    public void testI18n(){
//        Locale us = Locale.US;
//
//        ResourceBundle usBundle = ResourceBundle.getBundle("i18n", us);
//        System.out.println("username="+usBundle.getString("username"));
//        System.out.println("password="+usBundle.getString("password"));
//        System.out.println("sex="+usBundle.getString("sex"));
//        System.out.println("age="+usBundle.getString("age"));

        Locale china = Locale.CHINA;

        ResourceBundle chinaBundle = ResourceBundle.getBundle("i18n", china);
        System.out.println("username="+chinaBundle.getString("username"));
        System.out.println("password="+chinaBundle.getString("password"));
        System.out.println("sex="+chinaBundle.getString("sex"));
        System.out.println("age="+chinaBundle.getString("age"));
    }
}
