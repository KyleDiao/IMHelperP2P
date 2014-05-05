package com.yesudoo.im.p2p.connection;

public interface IUDPPacket {

	public void setData(byte[] data, int length);

	public void setTarget(String targetAddress, int targetPort);
	
	public void setTarget(UDPFullAddress address);
	
	public UDPFullAddress getTarget();
	
	public UDPFullAddress getSource();
}
