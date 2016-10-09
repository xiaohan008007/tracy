package com.tracy.common.stringBuffer;

public class TestBufferAndBuilder {
	public static void main(String[] args) {

		String randoms[] = { String.valueOf(Math.random()),
				String.valueOf(Math.random()), String.valueOf(Math.random()),
				String.valueOf(Math.random()), String.valueOf(Math.random()),
				String.valueOf(Math.random()), String.valueOf(Math.random()),
				String.valueOf(Math.random()), String.valueOf(Math.random()),
				String.valueOf(Math.random()) };

		System.gc();
		long d = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(randoms[0]).append(randoms[1]).append(randoms[2])
					.append(randoms[3]).append(randoms[4]).append(randoms[5])
					.append(randoms[6]).append(randoms[7]).append(randoms[8])
					.append(randoms[9]);
		}
		System.err.println(System.currentTimeMillis() - d);
		System.gc();

		d = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			StringBuilder builder = new StringBuilder();
			builder.append(randoms[0]).append(randoms[1]).append(randoms[2])
					.append(randoms[3]).append(randoms[4]).append(randoms[5])
					.append(randoms[6]).append(randoms[7]).append(randoms[8])
					.append(randoms[9]);
		}
		System.err.println(System.currentTimeMillis() - d);

		System.gc();
		d = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			StringBuffer buffer = new StringBuffer(200);
			buffer.append(randoms[0]).append(randoms[1]).append(randoms[2])
					.append(randoms[3]).append(randoms[4]).append(randoms[5])
					.append(randoms[6]).append(randoms[7]).append(randoms[8])
					.append(randoms[9]);
		}
		System.err.println(System.currentTimeMillis() - d);
		System.gc();

		d = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			StringBuilder builder = new StringBuilder(200);
			builder.append(randoms[0]).append(randoms[1]).append(randoms[2])
					.append(randoms[3]).append(randoms[4]).append(randoms[5])
					.append(randoms[6]).append(randoms[7]).append(randoms[8])
					.append(randoms[9]);
		}
		System.err.println(System.currentTimeMillis() - d);

	}
}