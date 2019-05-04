package com.ashj.aspectjhooks;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TraceAspect {

	@Pointcut("execution(@com.ashj.aspectjhooks.Trace * *.*(..))")
	void methodAnnotatedWithTrace() {}

	@Around("methodAnnotatedWithTrace()")
	public Object trackExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long endTime = System.currentTimeMillis();

		Log.v("TraceAspect", "TimeTaken= "+(endTime-startTime)+"ms");

		return result;
	}

}

