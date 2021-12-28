package com.epam.greenhouse.parsers.dom;

import com.epam.greenhouse.entity.Flower;
import com.epam.greenhouse.parsers.Parser;
import com.epam.greenhouse.service.HandledException;

import java.util.List;

public class DomParser implements Parser {

    @Override
    public List<Flower> parse(String path) throws HandledException {
        throw new UnsupportedOperationException();
    }
}
