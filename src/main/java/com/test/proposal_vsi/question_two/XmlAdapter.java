package com.test.proposal_vsi.question_two;

/**
 * Adaptador para a biblioteca de XML
 */
public class XmlAdapter implements DataParser {
    private final XmlLibrary xmlLibrary;

    public XmlAdapter(XmlLibrary xmlLibrary) {
        this.xmlLibrary = xmlLibrary;
    }

    @Override
    public void parseData(String data) {
        String tagName = data.replaceAll("<(.*?)>.*</\\1>", "$1");
        String content = data.replaceAll("<" + tagName + ">(.*?)</" + tagName + ">", "$1");

        xmlLibrary.parseXml(tagName + ": " + content);
    }
}
