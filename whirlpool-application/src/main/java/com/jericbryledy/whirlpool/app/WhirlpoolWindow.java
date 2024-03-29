/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * WhirlpoolWindow.java
 *
 * Created on Dec 22, 2011, 11:29:55 PM
 */
package com.jericbryledy.whirlpool.app;

import com.jericbryledy.whirlpool.bean.Question;
import com.jericbryledy.whirlpool.bean.WhirlpoolTreeItem;
import com.jericbryledy.whirlpool.dao.AnswerDao;
import com.jericbryledy.whirlpool.dao.QuestionDao;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class WhirlpoolWindow extends javax.swing.JFrame {

	private QuestionDao questionDao;
	private AnswerDao answerDao;
	private WhirlpoolTreeItem curTreeItem;
	private String curLectureVideoPath;
	private Question curQuestion;

	public WhirlpoolWindow() {
		questionDao = new QuestionDao();
		answerDao = new AnswerDao();

		initComponents();
		navigator.addTreeSelectionListener(new TreeSelectionListener() {

			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
				if (node.getUserObject() instanceof WhirlpoolTreeItem) {
					curTreeItem = (WhirlpoolTreeItem) node.getUserObject();
					String selectedVideoPath = curTreeItem.getItemValue();
					hideProblem();
					setVideoPath(selectedVideoPath);
				}
			}
		});
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        navigator = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        launchVideoButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        videoPathLabel = new javax.swing.JLabel();
        displayProblemButton = new javax.swing.JToggleButton();
        questionPane = new com.jericbryledy.whirlpool.app.QuestionPanel();
        doneButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        explanationButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        aboutItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Whirlpool eLearning");

        jSplitPane1.setDividerLocation(200);

        navigator.setModel(new com.jericbryledy.whirlpool.app.NavigatorModelFactory().generate());
        jScrollPane1.setViewportView(navigator);

        jSplitPane1.setLeftComponent(jScrollPane1);

        launchVideoButton.setText("Launch Video");
        launchVideoButton.setEnabled(false);
        launchVideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                launchVideoButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("file:");

        displayProblemButton.setText("Display Problem");
        displayProblemButton.setEnabled(false);
        displayProblemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayProblemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout questionPaneLayout = new javax.swing.GroupLayout(questionPane);
        questionPane.setLayout(questionPaneLayout);
        questionPaneLayout.setHorizontalGroup(
            questionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        questionPaneLayout.setVerticalGroup(
            questionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        doneButton.setText("Done");
        doneButton.setEnabled(false);
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.setEnabled(false);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        explanationButton.setText("Explanation");
        explanationButton.setEnabled(false);
        explanationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                explanationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(launchVideoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(videoPathLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(displayProblemButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doneButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(explanationButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton))
                    .addComponent(questionPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(469, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(launchVideoButton)
                    .addComponent(jLabel1)
                    .addComponent(videoPathLabel))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayProblemButton)
                    .addComponent(doneButton)
                    .addComponent(explanationButton)
                    .addComponent(nextButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(questionPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(386, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        jSplitPane1.setRightComponent(jScrollPane2);

        jMenu1.setText("Help");

        aboutItem.setText("About");
        aboutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutItemActionPerformed(evt);
            }
        });
        jMenu1.add(aboutItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void launchVideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchVideoButtonActionPerformed
		launchVideo(getLectureVideoPath());
	}//GEN-LAST:event_launchVideoButtonActionPerformed

	private void displayProblemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayProblemButtonActionPerformed
		if (displayProblemButton.isSelected()) {
			showProblem();
		} else {
			hideProblem();
		}
	}//GEN-LAST:event_displayProblemButtonActionPerformed

	private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
		boolean isPerfect = questionPane.checkAnswers(answerDao.getByLectureId(curTreeItem.getItemId()));
		if (isPerfect) {
			nextButton.setEnabled(true);
		}
		if (curQuestion.getExplanation() != null) {
			explanationButton.setEnabled(true);
		}
	}//GEN-LAST:event_doneButtonActionPerformed

	private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
		traverseToNextLecture();
	}//GEN-LAST:event_nextButtonActionPerformed

	private void explanationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_explanationButtonActionPerformed
		launchVideo(getExplanationVideoPath());
	}//GEN-LAST:event_explanationButtonActionPerformed

private void aboutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutItemActionPerformed
	JOptionPane.showMessageDialog(this,
			"Version: 1.0\n"
			+ "Author: Jeric Bryle Dy\n"
			+ "Website: http://www.jericbryledy.com\n"
			+ "Contact: http://www.jericbryledy.com/contact-me", "About", JOptionPane.INFORMATION_MESSAGE);
}//GEN-LAST:event_aboutItemActionPerformed

	private void setVideoPath(String videoPath) {
		curLectureVideoPath = videoPath;
		if (videoPath == null) {
			videoPathLabel.setText("");
			launchVideoButton.setEnabled(false);
		} else {
			videoPathLabel.setText(videoPath);
			launchVideoButton.setEnabled(true);
			curQuestion = questionDao.getByLectureId(curTreeItem.getItemId());
			displayProblemButton.setSelected(false);
			explanationButton.setEnabled(false);

			if (curQuestion != null) {
				displayProblemButton.setEnabled(true);
				nextButton.setEnabled(false);
			} else {
				displayProblemButton.setEnabled(false);
				nextButton.setEnabled(true);
			}
		}
	}

	private String getLectureVideoPath() {
		return curLectureVideoPath;
	}

	private String getExplanationVideoPath() {
		return curQuestion.getExplanation();
	}

	private void showProblem() {
		if (questionPane.setup(curQuestion)) {
			doneButton.setEnabled(true);
		} else {
			JOptionPane.showMessageDialog(this, "File not found: " + curQuestion.getImage());
		}
	}

	private void hideProblem() {
		questionPane.clear();
		doneButton.setEnabled(false);
	}

	private void traverseToNextLecture() {
		TreeModel model = navigator.getModel();
		TreePath selectedPath = navigator.getSelectionPath();
		TreePath parentPath = selectedPath.getParentPath();
		TreeNode selectedNode = (TreeNode) selectedPath.getLastPathComponent();
		TreeNode parentNode = (TreeNode) parentPath.getLastPathComponent();
		int curIndex = model.getIndexOfChild(parentNode, selectedNode);
		int siblingsCnt = model.getChildCount(parentNode);

		// next sibling
		if (curIndex + 1 < siblingsCnt) {
			TreeNode nextNode = (TreeNode) model.getChild(parentNode, curIndex + 1);
			Object[] arrPath = selectedPath.getPath();
			arrPath[arrPath.length - 1] = nextNode;
			navigator.setSelectionPath(new TreePath(arrPath));
		} else {
			// next cousin
			TreePath grandParentPath = parentPath.getParentPath();
			TreeNode grandParentNode = (TreeNode) grandParentPath.getLastPathComponent();
			int parentIndex = model.getIndexOfChild(grandParentNode, parentNode);
			int parentsSiblingsCnt = model.getChildCount(grandParentNode);

			if (parentIndex + 1 < parentsSiblingsCnt) {
				TreeNode nextParentSiblingNode = (TreeNode) model.getChild(grandParentNode, parentIndex + 1);
				if (model.getChildCount(nextParentSiblingNode) > 0) {
					TreeNode nextCousinNode = (TreeNode) model.getChild(nextParentSiblingNode, 0);
					Object[] arrPath = selectedPath.getPath();
					arrPath[arrPath.length - 2] = nextParentSiblingNode;
					arrPath[arrPath.length - 1] = nextCousinNode;

					navigator.setSelectionPath(new TreePath(arrPath));
				}
			}
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			java.util.logging.Logger.getLogger(WhirlpoolWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				new WhirlpoolWindow().setVisible(true);
			}
		});
	}

	private void launchVideo(String videoPath) {
		// no idea how to make mp4 files work with JMF (downloaded videos from youtube are mp4)
		// maybe convert mp4 into supported format instead?
		// or open with system/local media player?
//		Player player = Manager.createPlayer(new URL("file", null, curVideoPath.replaceAll(" ", "%20")));
//		player.start();
		try {
			Desktop.getDesktop().open(new File(videoPath));
		} catch (IOException ex) {
//			JOptionPane.showMessageDialog(this, "No file associated with " + videoPath.substring(videoPath.lastIndexOf(".") + 1) + " format");
			// apparently there's a bug in Desktop.open(), will not work with some OS
			// (http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6780505)
			// quick fix:
			if (System.getProperty("os.name").toLowerCase().contains("windows")) {
				try {
					Runtime.getRuntime().exec(new String[]{"rundll32", "url.dll,FileProtocolHandler", new File(videoPath).getAbsolutePath()});
				} catch (IOException ex1) {
					JOptionPane.showMessageDialog(this, "No file associated with " + videoPath.substring(videoPath.lastIndexOf(".") + 1) + " format");
				}
			} else {
				JOptionPane.showMessageDialog(this, "No file associated with " + videoPath.substring(videoPath.lastIndexOf(".") + 1) + " format");
			}
		} catch (IllegalArgumentException ex) {
			JOptionPane.showMessageDialog(this, "File not found: " + videoPath);
		}
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutItem;
    private javax.swing.JToggleButton displayProblemButton;
    private javax.swing.JButton doneButton;
    private javax.swing.JButton explanationButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton launchVideoButton;
    private javax.swing.JTree navigator;
    private javax.swing.JButton nextButton;
    private com.jericbryledy.whirlpool.app.QuestionPanel questionPane;
    private javax.swing.JLabel videoPathLabel;
    // End of variables declaration//GEN-END:variables
}
