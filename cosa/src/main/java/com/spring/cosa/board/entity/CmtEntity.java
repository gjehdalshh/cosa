package com.spring.cosa.board.entity;

public class CmtEntity {
	private int i_cmt;
	private int i_user;
	private int i_board;
	private String cmt_ctnt;
	private int cmd_id;
	private int cmd_order;
	public int getI_cmt() {
		return i_cmt;
	}
	public int getI_user() {
		return i_user;
	}
	public int getI_board() {
		return i_board;
	}
	public String getCmt_ctnt() {
		return cmt_ctnt;
	}
	public int getCmd_id() {
		return cmd_id;
	}
	public int getCmd_order() {
		return cmd_order;
	}
	public int getCmt_secret_state() {
		return cmt_secret_state;
	}
	public void setI_cmt(int i_cmt) {
		this.i_cmt = i_cmt;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public void setI_board(int i_board) {
		this.i_board = i_board;
	}
	public void setCmt_ctnt(String cmt_ctnt) {
		this.cmt_ctnt = cmt_ctnt;
	}
	public void setCmd_id(int cmd_id) {
		this.cmd_id = cmd_id;
	}
	public void setCmd_order(int cmd_order) {
		this.cmd_order = cmd_order;
	}
	public void setCmt_secret_state(int cmt_secret_state) {
		this.cmt_secret_state = cmt_secret_state;
	}
	private int cmt_secret_state;
}
