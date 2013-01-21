package edu.lcu.masterfollies.server;

//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.lcu.masterfollies.client.GreetingService;
import edu.lcu.masterfollies.domain.Judges;
import edu.lcu.masterfollies.domain.JudgesExample;
import edu.lcu.masterfollies.domain.JudgesMapper;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
    GreetingService {
	
	private JudgesMapper judgesMapper;

	@Autowired
	public void setPersonMapper(JudgesMapper judgesMapper) {
		new Exception("SET person MAPPER").printStackTrace();
		this.judgesMapper = judgesMapper;
	}
	

	private static Log log = LogFactory.getLog(GreetingServiceImpl.class);
	BeanFactory bf = null;
	
	/**
	 * Simple client side verification that the fields have been populated.
	 */
	public String greetServer(String input) throws IllegalArgumentException {
//	    // Verify that the input is valid.
//	    if (!FieldVerifier.isValidName(input)) {
//	      // If the input is not valid, throw an IllegalArgumentException back to
//	      // the client.
//	      throw new IllegalArgumentException(
//	          "Username and Password must be filled in");
//	    }
		return "Thank you. Please wait while we verifiy your information";
	}
	//@Override
	
	/**
	 * Accepts user input and compares it against judges table
	 */
	public Judges authenticate(String user, String password) {
		log.debug("Authenticate " + user);
		
		/**
		 * create the Judges table object
		 */
		
		JudgesExample je = new JudgesExample();
		je.createCriteria().andPasswordEqualTo(password).andUserNameEqualTo(user);
		Judges j = (Judges) judgesMapper.selectByExample(je);

			log.debug("username = " + j.getUserName());
			log.debug("Password = " + j.getPassword());
		
		return j;
	}

///**
// * The default built user input against simple user input at the client level 
// */
//  public String greetServer(String input) throws IllegalArgumentException {
//    // Verify that the input is valid.
//    if (!FieldVerifier.isValidName(input)) {
//      // If the input is not valid, throw an IllegalArgumentException back to
//      // the client.
//      throw new IllegalArgumentException(
//          "Name must be at least 4 characters long");
//    }
//  }
}
//
//    String serverInfo = getServletContext().getServerInfo();
//    String userAgent = getThreadLocalRequest().getHeader("User-Agent");
//
//    // Escape data from the client to avoid cross-site script vulnerabilities.
//    input = escapeHtml(input);
//    userAgent = escapeHtml(userAgent);
//
//    return "Hello, " + input + "!<br><br>I am running " + serverInfo
//        + ".<br><br>It looks like you are using:<br>" + userAgent;
//  }
//
//  /**
//   * Escape an html string. Escaping data received from the client helps to
//   * prevent cross-site script vulnerabilities.
//   *
//   * @param html the html string to escape
//   * @return the escaped string
//   */
//  private String escapeHtml(String html) {
//    if (html == null) {
//      return null;
//    }
//    return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(
//        ">", "&gt;");
//  }
//}
