/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.app.gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JCheckBox;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class WhirlpoolCheckboxIcon implements Icon {

	private int iconWidth;
	private int iconHeight;

	public WhirlpoolCheckboxIcon() {
	}

	public WhirlpoolCheckboxIcon(int iconWidth, int iconHeight) {
		this.iconWidth = iconWidth;
		this.iconHeight = iconHeight;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		int drawWidth = getIconWidth() - 1;
		int drawHeight = getIconHeight() - 1;
		int fourthWidth = iconWidth / 4;
		int fourthHeight = iconHeight / 4;
		g.setColor(c.getBackground());
		g.fill3DRect(0, 0, drawWidth, drawHeight, true);
		g.setColor(c.getForeground());
		g.draw3DRect(0, 0, drawWidth, drawHeight, true);

		if (((JCheckBox) c).isSelected()) {
			g.setFont(new Font(null, Font.PLAIN, drawHeight));
			g.drawString("\u2714", fourthWidth / 2, drawHeight - fourthHeight / 2);
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
