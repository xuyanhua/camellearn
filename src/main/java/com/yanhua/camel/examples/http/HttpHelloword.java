package com.yanhua.camel.examples.http;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.ModelCamelContext;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author xuyanhua
 * @description:
 * @date 2018/8/27 下午1:57
 */
public class HttpHelloword {
    public static void main(String[] args) throws Exception {
        String path = HttpHelloword.class.getResource("/log4j.properties").getPath();
        PropertyConfigurator.configure(path);
        PropertyConfigurator.configureAndWatch(path,1000);
        ModelCamelContext mcc = new DefaultCamelContext();
        mcc.addRoutes(new RouteBuilder(){

            public void configure() throws Exception {
                from("jetty:http://0.0.0.0:8282/doHelloWorld").process(new HttpProcessor())
                        .to("log:helloworld?showExchangeId=true");
            }
        });
        mcc.start();
        System.in.read();
    }
}
