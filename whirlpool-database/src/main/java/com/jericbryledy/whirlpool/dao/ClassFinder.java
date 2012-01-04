/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class ClassFinder {

	public String getClassFile() throws IOException {
		Properties p = new Properties();
		p.load(new FileInputStream("class.properties"));

		return p.getProperty("class");
	}
}
