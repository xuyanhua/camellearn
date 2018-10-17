package com.yanhua.camel.examples.http;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;

/**
 * @author xuyanhua
 * @description:
 * @date 2018/8/27 下午2:03
 */
public class HttpProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        Message in = exchange.getIn();
        InputStream body = (InputStream) in.getBody();

        String inString = IOUtils.toString(body, "utf-8");
        body.close();
        if (exchange.getPattern() == ExchangePattern.InOut) {
            Message out = exchange.getOut();
            out.setBody(inString + " || out");
        }
    }
}
