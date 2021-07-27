package com.jl.xsdtoopen.xsd2open.model;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="schema")
public class XsdSchema {

   @ElementList(entry="element", inline = true, required = false)
   private List<XsdElement> element;

   @ElementList(entry="complexType", inline = true, required = false)
   private List<XsdComplexType> complexType;

   @Attribute(required = false)
   private String targetNamespace;

   @Attribute(required = false)
   private String elementFormDefault;

   @Attribute(required = false)
   private String encoding;

   @Attribute(required = false)
   private String version;

   public XsdSchema(){

   }

   public List<XsdElement> getElement() {
      return element;
   }

   public void setElement(List<XsdElement> element) {
      this.element = element;
   }

   public List<XsdComplexType> getComplexType() {
      return complexType;
   }

   public void setComplexType(List<XsdComplexType> complexType) {
      this.complexType = complexType;
   }

   public String getTargetNamespace() {
      return targetNamespace;
   }

   public void setTargetNamespace(String targetNamespace) {
      this.targetNamespace = targetNamespace;
   }

   public String getElementFormDefault() {
      return elementFormDefault;
   }

   public void setElementFormDefault(String elementFormDefault) {
      this.elementFormDefault = elementFormDefault;
   }

   public String getEncoding() {
      return encoding;
   }

   public void setEncoding(String encoding) {
      this.encoding = encoding;
   }

   public String getVersion() {
      return version;
   }

   public void setVersion(String version) {
      this.version = version;
   }

   



}
