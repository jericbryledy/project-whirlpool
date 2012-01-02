/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.dao;

import com.jericbryledy.whirlpool.bean.Unit;
import org.w3c.dom.NodeList;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class UnitDao {

	private WhirlpoolXPathHelper helper;
	private LectureDao lectureDao;

	public UnitDao() {
		helper = WhirlpoolXPathHelper.getInstance();

		lectureDao = new LectureDao();
	}

	public Unit[] getAll() {
		Unit[] units = null;
		NodeList list = helper.retreive("class/units/unit/@id");

		int size = list.getLength();
		units = new Unit[size];

		for (int i = 0; i < size; ++i) {
			units[i] = getById(list.item(i).getTextContent());
		}

		return units;
	}

	public Unit getById(String id) {
		Unit unit = new Unit();

		unit.setId(id);
		unit.setName(helper.retrieveString("class/units/unit[@id=\"" + unit.getId() + "\"]/name"));
		unit.setLectures(lectureDao.getByUnitId(id));

		return unit;
	}
}
