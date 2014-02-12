package com.yesudoo.im.p2p.connection;


public class P2PConnection implements IP2PConnection{

	private IReliableSocket socket;
	
	public IReliableSocket getSocket() {
		return socket;
	}

	public void setSocket(IReliableSocket socket) {
		this.socket = socket;
	}

	@Override
	public int sendData(byte[] data, int length) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public void setP2PListener(IP2PConnectionListener listener) {
		// TODO Auto-generated method stub
		
	}

	
	
}
