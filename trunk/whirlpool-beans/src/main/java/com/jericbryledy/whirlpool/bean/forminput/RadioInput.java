/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.bean.forminput;

import java.util.Collection;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class RadioInput implements FormInput {

	private String name;
	private RadioChoice[] choices;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RadioChoice[] getChoices() {
		return choices;
	}

	public void setChoices(RadioChoice[] choices) {
		this.choices = choices;
	}

	public void setChoices(Collection<RadioChoice> coll) {
		RadioChoice[] arr = new RadioChoice[coll.size()];
		coll.toArray(arr);
		setChoices(arr);
	}
}
