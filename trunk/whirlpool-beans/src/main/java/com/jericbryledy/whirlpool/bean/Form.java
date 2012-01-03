/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jericbryledy.whirlpool.bean;

import com.jericbryledy.whirlpool.bean.forminput.FormInput;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Jeric Bryle Sy Dy
 */
public class Form {

	private HashMap<String, FormInput> inputs;

	public Form() {
		inputs = new HashMap<String, FormInput>();
	}

	public void addInput(FormInput input) {
		inputs.put(input.getName(), input);
	}

	public FormInput getInput(String name) {
		return inputs.get(name);
	}

	public void clear() {
		inputs.clear();
	}

	public FormInput[] getInputs() {
		Collection<FormInput> values = inputs.values();

		FormInput[] arr = new FormInput[values.size()];
		values.toArray(arr);

		return arr;
	}

	public void setInputs(FormInput[] inputs) {
		clear();
		for (FormInput input : inputs) {
			addInput(input);
		}
	}
}
