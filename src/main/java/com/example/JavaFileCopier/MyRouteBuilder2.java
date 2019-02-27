package com.example.JavaFileCopier;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

@Component
public class MyRouteBuilder2 extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:start2").split(body()).parallelProcessing().process(new Processor() {
			
			public void process(Exchange exchange) throws Exception {
					System.out.println(exchange.getIn().getBody()+" "+Thread.currentThread().getId());
				
			}
		});
	}
}
