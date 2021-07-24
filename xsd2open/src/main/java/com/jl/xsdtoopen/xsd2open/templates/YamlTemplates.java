package com.jl.xsdtoopen.xsd2open.templates;

public class YamlTemplates {
    
    public final static String complexElementFromSchema = 
    "  {{NAME}}: \n" +
    "    $ref: \"#/definitions/{{TYPE}}\" ";

    public final static String complexElementBegin =
    "  {{NAME}}: \n" +
    "    properties: ";

    public final static String primitiveElementFromComplex = 
    "      {{NAME}}: \n" +
    "        type: {{TYPE}} ";

    public final static String complexElementFromComplex = 
    "      {{NAME}}: \n" +
    "        $ref: \"#/definitions/{{TYPE}}\" ";

    public final static String complexUnboundedElementFromComplex = 
    "      {{NAME}}: \n" +
    "        type: array \n" +
    "        items: \n" +
    "          $ref: \"#/definitions/{{TYPE}}\" ";
    
}
