package com.epam.greenhouse.parsers;

import com.epam.greenhouse.entity.Flower;
import com.epam.greenhouse.service.HandledException;

import java.util.List;

public interface Parser {
    List<Flower> parse(String path) throws HandledException;
}
