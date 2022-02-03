package helper;

import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.internal.StringUtil;

public class EnvironmentUtils {
	private static Logger log = LogManager.getLogger(EnvironmentUtils.class);

	public static String getEnvrionmentProperties(String propertyName) {

		String environment = System.getProperty("ENVIRONMENT");
		if (StringUtil.isBlank(environment)) {
			environment = Constants.DEFAULT_ENVIRONMENT;
			log.info("ENVIRONMENT property was not set. Using deafult environment: {}", environment);
		}

		ResourceBundle resource = ResourceBundle.getBundle(environment.toLowerCase());

		log.info("Running test in: {}", environment);
		return resource.getString(propertyName);
	}

}
