package com.yesudoo.im.p2p.connection;

public interface IUDPSocket {

	public void bind(String address,int port);
	
	public void sendPacket(IUDPPacket packet);
	
	public IUDPPacket recievePacket();
}
