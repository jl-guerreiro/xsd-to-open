package com.jl.xsdtoopen.xsd2open;

import java.io.File;

import com.jl.xsdtoopen.xsd2open.model.XsdAttribute;
import com.jl.xsdtoopen.xsd2open.model.XsdComplexType;
import com.jl.xsdtoopen.xsd2open.model.XsdElement;
import com.jl.xsdtoopen.xsd2open.model.XsdSchema;
import com.jl.xsdtoopen.xsd2open.templates.YamlTemplates;

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
		File source = new ClassPathResource("data/easy.xsd").getFile();
		XsdSchema schema = serializer.read(XsdSchema.class, source);
		schema.getElement().stream().forEach(
			x -> print(x.getName(), x.getType(),YamlTemplates.complexElementFromSchema)
		);
		for(XsdComplexType type : schema.getComplexType()){
			print(type.getName(), null, YamlTemplates.complexElementBegin);
			for(XsdElement el : type.getSequence().getElement()){
				if(el.getType().contains("tns:")){
					if(el.getMaxOccurs()==null){
						print(el.getName(), el.getType(), YamlTemplates.complexElementFromComplex);
					} else if(el.getMaxOccurs().equals("unbounded")){
						print(el.getName(), el.getType(), YamlTemplates.complexUnboundedElementFromComplex);
					} else {
						print(el.getName(), el.getType(), YamlTemplates.complexElementFromComplex);
					}
				}else{
					setDatatypeAndPrint(el.getName(), el.getType());
				}
			}
			try{
				for(XsdAttribute attr : type.getAttribute()){
					setDatatypeAndPrint(attr.getName(), attr.getType());
				}
			}catch(NullPointerException npe){
				// NO ITENS AS ATTRIBUTES
			}
		}
	}

	private void setDatatypeAndPrint(String name, String type){
		String datatype = "string";
		if(type.toLowerCase().contains("int")) datatype = "number";
		if(type.toLowerCase().contains("bool")) datatype = "boolean";
		if(type.toLowerCase().contains("double")) datatype = "number";
		print(name, datatype, YamlTemplates.primitiveElementFromComplex);
	}

	private void print(String name, String type, String template){
		String s = template;
		if(name!=null){
			s = s.replace("{{NAME}}", name);
		}
		if(type!=null){
			if(type.contains("tns:")) type = type.replace("tns:","");
			s = s.replace("{{TYPE}}", type);
		}
		System.out.println(s);
	}

	

}
