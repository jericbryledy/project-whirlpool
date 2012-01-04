/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.app.gui;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JCheckBox;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class WhirlpoolCheckboxIcon implements Icon {

	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(c.getBackground());
		g.fillRoundRect(x + 2, y + 2, 13, 13, 5, 5);
		g.setColor(c.getForeground());
		g.drawRoundRect(x + 2, y + 2, 13, 13, 5, 5);

		if (((JCheckBox) c).isSelected()) {
			g.drawString("\u2714", x + 3, y + 15);
		}
	}

	public int getIconWidth() {
		return 16;
	}

	public int getIconHeight() {
		return 16;
	}
}
