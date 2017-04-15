package com.deccanherald.response;

/**
 * aspire-api
 * com.aspirecloud.app.web BaseResponse.java
 * -------------------------------------------------------------------------
 * 
 *
 * @author Rejish Radhakrishnan
 * @version 1.0
 * @since 02-Nov-2016
 */

/**
 * <Code modification record>
 * 
 * <pre>
 * No.	Modified by (ID) 	  Date (MM DD, YYYY) 	[BUG-ID] 	Description
 * ---------------------------------------------------------------------------- 
 * 1 	Rejish Radhakrishnan  02-Nov-2016	 			-- 		Initial version
 * 
 * </pre>
 */

public class BaseResponse {

	private String errorMessage;

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
