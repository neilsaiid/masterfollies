package edu.lcu.masterfollies.shared;




public class Log {
	//private static org.apache.commons.logging.Log log = LogFactory.getLog(Log.class);
	
	public static boolean testing = false;
	
	public static void debug(String message) {
		if (!testing) {
			 //com.allen_sauer.gwt.log.client.Log.debug(message);
			 System.err.println(message);
		}
		else {
			System.err.println(message);
		}
	}
	
	public static void setTesting(boolean testing) {
		Log.testing = testing;
	}
	
	public static void setUncaughtExceptionHandler() {
		if (!testing) {
			//com.allen_sauer.gwt.log.client.Log.setUncaughtExceptionHandler();
		}
	}
}
