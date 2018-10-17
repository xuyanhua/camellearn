package com.yanhua.camel.examples.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * @author xuyanhua
 * @description:
 * @date 2018/8/27 上午11:40
 */
public class FileWithCamelTest {
    public static void main(String[] args) throws Exception {
        CamelContext cc = new DefaultCamelContext();
        cc.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:inDir?noop=true").to("file:outDir");
            }
        });
        cc.start();
        //fixme 解决有点慢，什么情况？
        System.in.read();
    }
}
