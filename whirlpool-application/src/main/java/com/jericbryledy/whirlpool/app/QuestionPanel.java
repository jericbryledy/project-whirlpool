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

import com.jericbryledy.whirlpool.app.adaptor.CheckAdaptor;
import com.jericbryledy.whirlpool.app.adaptor.InputAdaptor;
import com.jericbryledy.whirlpool.app.adaptor.RadioInputAdaptor;
import com.jericbryledy.whirlpool.app.adaptor.TextInputAdaptor;
import com.jericbryledy.whirlpool.app.gui.WhirlpoolCheckBox;
import com.jericbryledy.whirlpool.app.gui.WhirlpoolRadioButton;
import com.jericbryledy.whirlpool.bean.AnswerKey;
import com.jericbryledy.whirlpool.bean.Question;
import com.jericbryledy.whirlpool.bean.forminput.CheckInput;
import com.jericbryledy.whirlpool.bean.forminput.CheckList;
import com.jericbryledy.whirlpool.bean.forminput.FormInput;
import com.jericbryledy.whirlpool.bean.forminput.RadioChoice;
import com.jericbryledy.whirlpool.bean.forminput.RadioInput;
import com.jericbryledy.whirlpool.bean.forminput.TextInput;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class QuestionPanel extends java.awt.Panel {

	private List<InputAdaptor> inputAdaptors;
	private BufferedImage background;

	/** Creates new form QuestionPanel */
	public QuestionPanel() {
		inputAdaptors = new Stack<InputAdaptor>();
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
		inputAdaptors.clear();
		removeAll();
	}

	public void setup(Question question) {
		clear();

		try {
			BufferedImage image = ImageIO.read(new File(question.getImage()));
			setBackground(image);
		} catch (IOException ex) {
			Logger.getLogger(WhirlpoolWindow.class.getName()).log(Level.SEVERE, null, ex);
		}

		FormInput[] formInputs = question.getForm().getInputs();
		for (FormInput input : formInputs) {
			InputAdaptor adaptor = null;
			if (input instanceof TextInput) {
				TextField field = setupTextInput((TextInput) input);
				adaptor = new TextInputAdaptor(input.getName(), field);
			} else if (input instanceof RadioInput) {
				ButtonGroup group = setupRadioInput((RadioInput) input);
				adaptor = new RadioInputAdaptor(input.getName(), group);
			} else if (input instanceof CheckList) {
				List<JCheckBox> list = setupCheckList((CheckList) input);
				adaptor = new CheckAdaptor(input.getName(), list);
			}

			inputAdaptors.add(adaptor);
		}

		repaint();
	}

	private TextField setupTextInput(TextInput text) {
		TextField field = new TextField();

		field.setBounds(text.getX(), text.getY(), 120, 25);
		add(field);

		return field;
	}

	private ButtonGroup setupRadioInput(RadioInput input) {
		ButtonGroup group = new ButtonGroup();

		RadioChoice[] choices = input.getChoices();
		for (RadioChoice choice : choices) {
			JRadioButton radioButton = new WhirlpoolRadioButton(13, 13);
			radioButton.setLocation(choice.getX(), choice.getY());
			radioButton.setActionCommand(choice.getValue());

			add(radioButton);

			group.add(radioButton);
		}

		return group;
	}

	private List<JCheckBox> setupCheckList(CheckList checkList) {
		List<JCheckBox> list = new Stack<JCheckBox>();

		CheckInput[] checks = checkList.getCheckList();
		for (CheckInput input : checks) {
			JCheckBox checkBox = new WhirlpoolCheckBox(13, 13);
			checkBox.setLocation(input.getX(), input.getY());
			checkBox.setActionCommand(input.getValue());

			add(checkBox);

			list.add(checkBox);
		}

		return list;
	}

	/**
	 * 
	 * @param key
	 * @return true if all answers are correct; false otherwise
	 */
	public boolean checkAnswers(AnswerKey key) {
		boolean isPerfect = true;
		Color correctColor = new Color(0.807843137f, 1.0f, 0.847058824f);
		Color incorrectColor = new Color(1.0f, 0.682352941f, 0.662745098f);
		for (InputAdaptor adaptor : inputAdaptors) {
			Component[] comps = adaptor.getComponents();
			if (key.checkAnswer(adaptor.getName(), adaptor.getValue())) {
				for (Component comp : comps) {
					comp.setBackground(correctColor);
				}
			} else {
				for (Component comp : comps) {
					comp.setBackground(incorrectColor);
				}
				isPerfect = false;
			}
		}

		return isPerfect;
	}
}
