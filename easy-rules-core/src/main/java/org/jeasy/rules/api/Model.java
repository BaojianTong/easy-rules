package org.jeasy.rules.api;

public enum Model {
	All("run all rule"), 
	NON_All("stoped at first return false rule");
	
	private String description = "" ; 
	
	private  Model(String desc) {
		this.description = desc ;
	}
	
}
