@XmlSchema(namespace = "http://www.example.com/flowers",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = @XmlNs(prefix = "", namespaceURI = "http://www.example.com/flowers"))

package com.epam.greenhouse.entity;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;