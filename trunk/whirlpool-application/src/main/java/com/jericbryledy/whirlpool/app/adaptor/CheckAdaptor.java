/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.app.adaptor;

import java.awt.Component;
import java.util.List;
import javax.swing.JCheckBox;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class CheckAdaptor implements InputAdaptor {

	private String name;
	private List<JCheckBox> checkList;

	public CheckAdaptor() {
	}

	public CheckAdaptor(String name, List<JCheckBox> checkSet) {
		this.name = name;
		this.checkList = checkSet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		StringBuilder sb = new StringBuilder();

		for (JCheckBox box : checkList) {
			if (box.isSelected()) {
				sb.append(box.getActionCommand());
				sb.append(' ');
			}
		}

		return sb.toString();
	}

	public Component[] getComponents() {
		JCheckBox[] arr = new JCheckBox[checkList.size()];
		checkList.toArray(arr);
		return arr;
	}
}
