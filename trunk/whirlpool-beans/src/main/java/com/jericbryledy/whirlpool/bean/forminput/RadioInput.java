/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.bean.forminput;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class RadioInput implements FormInput {

	private String id;
	private String value;

	public RadioInput(String id) {
		this.id = id;
		value = "";
	}

	public String getInputId() {
		return id;
	}

	public String getINputValue() {
		return value;
	}
}