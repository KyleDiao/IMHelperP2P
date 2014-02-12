package com.yesudoo.im.p2p.connection;

public interface IUDPSocket {

	public void bind(String address,int port);
	
	public int sendPacket(IUDPPacket packet);
}
