/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.dao;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class WhirlpoolDao {

	private Document doc;
	private XPath xpath;

	public WhirlpoolDao(String xmlFile) throws Exception {
		doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);
		xpath = XPathFactory.newInstance().newXPath();
	}

	public NodeList retreive(String query) throws Exception {
		XPathExpression expr = xpath.compile(query);
		return (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
	}

	public String retrieveString(String query) throws Exception {
		XPathExpression expr = xpath.compile(query);
		return (String) expr.evaluate(doc, XPathConstants.STRING);
	}

	public Number retrieveNumber(String query) throws Exception {
		XPathExpression expr = xpath.compile(query);
		return (Number) expr.evaluate(doc, XPathConstants.NUMBER);
	}
}
