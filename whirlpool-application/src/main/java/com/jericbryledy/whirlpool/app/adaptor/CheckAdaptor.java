/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.app.adaptor;

import javax.swing.JCheckBox;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class CheckAdaptor implements InputAdaptor {

	private String name;
	private JCheckBox checkBox;

	public CheckAdaptor() {
	}

	public CheckAdaptor(String name, JCheckBox checkBox) {
		this.name = name;
		this.checkBox = checkBox;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JCheckBox getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(JCheckBox checkBox) {
		this.checkBox = checkBox;
	}

	public String getValue() {
		return checkBox.isSelected() ? "true" : "false";
	}
}
