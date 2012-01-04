/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.app.gui;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JRadioButton;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class WhirlpoolRadioIcon implements Icon {

	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(c.getBackground());
		g.fillOval(x + 2, y + 2, 13, 13);
		g.setColor(c.getForeground());
		g.drawOval(x + 2, y + 2, 13, 13);

		if (((JRadioButton) c).isSelected()) {
			g.fillOval(x + 5, y + 5, 7, 7);
		}
	}

	public int getIconWidth() {
		return 16;
	}

	public int getIconHeight() {
		return 16;
	}
}
