/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.dao;

import com.jericbryledy.whirlpool.bean.AnswerKey;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class AnswerDao {

	private WhirlpoolXPathHelper helper;

	public AnswerDao() {
		helper = WhirlpoolXPathHelper.getInstance();
	}

	public AnswerKey getByLectureId(String lectureId) {
		AnswerKey key = new AnswerKey();

		NodeList answerList = helper.retreiveNodeList("class/units/unit/lectures/lecture[@id=\"" + lectureId + "\"]/question/answers/answer");

		int len = answerList.getLength();
		for (int i = 0; i < len; ++i) {
			Node answerNode = answerList.item(i);

			NamedNodeMap att = answerNode.getAttributes();
			key.addCorrectAnswer(att.getNamedItem("name").getTextContent(), att.getNamedItem("value").getTextContent());
		}

		return key;
	}
}
