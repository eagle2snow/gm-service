package com.gm.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CallableTaskB implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				StringBuffer sb = new StringBuffer();
				URL url = new URL("http://192.168.0.14:8080/test/test7.json?content=bbbbb");
				URLConnection conn = url.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));// 防止乱码
				String inputLine = null;
				while ((inputLine = in.readLine()) != null) {
					sb.append(inputLine);
				}
				in.close();
				System.out.println("b->" + sb.toString());
			} catch (MalformedURLException e) {
			} catch (IOException e) {
			}
		}
	}

}
