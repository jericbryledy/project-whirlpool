/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.dao;

import com.jericbryledy.whirlpool.bean.Form;
import com.jericbryledy.whirlpool.bean.forminput.RadioChoice;
import com.jericbryledy.whirlpool.bean.forminput.RadioInput;
import com.jericbryledy.whirlpool.bean.forminput.TextInput;
import java.util.List;
import java.util.Stack;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class FormDao {

	private WhirlpoolXPathHelper helper;

	public FormDao() {
		helper = WhirlpoolXPathHelper.getInstance();
	}

	public Form getByLectureId(String lectureId) {
		Form form = new Form();

		StringBuilder mainQuery = new StringBuilder();
		mainQuery.append("class/units/unit/lectures/lecture[@id=\"").append(lectureId).append("\"]/question/form/");

		NodeList textList = helper.retreiveNodeList(mainQuery.toString() + "text");
		textHelper(form, textList);

		NodeList radioList = helper.retreiveNodeList(mainQuery.toString() + "radio");
		radioHelper(form, radioList);

		return form;
	}

	private void textHelper(Form form, NodeList textList) {
		int len = textList.getLength();
		for (int i = 0; i < len; ++i) {
			Node textNode = textList.item(i);

			TextInput text = new TextInput();
			NamedNodeMap att = textNode.getAttributes();
			text.setName(att.getNamedItem("name").getTextContent());
			text.setX(Integer.parseInt(att.getNamedItem("x").getTextContent()));
			text.setY(Integer.parseInt(att.getNamedItem("y").getTextContent()));

			form.addInput(text);
		}
	}

	private void radioHelper(Form form, NodeList radioList) {
		int len = radioList.getLength();
		for (int i = 0; i < len; ++i) {
			Node radioNode = radioList.item(i);

			RadioInput radio = new RadioInput();
			radio.setName(radioNode.getAttributes().getNamedItem("name").getTextContent());
			List<RadioChoice> radioChoices = new Stack<RadioChoice>();

			NodeList choices = radioNode.getChildNodes();
			int choiceLen = choices.getLength();

			for (int j = 0; j < choiceLen; ++j) {
				Node choiceNode = choices.item(j);

				if (choiceNode.getNodeType() != Node.ELEMENT_NODE) {
					continue;
				}

				RadioChoice radioChoice = new RadioChoice();

				NamedNodeMap att = choiceNode.getAttributes();
				radioChoice.setX(Integer.parseInt(att.getNamedItem("x").getTextContent()));
				radioChoice.setY(Integer.parseInt(att.getNamedItem("y").getTextContent()));
				radioChoice.setValue(att.getNamedItem("value").getTextContent());

				radioChoices.add(radioChoice);
			}

			radio.setChoices(radioChoices);
			form.addInput(radio);
		}
	}
}
