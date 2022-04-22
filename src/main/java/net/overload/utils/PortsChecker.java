package net.overload.utils;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;

public class PortsChecker {
	private Integer port;

	public PortsChecker(Integer portTocheck) {
		setPort(portTocheck);
	}

	public Boolean check() {
		ServerSocket ss = null;
		DatagramSocket ds = null;
		try {
			ss = new ServerSocket(this.port.intValue());
			ss.setReuseAddress(true);
			ds = new DatagramSocket(this.port.intValue());
			ds.setReuseAddress(true);
			return Boolean.valueOf(true);
		} catch (IOException e) {
			return Boolean.valueOf(false);
		} finally {
			if (ds != null)
				ds.close();
			if (ss != null)
				try {
					ss.close();
				} catch (IOException iOException) {
					return Boolean.valueOf(false);
				}
		}
	}

	public Integer getPort() {
		return this.port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}
}
