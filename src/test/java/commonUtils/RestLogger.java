package commonUtils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class RestLogger {

    private static final Logger Log = Logger.getLogger(RestLogger.class.getName());

    public static void initLogger(){
        PropertyConfigurator.configure("log4j.properties");
    }

    public static void startTestCase(String sTestcaseName){
        Log.info("********************************************************************************");
        Log.info("********************************************************************************");
        Log.info("$$$$$$$$$$$$$$$$$$$$$$        " + sTestcaseName +"       $$$$$$$$$$$$$$$$$$$$$$$");
        Log.info("********************************************************************************");
        Log.info("********************************************************************************");

    }

    public static void endTestCase(){
        Log.info("XXXXXXXXXXXXXX            " + "E--N--D" +"         XXXXXXXXXXXXXX");
        Log.info("XXXXXXXXXXXXXX*************************************XXXXXXXXXXXXXX");
        Log.info("XXXXXXXXXXXXXX*************************************XXXXXXXXXXXXXX");
        Log.info("X");
        Log.info("X");
        Log.info("X");
    }


    public static void info(String message){
        Log.info(message);
    }

    public static void warn(String message){
        Log.warn(message);
    }

    public static void error(String message){
        Log.error(message);

    }
    public static void fatal(String message){
        Log.fatal(message);
    }

    public static void debug(String message){
        Log.debug(message);
    }
}
