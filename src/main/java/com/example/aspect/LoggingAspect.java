package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Before("execution(* com.example.service.VehicleServiceImpl.saveVehicle(..))")
	public void logBeforSaveVehicle(JoinPoint joinPoint) {
		System.out.println("************* VehicleServiceImpl.saveVehicle() Request Param : " + joinPoint.getArgs()[0]);
	}

	@AfterReturning(pointcut = "execution(* com.example.service.VehicleServiceImpl.saveVehicle(..))", returning = "retVal")
	public void logAfterReturningSaveVehicle(Object retVal) throws Throwable {
		System.out.println("************* Retrun value from VehicleServiceImpl.saveVehicle() : "+retVal+" ****************");
	}
	

	@Before("execution(* com.example.service.DBServiceA.getData(..))") // point-cut expression
	public void logBeforeGetData(JoinPoint joinPoint) {
		System.out.println("Before DBServiceA.getData() Args : " + joinPoint.getArgs());
	}
	
	
	@Before("execution(* com.example.service.HttpServiceB.sendMessage(..))")
	public void logBeforeSendMessage(JoinPoint joinPoint) {
		System.out.println("Before HttpServiceB.sendMessage() Args : " + joinPoint.getArgs());
	}

	@AfterReturning(pointcut = "execution(* com.example.service.DBServiceA.getData(..))", returning = "retVal")
	public void logAfterReturningGetData(Object retVal) throws Throwable {
		
		System.out.println(" Retrun value from DBServiceA.getData() : ");
		System.out.println(retVal);
	}
	
	
	@AfterReturning(pointcut = "execution(* com.example.service.HttpServiceB.sendMessage(..))", returning = "retVal")
	public void logAfterReturningSendMessage(Object retVal) throws Throwable {
		System.out.println(" Retrun value from HttpServiceB.sendMessage() : ");
		System.out.println(retVal);
	}

}
