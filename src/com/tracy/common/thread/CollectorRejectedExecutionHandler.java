package com.tracy.common.thread;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class CollectorRejectedExecutionHandler implements RejectedExecutionHandler {


	public CollectorRejectedExecutionHandler() {
	}

	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("error======================");
		throw new RejectedExecutionException("reject adding thread to pool");
	}

}
