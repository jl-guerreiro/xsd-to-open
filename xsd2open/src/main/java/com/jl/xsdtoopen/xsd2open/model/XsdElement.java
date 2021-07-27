package com.jl.xsdtoopen.xsd2open.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "element")
public class XsdElement {

    @Attribute(name = "name")
    private String name;

    @Attribute(name = "type", required = false)
    private String type;

    @Attribute(name = "minOccurs", required = false)
    private String minOccurs;

    @Attribute(name = "maxOccurs", required = false)
    private String maxOccurs;

    @Element(name = "complexType", required = false)
    private XsdComplexType complexType;

    public XsdElement(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMinOccurs() {
        return minOccurs;
    }

    public void setMinOccurs(String minOccurs) {
        this.minOccurs = minOccurs;
    }

    public String getMaxOccurs() {
        return maxOccurs;
    }

    public void setMaxOccurs(String maxOccurs) {
        this.maxOccurs = maxOccurs;
    }

    public XsdComplexType getComplexType(){
        return this.complexType;
    }

    public void setComplexType(XsdComplexType complexType){
        this.complexType = complexType;
    }

}
