package com.yesudoo.im.p2p.strategy;

import com.yesudoo.im.p2p.connection.IReliableSocket;
import com.yesudoo.im.p2p.netenv.NATType;

public class Sym2SymStrategy implements IStrategy {

	@Override
	public void setEnvironment(NATType natType, NATType remoteNatType,
			String localJID, String remoteJID) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean tryStrategy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void passiveMode() {
		// TODO Auto-generated method stub

	}

	@Override
	public IReliableSocket getReiliableSocket() {
		// TODO Auto-generated method stub
		return null;
	}

}
