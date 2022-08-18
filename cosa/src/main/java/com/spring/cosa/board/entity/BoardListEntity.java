package com.spring.cosa.board.entity;

public class BoardListEntity {
	
	private int i_board_list;
	private String board_list_nm;
	private int board_list_id;
	public int getI_board_list() {
		return i_board_list;
	}
	public String getBoard_list_nm() {
		return board_list_nm;
	}
	public int getBoard_list_id() {
		return board_list_id;
	}
	public int getBoard_list_order() {
		return board_list_order;
	}
	public void setI_board_list(int i_board_list) {
		this.i_board_list = i_board_list;
	}
	public void setBoard_list_nm(String board_list_nm) {
		this.board_list_nm = board_list_nm;
	}
	public void setBoard_list_id(int board_list_id) {
		this.board_list_id = board_list_id;
	}
	public void setBoard_list_order(int board_list_order) {
		this.board_list_order = board_list_order;
	}
	private int board_list_order;
}
