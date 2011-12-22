/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.dao;

import com.jericbryledy.whirlpool.bean.EClass;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class EClassDao {

	private WhirlpoolXPathHelper helper;
	private UnitDao unitDao;

	public EClassDao() {
		helper = WhirlpoolXPathHelper.getInstance();
		unitDao = new UnitDao();
	}

	public EClass getEClass() {
		EClass eclass = new EClass();

		eclass.setName(helper.retrieveString("class/name"));
		eclass.setUnits(unitDao.getAll());

		return eclass;
	}
}
