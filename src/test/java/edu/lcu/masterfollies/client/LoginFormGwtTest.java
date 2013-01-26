package edu.lcu.masterfollies.client;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.spring.GwtSpringRunner;
import com.googlecode.gwt.test.spring.GwtSpringTest;
import com.googlecode.gwt.test.spring.GwtTestContextLoader;
import com.googlecode.gwt.test.utils.GwtReflectionUtils;
import com.googlecode.gwt.test.utils.events.Browser;

import edu.lcu.masterfollies.client.activity.LoginActivity;
import edu.lcu.masterfollies.client.place.LoginPlace;
import edu.lcu.masterfollies.client.ui.LoginView;
import edu.lcu.masterfollies.domain.Judges;


/**
 * GWT JUnit tests must extend GWTTestCase.
 */
@GwtModule("edu.lcu.masterfollies.masterfollies")
@Configurable
@RunWith(value=GwtSpringRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/spring/applicationContext.xml", 
		"classpath:/META-INF/spring/applicationContext-datasource-test.xml"}, loader = GwtTestContextLoader.class)
public class LoginFormGwtTest  extends GwtSpringTest implements BeanFactoryAware, AcceptsOneWidget  {
	private static Log log = LogFactory.getLog(LoginFormGwtTest.class);

	private masterfollies app;

	private BeanFactory bf;
	Properties p;
	   
	   
	public LoginFormGwtTest() {
		   
		  p = new Properties();
		  try {
			p.load(new FileInputStream("build.properties"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

  /**
   * Must refer to a valid module that sources this class.
   */
  public String getModuleName() {
    return "edu.lcu.masterfollies.masterfollies";
  }
  
  @Before
  public void beforeGwtTestForm() {
    app = new masterfollies();
    edu.lcu.masterfollies.shared.Log.setTesting(true);
    app.onModuleLoad();
    log.debug("before test ");
  }


  @Test
  public void testAuthenticate() {
	  Integer personId = 1;
	  GreetingServiceTestAsync service = new GreetingServiceTestAsync();
	  Judges testJudge  = new Judges();
	  service.setAuthenticateResult(testJudge);
	  testJudge.setId(personId);
	  
	  
	  ClientFactory clientFactory = GwtReflectionUtils.getPrivateFieldValue(app, "clientFactory");
	  GwtReflectionUtils.setPrivateFieldValue(clientFactory, "rpcService", service);
	  
	  LoginActivity login = new LoginActivity(clientFactory);
	  login.authenticate();
	  
	  PlaceController placeController = clientFactory.getPlaceController();
	  Place where = new LoginPlace("");

	  GwtReflectionUtils.setPrivateFieldValue(placeController, "where", where);
	  
	  LoginView loginView = GwtReflectionUtils.getPrivateFieldValue(clientFactory, "loginView");
	  
	  LoginActivity activity = new LoginActivity(clientFactory);
	  
	  activity.start(this, clientFactory.getEventBus());

	  
	  TreeMap<String, Valid> alert = null;
	  
	  String userName = "judge_user_name";
	  String password = "judge_password";
	  
	  TextBox txtFirstName = GwtReflectionUtils.getPrivateFieldValue(loginView, "txtUserName");
	  Browser.fillText(txtFirstName, userName);
	  
	  TextBox txtLastName = GwtReflectionUtils.getPrivateFieldValue(loginView, "txtPassword");
	  Browser.fillText(txtLastName, password);


		Browser.click((Widget) loginView.getOKButton());
		
		Map parameters = service.getParameters();

		//When we click the OK button, the user name passed to the service should
		// be the same as the user name filled in to txtUserName
		assertTrue(userName.equals(parameters.get("user")));
		assertTrue(password.equals(parameters.get("password")));
		
		Judges result = (Judges) parameters.get("_result");
		assertTrue(result.getId() == testJudge.getId());
		
		// Might want to check placeController is set to next place when that code exists

  }
  
  @Test
  public void testAuthenticateFail() {
	  Integer personId = 1;
	  GreetingServiceTestAsync service = new GreetingServiceTestAsync();
	  
	  
	  Judges testJudge  = null; // We'll simulate failing here
	  service.setAuthenticateResult(testJudge);

	  ClientFactory clientFactory = GwtReflectionUtils.getPrivateFieldValue(app, "clientFactory");
	  GwtReflectionUtils.setPrivateFieldValue(clientFactory, "rpcService", service);
	  
	  LoginActivity login = new LoginActivity(clientFactory);
	  login.authenticate();
	  
	  PlaceController placeController = clientFactory.getPlaceController();
	  Place where = new LoginPlace("");

	  GwtReflectionUtils.setPrivateFieldValue(placeController, "where", where);
	  
	  LoginView loginView = GwtReflectionUtils.getPrivateFieldValue(clientFactory, "loginView");
	  
	  LoginActivity activity = new LoginActivity(clientFactory);
	  
	  activity.start(this, clientFactory.getEventBus());

	  
	  TreeMap<String, Valid> alert = null;
	  
	  String userName = "judge_user_name";
	  String password = "judge_password";
	  
	  TextBox txtFirstName = GwtReflectionUtils.getPrivateFieldValue(loginView, "txtUserName");
	  Browser.fillText(txtFirstName, userName);
	  
	  TextBox txtLastName = GwtReflectionUtils.getPrivateFieldValue(loginView, "txtPassword");
	  Browser.fillText(txtLastName, password);


		Browser.click((Widget) loginView.getOKButton());
		
		Map parameters = service.getParameters();

		//When we click the OK button, the user name passed to the service should
		// be the same as the user name filled in to txtUserName
		assertTrue(userName.equals(parameters.get("user")));
		assertTrue(password.equals(parameters.get("password")));
		
		Judges result = (Judges) parameters.get("_result");
		assertTrue(result == null);
		
		where = GwtReflectionUtils.getPrivateFieldValue(placeController, "where");
		assertTrue(where instanceof LoginPlace);

  }
  

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		bf = beanFactory;
	}

	@Override
	public void setWidget(IsWidget w) {
	}

}
