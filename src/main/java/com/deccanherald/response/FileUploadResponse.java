package com.deccanherald.response;

import java.util.List;

/**
 * aspire-api
 * com.aspirecloud.app.response FileUploadResponse.java
 * -------------------------------------------------------------------------
 * 
 *
 * @author Rejish Radhakrishnan
 * @version 1.0
 * @since 05-Feb-2017
 */

/**
 * <Code modification record>
 * 
 * <pre>
 * No.	Modified by (ID) 	  Date (MM DD, YYYY) 	[BUG-ID] 	Description
 * ---------------------------------------------------------------------------- 
 * 1 	Rejish Radhakrishnan  05-Feb-2017	 			-- 		Initial version
 * 
 * </pre>
 */

public class FileUploadResponse extends BaseResponse {

	private List<FileInfo> fileInfos;

	/**
	 * @return the fileInfos
	 */
	public List<FileInfo> getFileInfos() {
		return fileInfos;
	}

	/**
	 * @param fileInfos the fileInfos to set
	 */
	public void setFileInfos(List<FileInfo> fileInfos) {
		this.fileInfos = fileInfos;
	}
	
}
