package com.cos.bsymWeb.model;


public enum BoardDivision {
	BSFOOD("요리"), BSRESTAURANT("맛집");
	
	private String boardDivision;
	
    private BoardDivision(String boardDivision) { 
        this.boardDivision = boardDivision;
    }

	public String getName() {
		return boardDivision;
	}
    
    
}
