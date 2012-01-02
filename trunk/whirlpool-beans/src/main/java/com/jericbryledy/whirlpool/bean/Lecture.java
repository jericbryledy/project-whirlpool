/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.bean;

/**
 * each lecture may have questions, but this class ignores the questions
 * in order to save up memory in large lectures/classes
 * 
 * @author Jeric Bryle Sy Dy
 */
public class Lecture implements WhirlpoolTreeItem {

	private String id;
	private String name;
	private String video;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the video
	 */
	public String getVideo() {
		return video;
	}

	/**
	 * @param video the video to set
	 */
	public void setVideo(String video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return getName();
	}

	public String getItemName() {
		return getName();
	}

	public String getItemValue() {
		return getVideo();
	}
}
