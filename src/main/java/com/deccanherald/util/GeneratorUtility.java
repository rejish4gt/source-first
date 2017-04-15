package com.deccanherald.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * aspire-api
 * com.aspirecloud.app.util GeneratorUtility.java
 * -------------------------------------------------------------------------
 * 
 *
 * @author Rejish Radhakrishnan
 * @version 1.0
 * @since 04-Feb-2017
 */

/**
 * <Code modification record>
 * 
 * <pre>
 * No.	Modified by (ID) 	  Date (MM DD, YYYY) 	[BUG-ID] 	Description
 * ---------------------------------------------------------------------------- 
 * 1 	Rejish Radhakrishnan  04-Feb-2017	 			-- 		Initial version
 * 
 * </pre>
 */


@Component
public class GeneratorUtility {

	private static final AtomicLong LAST_TIME_MS = new AtomicLong();

	/**
	 * Utility method to generate name with an id preference
	 * 
	 * @param prefix
	 * @return
	 */
	public static String generateIdWithPrefix(String prefix) {
		long now = System.currentTimeMillis();
		while (true) {
			long lastTime = LAST_TIME_MS.get();
			if (lastTime >= now)
				now = lastTime + 1;
			if (LAST_TIME_MS.compareAndSet(lastTime, now))
				return prefix + now;
		}
	}

	/**
	 * Utility method to generate random file name based on the length and
	 * extension that is passed in
	 * 
	 * @param prefLength
	 *            Preferred length for the file name
	 * @param ext
	 *            Extension of the file name
	 * @return Returns a filename with the length and extension specified
	 */
	public static String generateRandomFileName(int prefLength, String ext) {
		return String.format("%s.%s", RandomStringUtils.randomAlphanumeric(prefLength), ext);
	}
	
	
	/**
	 * Utility method to create a hashed sequence of string from the input data.
	 * This is maninly used for creating the hashcode for payment gateway
	 * 
	 * @param type
	 * @param str
	 * @return
	 */
	public static String hashCal(String type,String str){
		byte[] hashseq=str.getBytes();
		StringBuffer hexString = new StringBuffer();
		try{
		MessageDigest algorithm = MessageDigest.getInstance(type);
		algorithm.reset();
		algorithm.update(hashseq);
		byte messageDigest[] = algorithm.digest();
		
		for (int i=0;i<messageDigest.length;i++) {
			String hex=Integer.toHexString(0xFF & messageDigest[i]);
			if(hex.length()==1) hexString.append("0");
			hexString.append(hex);
		}
			
		}catch(NoSuchAlgorithmException nsae){ }
		
		return hexString.toString();
	}
	
	/**
	 * Utility method to create transaction key for payment gateway trasactions
	 * @return
	 */
	public static String generateTransactionId(){
		String txnid = "";
		Random rand = new Random();
		String rndm = Integer.toString(rand.nextInt())+(System.currentTimeMillis() / 1000L);
		txnid = hashCal("SHA-256",rndm).substring(0,20);
		return txnid;
	}
}

