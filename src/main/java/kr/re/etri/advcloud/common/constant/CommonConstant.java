package kr.re.etri.advcloud.common.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "props.common")
public class CommonConstant {

	private String baseFilePath;

	private String edgeSwPath;


	/**
	 * @return the baseFilePath
	 */
	public String getBaseFilePath() {
		return baseFilePath;
	}

	/**
	 * @param baseFilePath the baseFilePath to set
	 */
	public void setBaseFilePath(String baseFilePath) {
		this.baseFilePath = baseFilePath;
	}



	/**
	 * @return the edgeSwPath
	 */
	public String getEdgeSwPath() {
		return edgeSwPath;
	}

	/**
	 * @param edgeSwPath the edgeSwPath to set
	 */
	public void setEdgeSwPath(String edgeSwPath) {
		this.edgeSwPath = edgeSwPath;
	}

}
