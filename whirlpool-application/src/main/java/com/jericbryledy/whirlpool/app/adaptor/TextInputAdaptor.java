/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.app.adaptor;

import java.awt.TextField;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class TextInputAdaptor implements InputAdaptor {

	private String name;
	private TextField field;

	public TextInputAdaptor() {
	}

	public TextInputAdaptor(String name, TextField field) {
		this.name = name;
		this.field = field;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TextField getField() {
		return field;
	}

	public void setField(TextField field) {
		this.field = field;
	}

	public String getValue() {
		return field.getText();
	}
}
