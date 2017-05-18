package intercepteurs;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Spectateurs2 {
	
	@Pointcut("execution(* *.performe(..))")
	public void performance(){	
	}
	
	@Before("performance()")
	public void prendPlace(){
		System.out.println("les spectateurs prennent place");
	}
	
	@Before("performance()")
	public void eteindreTelephone(){
		System.out.println("les spectateurs éteignent leurs téléphones");
	}
	
	@Before("performance()")
	public void applaudit(){
		System.out.println("les spectateurs applaudissent");
	}
	
	@AfterThrowing("performance()")
	public void demanderRemboursement(){
		System.out.println("Bouh ! Remboursez !");
		
	}
	
	

}
