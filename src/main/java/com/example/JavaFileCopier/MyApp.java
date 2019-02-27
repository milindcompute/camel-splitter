package com.example.JavaFileCopier;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;

public class MyApp {

	public static void main(String[] args) throws Exception {
		CamelContext camelContext = new DefaultCamelContext();
		camelContext.addRoutes(new MyRouteBuilder());
		camelContext.addRoutes(new MyRouteBuilder2());
		camelContext.addRoutes(new MyRouteBuilder3());
		camelContext.addRoutes(new MyRouteBuilder4());
		camelContext.start();
		ProducerTemplate template = camelContext.createProducerTemplate();
		List<String> body = new ArrayList<String>();
		body.add("A");
		body.add("B");
		body.add("C");
		template.sendBody("direct:start",body);
		template.sendBody("direct:start2",body);
		template.sendBody("direct:start3",body);
		template.sendBody("direct:start4",body);
	
	}

}
