package com.jericbryledy.whirlpool;

import com.jericbryledy.whirlpool.bean.Unit;
import com.jericbryledy.whirlpool.dao.UnitDao;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		Unit[] units = new UnitDao().getAll();

		for (Unit unit : units) {
			System.out.println(unit.getId());
			System.out.println(unit.getName());
		}
	}
}
