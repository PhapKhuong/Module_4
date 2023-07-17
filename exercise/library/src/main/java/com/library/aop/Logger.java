package com.library.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.io.*;
import java.time.LocalDateTime;

@Aspect
@Component
public class Logger {
    private static final String LOG_PATH_LAPTOP =
            "C:\\Dropbox\\Codegym\\module4\\exercise\\library\\src\\main\\java\\com\\library\\aop\\log.dat";

    private static final String LOG_PATH_PC =
            "D:\\Dropbox\\Codegym\\module4\\exercise\\library\\src\\main\\java\\com\\library\\aop\\log.dat";

    private static final String LOG_ALL_PATH_LAPTOP =
            "C:\\Dropbox\\Codegym\\module4\\exercise\\library\\src\\main\\java\\com\\library\\aop\\log_all.dat";

    private static final String LOG_ALL_PATH_PC =
            "D:\\Dropbox\\Codegym\\module4\\exercise\\library\\src\\main\\java\\com\\library\\aop\\log_all.dat";


    private static int count = 0;

    @After("execution(* com.library.controller.LibraryController.*(..))")
    public void count(JoinPoint joinPoint) throws IOException {
        try {
            FileWriter fileWriter = new FileWriter(LOG_ALL_PATH_LAPTOP, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(
                    "Vua request den server luc " + LocalDateTime.now() + "." + "\n"

            );
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            FileWriter fileWriter = new FileWriter(LOG_ALL_PATH_PC, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(
                    "Vua request den server luc " + LocalDateTime.now() + "." + "\n"
            );
            bufferedWriter.close();
        }
    }

    @AfterReturning("execution(* com.library.controller.LibraryController.createBook(..))||" +
            "execution(* com.library.controller.LibraryController.borrowBook(..))||" +
            "execution(* com.library.controller.LibraryController.returnBook(..))")
    public void logChangeBook(JoinPoint joinPoint) throws Throwable {
        count++;
        try {
            FileWriter fileWriter = new FileWriter(LOG_PATH_LAPTOP, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(
                    "Method duoc thuc hien: " + joinPoint.getSignature().getName() + ";" + "\n"
                            + "Lan thay doi thu: " + count + "; vao luc: " + LocalDateTime.now() + "." + "\n" + "\n"
            );
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            FileWriter fileWriter = new FileWriter(LOG_PATH_LAPTOP, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(
                    "Method duoc thuc hien: " + joinPoint.getSignature().getName() + ";" + "\n"
                            + "Lan thay doi thu: " + count + "; vao luc: " + LocalDateTime.now() + "." + "\n" + "\n"
            );
            bufferedWriter.close();
        }
    }
}
