package com.yesudoo.im.p2p.connection;

public interface IP2PConnectionListener {

	public void recieveData(byte[] data, int length);
}
