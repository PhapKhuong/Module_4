package com.libraries_trung.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
//    private static int count = 0;
//
//    @AfterReturning("execution(* com.libraries_trung.controller.LibraryController.createBook(..))||" +
//            "execution(* com.libraries_trung.controller.LibraryController.borrowBook(..))||" +
//            "execution(* com.libraries_trung.controller.LibraryController.returnBook(..))")
//    public void logChangeBook(JoinPoint joinPoint) throws Throwable {
//        count++;
//        System.out.println("Đếm: " + count);
//    }
}
