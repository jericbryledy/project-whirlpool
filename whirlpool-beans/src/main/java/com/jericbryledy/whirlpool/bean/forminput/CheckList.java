/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.bean.forminput;

import java.util.List;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class CheckList implements FormInput {

	private String name;
	private CheckInput[] checkList;

	public CheckInput[] getCheckList() {
		return checkList;
	}

	public void setCheckList(CheckInput[] checkList) {
		this.checkList = checkList;
	}

	public void setCheckList(List<CheckInput> coll) {
		CheckInput[] arr = new CheckInput[coll.size()];
		coll.toArray(arr);
		setCheckList(arr);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
