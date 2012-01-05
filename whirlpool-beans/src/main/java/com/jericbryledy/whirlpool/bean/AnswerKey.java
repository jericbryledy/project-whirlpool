/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.bean;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class AnswerKey {

	private HashMap<String, String> answers;

	public AnswerKey() {
		answers = new HashMap<String, String>();
	}

	public void addCorrectAnswer(String id, String answer) {
		answers.put(id, answer);
	}

	public boolean checkAnswer(String id, String checkAnswer) {
		boolean isCorrect = false;
		String correctAnswer = answers.get(id);

		if (correctAnswer != null && checkAnswer != null) {
			String[] correctArr = correctAnswer.split("\\W+");
			String[] checkArr = checkAnswer.split("\\W+");

			Arrays.sort(correctArr);
			Arrays.sort(checkArr);

			isCorrect = Arrays.equals(correctArr, checkArr);
		}

		return isCorrect;
	}
}
