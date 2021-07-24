package com.jl.xsdtoopen.xsd2open.model;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "sequence")
public class XsdSequence {

    @ElementList(entry = "element" , inline = true, required = false)
    private List<XsdElement> element;

    public XsdSequence(){

    }

    public List<XsdElement> getElement() {
        return element;
    }

    public void setElement(List<XsdElement> element) {
        this.element = element;
    }
    
}
