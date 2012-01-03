/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * QuestionPanel.java
 *
 * Created on 01 3, 12, 10:48:58 AM
 */
package com.jericbryledy.whirlpool.app;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class QuestionPanel extends java.awt.Panel {

	private BufferedImage background;

	/** Creates new form QuestionPanel */
	public QuestionPanel() {
		initComponents();
	}

	@Override
	public void paint(Graphics g) {
		if (background != null) {
			g.drawImage(background, 0, 0, null);
		}

		super.paint(g);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

	public void setBackground(BufferedImage background) {
		this.background = background;
		Dimension imageSize = new Dimension(background.getWidth(), background.getHeight());
		setupSize(imageSize);
	}

	private void setupSize(Dimension dim) {
		setPreferredSize(dim);
		setSize(dim);
	}

	public void clear() {
		background = null;
		setupSize(new Dimension(1, 1));
	}
}
