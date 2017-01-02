package com.swingmvp.config;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.SAXException;

/**
 *
 * @author marek
 */
public class XMLReader implements Reader {

    private Configuration _config;

    private String _fileName;

    private Document _doc;

    @Override
    public Configuration read(String fileName) {
        _config = new Configuration();
        _fileName = fileName;

        loadDocument();
        parseViewConfig();

        return _config;
    }

    private void loadDocument() {
        try {

            DocumentBuilderFactory factory
                    = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();
            _doc = builder.parse(
                    new File(_fileName)
            );

        } catch (SAXException | IOException | ParserConfigurationException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void parseViewConfig() {
        NodeList configNodes = _doc.getElementsByTagName("view");

        int len = configNodes.getLength();

        for (int i = 0; i < len; i++) {
            Node configNode = configNodes.item(i);
            parseViewConfigurationNode(configNode.getAttributes());

        }
    }

    private void parseViewConfigurationNode(NamedNodeMap attr) {
        if (attr != null) {
            String viewName = attr.
                    getNamedItem("view-name").getNodeValue();
            String presenterName = attr.
                    getNamedItem("presenter-name").
                    getNodeValue();

            _config.addViewConfiguration(viewName, presenterName);
        }
    }

}
