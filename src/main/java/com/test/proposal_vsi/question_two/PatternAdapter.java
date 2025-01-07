package com.test.proposal_vsi.question_two;

public class PatternAdapter {

    public static void main(String[] args) {
        // Usando a biblioteca antiga com XML
        XmlLibrary xmlLibrary = new XmlLibrary();
        DataParser xmlAdapter = new XmlAdapter(xmlLibrary);
        xmlAdapter.parseData("<data>XML Content</data>");

        // Usando a nova biblioteca com JSON
        JsonLibrary jsonLibrary = new JsonLibrary();
        DataParser jsonAdapter = new JsonAdapter(jsonLibrary);
        jsonAdapter.parseData("{ \"data\": \"JSON Content\" }");
    }
}
