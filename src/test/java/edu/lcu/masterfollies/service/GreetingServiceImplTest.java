package edu.lcu.masterfollies.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.lcu.masterfollies.client.GreetingService;
import edu.lcu.masterfollies.domain.JudgesTest;
import edu.lcu.masterfollies.shared.FieldVerifier;

/**
 * The server side implementation of the RPC service.
 */
@Configurable
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/META-INF/spring/applicationContext.xml", 
"classpath:/META-INF/spring/applicationContext-datasource-test.xml"})
public class GreetingServiceImplTest implements BeanFactoryAware {



  /**
   * Escape an html string. Escaping data received from the client helps to
   * prevent cross-site script vulnerabilities.
   *
   * @param html the html string to escape
   * @return the escaped string
   */
  private String escapeHtml(String html) {
    if (html == null) {
      return null;
    }
    return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(
        ">", "&gt;");
  }
  private static Log log = LogFactory.getLog(GreetingServiceImplTest.class);
	BeanFactory bf = null;
  
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
	// TODO Auto-generated method stub
	bf = beanFactory;
	
}
  
}
