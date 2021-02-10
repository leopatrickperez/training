package com.bootcamp.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties(prefix = "db")
public class config {
    private String server;
    private String dbName;
    private String user;
    private String password;

    public config(){}
    public config(String server,String dbName,String user,String password)
    {
        this.server = server;
        this.dbName = dbName;
        this.user = user;
        this.password = password;
    }


    public String getServer(){return  server;}

    public void setServer(String server){
        this.server =  server;
    }

    public String getDbName(){ return dbName;}

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUser(){return  user;}

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword(){return  password;}

    public void setPassword(String password) {
        this.password = password;
    }


    @Profile("dev")
    @Bean
    public void devConnection() {
        System.out.println("test dev");
        System.out.println(this.server);
        System.out.println(this.dbName);
        System.out.println(this.user);
        System.out.println(this.password);
    }
}



