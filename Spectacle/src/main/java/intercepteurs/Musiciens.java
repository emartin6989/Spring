package intercepteurs;

import org.aopalliance.intercept.Invocation;
import org.aspectj.lang.ProceedingJoinPoint;

import metier.MultiInstrumentiste;
import metier.Musicien;

public class Musiciens {

	public Musiciens() {

	}

	public Object jejoue(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("je joue grave");
		return pjp.proceed();
	}
}
