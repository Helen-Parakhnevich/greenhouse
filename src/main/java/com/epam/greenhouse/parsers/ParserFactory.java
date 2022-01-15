package com.epam.greenhouse.parsers;

import com.epam.greenhouse.parsers.dom.DomParser;
import com.epam.greenhouse.parsers.jaxb.JaxbParser;
import com.epam.greenhouse.parsers.sax.SaxParser;
import com.epam.greenhouse.service.HandledException;

public class ParserFactory {

    public static Parser create(ParserType parserType) throws HandledException {
        switch (parserType) {
            case DOM_PARSER:
                return new DomParser();
            case SAX_PARSER:
                return new SaxParser();
            case JAXB_PARSER:
                return new JaxbParser();
            default:
                throw new HandledException("Parser type not found");
        }
    }
}
