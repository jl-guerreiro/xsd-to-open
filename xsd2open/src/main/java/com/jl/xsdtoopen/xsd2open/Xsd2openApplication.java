package com.jl.xsdtoopen.xsd2open;

import java.io.File;

import com.jl.xsdtoopen.xsd2open.model.XsdComplexType;
import com.jl.xsdtoopen.xsd2open.model.XsdElement;
import com.jl.xsdtoopen.xsd2open.model.XsdSchema;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class Xsd2openApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Xsd2openApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Serializer serializer = new Persister();
		File source = new ClassPathResource("data/sample.xsd").getFile();
		XsdSchema schema = serializer.read(XsdSchema.class, source);
		schema.getElement().stream().forEach(
			x -> System.out.println("el:" + x.getName() + " " + x.getType())
		);
		for(XsdComplexType type : schema.getComplexType()){
			System.out.println(" type: " + type.getName());
			for(XsdElement el : type.getSequence().getElement()){
				System.out.println("  el: " + el.getName() + " " + el.getType());
			}
		}
	}

	

}
