package com.marcnazarian.android.planningpoker;

import java.util.ArrayList;

public class StoryPoint {

	private double value;
	private String label; 
	
	public StoryPoint(String label, double value) {
		this.label = label;
		this.value = value;
	}
	
	public double getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}

	public static ArrayList<StoryPoint> getAvailableStoryPoints() {
		ArrayList<StoryPoint> storyPoints = new ArrayList<StoryPoint>();
		storyPoints.add(new StoryPoint("0", 0));
		storyPoints.add(new StoryPoint("1/2", 0.5));
		storyPoints.add(new StoryPoint("1", 1));
		storyPoints.add(new StoryPoint("2", 2));
		storyPoints.add(new StoryPoint("3", 3));
		storyPoints.add(new StoryPoint("5", 5));
		storyPoints.add(new StoryPoint("8", 8));
		storyPoints.add(new StoryPoint("13", 13));
		storyPoints.add(new StoryPoint("20", 20));
		storyPoints.add(new StoryPoint("40", 40));
		storyPoints.add(new StoryPoint("100", 100));
		storyPoints.add(new StoryPoint("?", Double.NaN));
		return storyPoints;
	}
}