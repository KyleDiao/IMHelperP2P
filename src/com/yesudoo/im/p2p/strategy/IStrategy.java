package com.yesudoo.im.p2p.strategy;

import com.yesudoo.im.p2p.connection.IReliableSocket;
import com.yesudoo.im.p2p.netenv.NATType;

public interface IStrategy {

	public void setEnvironment(NATType natType, String localJID, String remoteJID);
	
	public boolean tryStrategy();
	
	public void passiveMode();
	
	public IReliableSocket getReiliableSocket();
}
