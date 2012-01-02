/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.bean;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class Unit implements WhirlpoolTreeItem {

	private String id;
	private String name;
	private Lecture[] lectures;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Lecture[] getLectures() {
		return lectures;
	}

	public void setLectures(Lecture[] lectures) {
		this.lectures = lectures;
	}

	@Override
	public String toString() {
		return getName();
	}

	public String getItemName() {
		return getName();
	}

	public String getItemValue() {
		return null;
	}
}
