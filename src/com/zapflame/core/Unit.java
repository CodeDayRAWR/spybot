package com.zapflame.core;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Unit {
	public ArrayList<Affect> affects;
	public int moveRate, maxSize;
	public UUID uid;
	public Player owner;
	public String name, description;
	List<Cell> sectors;

}
