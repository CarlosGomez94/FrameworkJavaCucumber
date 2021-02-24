package utilities;

import javax.security.auth.login.Configuration;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties pro;
    //Constructor para leer el "config.roperties" File
        public ReadConfig(){
            File src = new File("./Configuration/config.properties");

            try {
                FileInputStream fis = new FileInputStream(src);
                pro = new Properties();
                pro.load(fis);
            }catch (Exception e){
                System.out.println("Exception is " + e.getMessage());
            }
        }

        //Get Base URL from "config.roperties".
        public String GetApplicationURL(){
            String url = pro.getProperty("baseURL");
            return url;
        }

        //Get Username from "config.roperties".
        public String GetApplicationUsername(){
        String username = pro.getProperty("username");
        return username;
        }

        //Get Password from "config.roperties".
        public String GetApplicationPassword(){
        String password = pro.getProperty("password");
        return password;
        }

        //Get ChromePath from "config.roperties".
        public String GetApplicationChromePath(){
        String chromepath = pro.getProperty("chromepath");
        return chromepath;
        }

        //Get FirefoxPath from "config.roperties".
        public String GetApplicationFirefoxPath(){
        String firefoxpath = pro.getProperty("firefoxpath");
        return firefoxpath;
        }
}