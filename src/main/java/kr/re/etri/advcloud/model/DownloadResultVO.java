package kr.re.etri.advcloud.model;

import java.util.List;
import java.util.Map;

import kr.re.etri.advcloud.common.annotation.Model;
import kr.re.etri.advcloud.common.base.BaseObject;

@SuppressWarnings("serial")
@Model
public class DownloadResultVO extends BaseObject {

	private String userid;
	private String type;
	private Map<String, Object> parameter;
	List<Map<String, Object>> downloadResultList;

	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the parameter
	 */
	public Map<String, Object> getParameter() {
		return parameter;
	}

	/**
	 * @param parameter the parameter to set
	 */
	public void setParameter(Map<String, Object> parameter) {
		this.parameter = parameter;
	}

	/**
	 * @return the downloadResultList
	 */
	public List<Map<String, Object>> getDownloadResultList() {
		return downloadResultList;
	}

	/**
	 * @param downloadResultList the downloadResultList to set
	 */
	public void setDownloadResultList(List<Map<String, Object>> downloadResultList) {
		this.downloadResultList = downloadResultList;
	}

}
