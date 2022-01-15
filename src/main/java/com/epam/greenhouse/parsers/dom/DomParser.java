package com.epam.greenhouse.parsers.dom;

import com.epam.greenhouse.entity.Flower;
import com.epam.greenhouse.parsers.Parser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements Parser {

    @Override
    public List<Flower> parse(String path) {
        ArrayList<Flower> flowerCollection =  new ArrayList<>();
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(path);
            Element root = document.getDocumentElement();
            flowerCollection = DomAnalyzer.listBuilder(root);
            return flowerCollection;
        } catch (SAXException e) {
            e.printStackTrace();
            System.out.print("ошибка SAX парсера");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            System.out.print("ошибка конфигурации");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.print("ошибка I/О потока");
        }
        return flowerCollection;
    }
}


