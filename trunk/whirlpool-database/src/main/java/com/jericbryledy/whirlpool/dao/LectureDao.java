/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.dao;

import com.jericbryledy.whirlpool.bean.Lecture;
import org.w3c.dom.NodeList;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class LectureDao {

	private WhirlpoolXPathHelper helper;

	public LectureDao() {
		helper = WhirlpoolXPathHelper.getInstance();
	}

	public Lecture[] getByUnitId(String unitId) {
		Lecture[] lectures = null;
		NodeList list = helper.retreiveNodeList("class/units/unit[@id=\"" + unitId + "\"]/lectures/lecture/@id");

		int size = list.getLength();
		lectures = new Lecture[size];

		for (int i = 0; i < size; ++i) {
			lectures[i] = getById(list.item(i).getTextContent());
		}

		return lectures;
	}

	public Lecture getById(String id) {
		Lecture lecture = new Lecture();

		StringBuilder mainQuery = new StringBuilder();
		mainQuery.append("class/units/unit/lectures/lecture[@id=\"").append(id).append("\"]/");

		lecture.setId(id);
		lecture.setName(helper.retrieveString(mainQuery.toString() + "name"));
		lecture.setVideo(helper.retrieveString(mainQuery.toString() + "video"));

		return lecture;
	}
}
