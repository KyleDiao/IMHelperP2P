package com.yesudoo.im.p2p.connection;

import java.net.DatagramSocket;
import java.net.SocketException;

import de.javawi.jstun.attribute.MappedAddress;

public class MappedSocket extends DatagramSocket {
	
	private MappedAddress maddr;

	public MappedAddress getMaddr() {
		return maddr;
	}
	public void setMaddr(MappedAddress maddr) {
		this.maddr = maddr;
	}
	
	public MappedSocket() throws SocketException {
		super();
	}

}
