/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.dao;

import com.jericbryledy.whirlpool.bean.Unit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.NodeList;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class UnitDao {

	private WhirlpoolDao dao;

	public UnitDao() {
		try {
			dao = new WhirlpoolDao("ai-class.xml");
		} catch (Exception ex) {
			Logger.getLogger(UnitDao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Unit[] getAll() {
		Unit[] units = null;
		try {
			NodeList list = dao.retreive("units/unit/@id");

			int size = list.getLength();
			units = new Unit[size];

			for (int i = 0; i < size; ++i) {
				Unit unit = units[i] = new Unit();

				unit.setId(Integer.parseInt(list.item(i).getTextContent()));
				unit.setName(dao.retrieveString("units/unit[@id=" + unit.getId() + "]/name"));
			}
		} catch (Exception ex) {
			Logger.getLogger(UnitDao.class.getName()).log(Level.SEVERE, null, ex);
		}

		return units;
	}
}
