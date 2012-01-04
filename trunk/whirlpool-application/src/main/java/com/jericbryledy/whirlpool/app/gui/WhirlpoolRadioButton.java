/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.app.gui;

import java.awt.Color;
import javax.swing.JRadioButton;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class WhirlpoolRadioButton extends JRadioButton {

	public WhirlpoolRadioButton(int width, int height) {
		super(new WhirlpoolRadioIcon(width, height));
		setBackground(Color.WHITE);
		setSize(width, height);
	}
}
