package com.example.JavaFileCopier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
public class MyRouteBuilder4 extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		from("direct:start4").split(body()).executorService(executorService).process(new Processor() {
			
			public void process(Exchange exchange) throws Exception {
					System.out.println(exchange.getIn().getBody()+" "+Thread.currentThread().getId());
				
			}
		});
	}
}
