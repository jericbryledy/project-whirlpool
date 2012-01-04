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

	private int iconWidth;
	private int iconHeight;

	public WhirlpoolRadioIcon() {
	}

	public WhirlpoolRadioIcon(int iconWidth, int iconHeight) {
		this.iconWidth = iconWidth;
		this.iconHeight = iconHeight;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		int drawWidth = getIconWidth() - 1;
		int drawHeight = getIconHeight() - 1;

		g.setColor(c.getBackground());
		g.fillOval(0, 0, drawWidth, drawHeight);
		g.setColor(c.getForeground());
		g.drawOval(0, 0, drawWidth, drawHeight);

		if (((JRadioButton) c).isSelected()) {
			int halfWidth = iconWidth / 2;
			int halfHeight = iconHeight / 2;
			int fourthWidth = iconWidth / 4;
			int fourthHeight = iconHeight / 4;
			g.fillOval(fourthWidth, fourthHeight, halfWidth, halfHeight);
		}
	}

	public int getIconWidth() {
		return iconWidth;
	}

	public void setIconWidth(int iconWidth) {
		this.iconWidth = iconWidth;
	}

	public int getIconHeight() {
		return iconHeight;
	}

	public void setIconHeight(int iconHeight) {
		this.iconHeight = iconHeight;
	}
}
