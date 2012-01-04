/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class WhirlpoolXPathHelper extends XPathHelper {

	private static WhirlpoolXPathHelper instance;

	public static WhirlpoolXPathHelper getInstance() {
		if (instance == null) {
			try {
				instance = new WhirlpoolXPathHelper();
			} catch (Exception ex) {
				Logger.getLogger(WhirlpoolXPathHelper.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		return instance;
	}

	private WhirlpoolXPathHelper() throws Exception {
		super(new ClassFinder().getClassFile());
	}
}
