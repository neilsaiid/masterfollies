package edu.lcu.masterfollies.server;

//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;



import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.lcu.masterfollies.client.GreetingService;
import edu.lcu.masterfollies.domain.Judges;
import edu.lcu.masterfollies.domain.JudgesExample;
import edu.lcu.masterfollies.domain.JudgesMapper;

/**
 * The server side implementation of the RPC service.
 */
@Configurable
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
	
	/**
	 *  Accepts user name and password and returns null if they do not authenticate against 
	 *  judges table
	 * @param user      - username given to user by super judge 
	 * @param password  - given to user by super judge
	 * @return
	 */
	@Override
	public Judges authenticate(String user, String password) {
		log.debug("Authenticate " + user);
		if ((user == null) || (password == null))
			return null;
		
		/**
		 * create the Judges table object
		 */
		
		JudgesExample je = new JudgesExample();
		je.createCriteria().andPasswordEqualTo(password).andUserNameEqualTo(user);
		//Judges j = (Judges) judgesMapper.selectByExample(je);
		
		List<Judges> result = (List<Judges>) judgesMapper.selectByExample(je);
		
			
		if ((result==null) || (result.size()==0)){
			log.debug("(>^^)> returning null <(^^<)");
			return null;
		}
		for(Judges j:result){
			log.debug(j.getLastName());
		}
		Judges j = result.get(0);
		log.debug("username = " + j.getUserName());
		log.debug("Password = " + j.getPassword());
		return j;
	}
}
