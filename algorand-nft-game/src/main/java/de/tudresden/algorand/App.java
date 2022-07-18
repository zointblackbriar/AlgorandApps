package de.tudresden.algorand;

import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */


@SpringBootApplication(scanBasePackages= {"de.tudresden.algorand.rest", "de.tudresden.algorand"})
public class App 
{
	private static final Logger logger = Logger.getLogger(App.class.getName());
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
		SpringApplication app = new SpringApplication(App.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
		app.run(args);
		logger.info("the server has been activated");
		beanContext(args);
    }
    
	private static void beanContext(String[] args) {
		var ctx = SpringApplication.run(App.class, args); 
		logger.info("# Beans: " + ctx.getBeanDefinitionCount()); 
		
		var names = ctx.getBeanDefinitionNames(); 
		Arrays.sort(names);
		Arrays.asList(names).forEach(System.out::println);

	}

    

}
