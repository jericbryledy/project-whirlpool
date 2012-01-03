/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.dao;

import com.jericbryledy.whirlpool.bean.Question;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class QuestionDao {

	private WhirlpoolXPathHelper helper;
	private FormDao formDao;

	public QuestionDao() {
		helper = WhirlpoolXPathHelper.getInstance();
		formDao = new FormDao();
	}

	public Question getByLectureId(String lectureId) {
		Question question = null;

		StringBuilder mainQuery = new StringBuilder();
		mainQuery.append("class/units/unit/lectures/lecture[@id=\"").append(lectureId).append("\"]/question");

		if (!helper.retrieveString(mainQuery.toString()).isEmpty()) {
			mainQuery.append('/');

			question = new Question();
			question.setImage(helper.retrieveString(mainQuery.toString() + "image"));
			question.setForm(formDao.getByLectureId(lectureId));
		}

		return question;
	}
}
