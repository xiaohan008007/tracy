/*
 * filename:  AppException.java
 * Title: 	  PureInfo 身份服务器
 * Copyright: Copyright (c) 2004-2005, PureInfo信息技术有限公司. All rights reserved.
 * License:   see the license file.
 * Company:   PureInfo信息技术有限公司(www.pureinfo.com.cn)
 * 
 * Created on 2009-11-11
 */

package ch.ethz.ssh2.remote;

/**
 * 业务异常处理
 * @author vegas
 *
 */
public class AppException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5832216831397475164L;
	
	 
	
	public AppException(String msg) {
		super(msg);
	}
	
 
	
	public AppException(String msg, Throwable t) {
		super(msg, t);
	}
	
}
