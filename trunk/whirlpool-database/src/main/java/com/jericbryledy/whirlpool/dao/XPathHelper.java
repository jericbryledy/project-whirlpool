/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class XPathHelper {

	private Document doc;
	private XPath xpath;

	public XPathHelper(String xmlFile) throws Exception {
		doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);
		xpath = XPathFactory.newInstance().newXPath();
	}

	public NodeList retreive(String query) {
		try {
			XPathExpression expr = xpath.compile(query);
			return (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
		} catch (XPathExpressionException ex) {
			Logger.getLogger(XPathHelper.class.getName()).log(Level.SEVERE, null, ex);
		}

		return null;
	}

	public String retrieveString(String query) {
		try {
			XPathExpression expr = xpath.compile(query);
			return (String) expr.evaluate(doc, XPathConstants.STRING);
		} catch (XPathExpressionException ex) {
			Logger.getLogger(XPathHelper.class.getName()).log(Level.SEVERE, null, ex);
		}

		return null;
	}
}
