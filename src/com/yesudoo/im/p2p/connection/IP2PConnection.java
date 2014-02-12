package com.yesudoo.im.p2p.connection;

public interface IP2PConnection {
	public int sendData(byte[] data, int length);

	public void setP2PListener(IP2PConnectionListener listener);
}
