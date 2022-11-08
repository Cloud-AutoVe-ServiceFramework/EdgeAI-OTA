package kr.re.etri.advcloud.model;

import kr.re.etri.advcloud.common.annotation.Model;
import kr.re.etri.advcloud.common.base.BaseObject;

@SuppressWarnings("serial")
@Model
public class UserInfoVO extends BaseObject {
	
	private String id;
	private String password;
	private String name;
	private String register_date;
	private int manage_vehicle_count = -1;
	private int manage_edge_count = -1;

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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the register_date
	 */
	public String getRegister_date() {
		return register_date;
	}

	/**
	 * @param register_date the register_date to set
	 */
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}

	/**
	 * @return the manage_vehicle_count
	 */
	public int getManage_vehicle_count() {
		return manage_vehicle_count;
	}

	/**
	 * @param manage_vehicle_count the manage_vehicle_count to set
	 */
	public void setManage_vehicle_count(int manage_vehicle_count) {
		this.manage_vehicle_count = manage_vehicle_count;
	}

	/**
	 * @return the manage_edge_count
	 */
	public int getManage_edge_count() {
		return manage_edge_count;
	}

	/**
	 * @param manage_edge_count the manage_edge_count to set
	 */
	public void setManage_edge_count(int manage_edge_count) {
		this.manage_edge_count = manage_edge_count;
	}

}
