package com.config;

/**
 * Created by arabbani on 11/19/16.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApplicationCas
{

    private static Logger log = LoggerFactory.getLogger(ApplicationCas.class);
    public static void main(String[] args)
    {
        log.info("Application name is *************************** ");
        SpringApplication.run(ApplicationCas.class, args);
    }
}

