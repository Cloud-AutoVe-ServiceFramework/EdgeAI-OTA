package kr.re.etri.advcloud.model;

import kr.re.etri.advcloud.common.annotation.Model;
import kr.re.etri.advcloud.common.base.BaseObject;

@SuppressWarnings("serial")
@Model
public class EdgeInfoVO extends BaseObject {

	private String location_number;
	private String edge_id;
	private String user_info_id;
	private String edgesw_package_id;
	private String loc_latitude;
	private String loc_longitude;

	/**
	 * @return the location_number
	 */
	public String getLocation_number() {
		return location_number;
	}

	/**
	 * @param location_number the location_number to set
	 */
	public void setLocation_number(String location_number) {
		this.location_number = location_number;
	}

	/**
	 * @return the edge_id
	 */
	public String getEdge_id() {
		return edge_id;
	}

	/**
	 * @param edge_id the edge_id to set
	 */
	public void setEdge_id(String edge_id) {
		this.edge_id = edge_id;
	}

	/**
	 * @return the user_info_id
	 */
	public String getUser_info_id() {
		return user_info_id;
	}

	/**
	 * @param user_info_id the user_info_id to set
	 */
	public void setUser_info_id(String user_info_id) {
		this.user_info_id = user_info_id;
	}

	/**
	 * @return the edgesw_package_id
	 */
	public String getEdgesw_package_id() {
		return edgesw_package_id;
	}

	/**
	 * @param edgesw_package_id the edgesw_package_id to set
	 */
	public void setEdgesw_package_id(String edgesw_package_id) {
		this.edgesw_package_id = edgesw_package_id;
	}

	/**
	 * @return the loc_latitude
	 */
	public String getLoc_latitude() {
		return loc_latitude;
	}

	/**
	 * @param loc_latitude the loc_latitude to set
	 */
	public void setLoc_latitude(String loc_latitude) {
		this.loc_latitude = loc_latitude;
	}

	/**
	 * @return the loc_longitude
	 */
	public String getLoc_longitude() {
		return loc_longitude;
	}

	/**
	 * @param loc_longitude the loc_longitude to set
	 */
	public void setLoc_longitude(String loc_longitude) {
		this.loc_longitude = loc_longitude;
	}

}
