package com.jl.xsdtoopen.xsd2open.model;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "complexType")
public class XsdComplexType {

    @Element(required = false)
    private XsdSequence sequence;
    
    @Attribute(required = false)
    private String name;

    @ElementList(inline = true, required = false, entry="attribute")
    private List<XsdAttribute> attribute;

    public XsdComplexType() {

    }

    public XsdSequence getSequence() {
        return sequence;
    }

    public void setSequence(XsdSequence sequence) {
        this.sequence = sequence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<XsdAttribute> getAttribute() {
        return attribute;
    }

    public void setAttribute(List<XsdAttribute> attribute) {
        this.attribute = attribute;
    }

    

}
