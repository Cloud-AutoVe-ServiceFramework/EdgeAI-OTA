package kr.re.etri.advcloud.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.re.etri.advcloud.common.annotation.Model;
import kr.re.etri.advcloud.common.base.BaseObject;

@SuppressWarnings("serial")
@Model
public class EdgeSWVO extends BaseObject {

	private int sw_serial = -1;
	private int sw_group = -1;
	private String sw_group_name;
	private int sw_type = -1;
	private String sw_type_name;
	private String sw_manufacturer;
	private String package_id;
	private String sw_id;
	private String sw_version;
	private String sw_name;
	private String file_type;
	private String file_name;
	private String creation_datetime;
	private long file_size = -1;
	private String file_location;
	private String install_location;
	private int install_os = -1;
	private String install_os_name;
	private List<MultipartFile> files;
	private boolean newest_version = false;
	private String sw_serial_list;
	private int archive_type = -1;
	private boolean hmac = false;
	private String user_id;

	/**
	 * @return the sw_serial
	 */
	public int getSw_serial() {
		return sw_serial;
	}

	/**
	 * @param sw_serial the sw_serial to set
	 */
	public void setSw_serial(int sw_serial) {
		this.sw_serial = sw_serial;
	}

	/**
	 * @return the sw_group
	 */
	public int getSw_group() {
		return sw_group;
	}

	/**
	 * @param sw_group the sw_group to set
	 */
	public void setSw_group(int sw_group) {
		this.sw_group = sw_group;
	}

	/**
	 * @return the sw_group_name
	 */
	public String getSw_group_name() {
		return sw_group_name;
	}

	/**
	 * @param sw_group_name the sw_group_name to set
	 */
	public void setSw_group_name(String sw_group_name) {
		this.sw_group_name = sw_group_name;
	}

	/**
	 * @return the sw_type
	 */
	public int getSw_type() {
		return sw_type;
	}

	/**
	 * @param sw_type the sw_type to set
	 */
	public void setSw_type(int sw_type) {
		this.sw_type = sw_type;
	}

	/**
	 * @return the sw_type_name
	 */
	public String getSw_type_name() {
		return sw_type_name;
	}

	/**
	 * @param sw_type_name the sw_type_name to set
	 */
	public void setSw_type_name(String sw_type_name) {
		this.sw_type_name = sw_type_name;
	}

	/**
	 * @return the sw_manufacturer
	 */
	public String getSw_manufacturer() {
		return sw_manufacturer;
	}

	/**
	 * @param sw_manufacturer the sw_manufacturer to set
	 */
	public void setSw_manufacturer(String sw_manufacturer) {
		this.sw_manufacturer = sw_manufacturer;
	}

	/**
	 * @return the package_id
	 */
	public String getPackage_id() {
		return package_id;
	}

	/**
	 * @param package_id the package_id to set
	 */
	public void setPackage_id(String package_id) {
		this.package_id = package_id;
	}

	/**
	 * @return the sw_id
	 */
	public String getSw_id() {
		return sw_id;
	}

	/**
	 * @param sw_id the sw_id to set
	 */
	public void setSw_id(String sw_id) {
		this.sw_id = sw_id;
	}

	/**
	 * @return the sw_version
	 */
	public String getSw_version() {
		return sw_version;
	}

	/**
	 * @param sw_version the sw_version to set
	 */
	public void setSw_version(String sw_version) {
		this.sw_version = sw_version;
	}

	/**
	 * @return the sw_name
	 */
	public String getSw_name() {
		return sw_name;
	}

	/**
	 * @param sw_name the sw_name to set
	 */
	public void setSw_name(String sw_name) {
		this.sw_name = sw_name;
	}

	/**
	 * @return the file_type
	 */
	public String getFile_type() {
		return file_type;
	}

	/**
	 * @param file_type the file_type to set
	 */
	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	/**
	 * @return the file_name
	 */
	public String getFile_name() {
		return file_name;
	}

	/**
	 * @param file_name the file_name to set
	 */
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	/**
	 * @return the creation_datetime
	 */
	public String getCreation_datetime() {
		return creation_datetime;
	}

	/**
	 * @param creation_datetime the creation_datetime to set
	 */
	public void setCreation_datetime(String creation_datetime) {
		this.creation_datetime = creation_datetime;
	}

	/**
	 * @return the file_size
	 */
	public long getFile_size() {
		return file_size;
	}

	/**
	 * @param file_size the file_size to set
	 */
	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}

	/**
	 * @return the file_location
	 */
	public String getFile_location() {
		return file_location;
	}

	/**
	 * @param file_location the file_location to set
	 */
	public void setFile_location(String file_location) {
		this.file_location = file_location;
	}

	/**
	 * @return the install_location
	 */
	public String getInstall_location() {
		return install_location;
	}

	/**
	 * @param install_location the install_location to set
	 */
	public void setInstall_location(String install_location) {
		this.install_location = install_location;
	}
	
	/**
	 * @return the install_os
	 */
	public int getInstall_os() {
		return install_os;
	}

	/**
	 * @param install_os the install_os to set
	 */
	public void setInstall_os(int install_os) {
		this.install_os = install_os;
	}

	/**
	 * @return the install_os_name
	 */
	public String getInstall_os_name() {
		return install_os_name;
	}

	/**
	 * @param install_os_name the install_os_name to set
	 */
	public void setInstall_os_name(String install_os_name) {
		this.install_os_name = install_os_name;
	}

	/**
	 * @return the files
	 */
	public List<MultipartFile> getFiles() {
		return files;
	}

	/**
	 * @param files the files to set
	 */
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	/**
	 * @return the newest_version
	 */
	public boolean isNewest_version() {
		return newest_version;
	}

	/**
	 * @param newest_version the newest_version to set
	 */
	public void setNewest_version(boolean newest_version) {
		this.newest_version = newest_version;
	}

	/**
	 * @return the sw_serial_list
	 */
	public String getSw_serial_list() {
		return sw_serial_list;
	}

	/**
	 * @param sw_serial_list the sw_serial_list to set
	 */
	public void setSw_serial_list(String sw_serial_list) {
		this.sw_serial_list = sw_serial_list;
	}

	/**
	 * @return the archive_type
	 */
	public int getArchive_type() {
		return archive_type;
	}

	/**
	 * @param archive_type the archive_type to set
	 */
	public void setArchive_type(int archive_type) {
		this.archive_type = archive_type;
	}

	/**
	 * @return the hmac
	 */
	public boolean isHmac() {
		return hmac;
	}

	/**
	 * @param hmac the hmac to set
	 */
	public void setHmac(boolean hmac) {
		this.hmac = hmac;
	}

	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}
