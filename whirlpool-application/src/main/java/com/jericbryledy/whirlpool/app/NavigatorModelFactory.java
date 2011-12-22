/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.app;

import com.jericbryledy.whirlpool.bean.EClass;
import com.jericbryledy.whirlpool.bean.Lecture;
import com.jericbryledy.whirlpool.bean.Unit;
import com.jericbryledy.whirlpool.dao.EClassDao;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class NavigatorModelFactory {

	public TreeModel generate() {
		EClassDao dao = new EClassDao();

		EClass eclass = dao.getEClass();

		DefaultMutableTreeNode classNode = new DefaultMutableTreeNode();
		classNode.setUserObject(eclass);

		Unit[] units = eclass.getUnits();
		for (Unit unit : units) {
			DefaultMutableTreeNode unitNode = new DefaultMutableTreeNode(unit);
			classNode.add(unitNode);

			Lecture[] lectures = unit.getLectures();
			for (Lecture lecture : lectures) {
				DefaultMutableTreeNode lectureNode = new DefaultMutableTreeNode(lecture);
				unitNode.add(lectureNode);
			}
		}

		return new DefaultTreeModel(classNode);
	}
}
