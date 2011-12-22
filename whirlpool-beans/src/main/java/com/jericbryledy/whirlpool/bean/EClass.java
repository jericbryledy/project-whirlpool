/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.bean;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class EClass {

	private String name;
	private Unit[] units;

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
	 * @return the units
	 */
	public Unit[] getUnits() {
		return units;
	}

	/**
	 * @param units the units to set
	 */
	public void setUnits(Unit[] units) {
		this.units = units;
	}

	@Override
	public String toString() {
		return getName();
	}
}
