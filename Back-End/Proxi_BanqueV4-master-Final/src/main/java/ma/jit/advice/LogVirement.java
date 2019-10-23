package ma.jit.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;


@Aspect
@Component
public class LogVirement {
	private static final Logger log = Logger.getRootLogger();

	@Pointcut(value = "execution(* ma.jit.controller.Virement.virement(..) )")
	public void myPointcut() {

	}

	@After("myPointcut()")
	public void setLog(JoinPoint p) throws Throwable {
		Date date = new Date();
		Object[] param = p.getArgs();
		ObjectMapper obj = new ObjectMapper();
		String methodeName = p.getSignature().getName();
		FileAppender file = null;
		try {
			file = new FileAppender();
			file.setLayout(new SimpleLayout());
			file.setFile("./log.txt");
			file.activateOptions();
			log.addAppender(file);
			log.setLevel(Level.DEBUG);
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info(date + " " + methodeName + " " + obj.writeValueAsString(param));

	}

}
