package com.yesudoo.im.p2p.netenv;

public interface IStunClient {

	public String getPublicAddress();
	
	public int getPublicPort();
	
	public NATType getNatType();
}
