/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.app.adaptor;

import java.awt.Component;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class RadioInputAdaptor implements InputAdaptor {

	private String name;
	private ButtonGroup group;

	public RadioInputAdaptor() {
	}

	public RadioInputAdaptor(String name, ButtonGroup group) {
		this.name = name;
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ButtonGroup getGroup() {
		return group;
	}

	public void setGroup(ButtonGroup group) {
		this.group = group;
	}

	public String getValue() {
		String value = null;

		if (group.getSelection() != null) {
			value = group.getSelection().getActionCommand();
		}

		return value;
	}

	public Component[] getComponents() {
		int len = group.getButtonCount();
		Component[] arr = new Component[len];
		Enumeration<AbstractButton> en = group.getElements();

		for (int i = 0; i < len; ++i) {
			arr[i] = en.nextElement();
		}

		return arr;
	}
}
