package com.mesaj.app.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@ComponentScan(basePackages = "com.mesaj.app")
@PropertySource("classpath:/application-${enviroment:dev}.properties")
public class TestConfig {

}
