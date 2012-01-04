/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.app.gui;

import java.awt.Color;
import javax.swing.JCheckBox;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class WhirlpoolCheckBox extends JCheckBox {

	public WhirlpoolCheckBox() {
		super(new WhirlpoolCheckboxIcon());
		setBackground(Color.WHITE);
	}
}
