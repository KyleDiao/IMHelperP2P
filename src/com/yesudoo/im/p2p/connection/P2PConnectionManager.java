package com.yesudoo.im.p2p.connection;

public class P2PConnectionManager {

	private IP2PConnection p2pConnection;
	private IReliableSocket rsocket;
	private IUDPSocket udpSocket;
	
	public IReliableSocket getRsocket() {
		return rsocket;
	}

	public void setRsocket(IReliableSocket rsocket) {
		this.rsocket = rsocket;
	}

	public IP2PConnection getP2pConnection() {
		return p2pConnection;
	}

	public void setP2pConnection(IP2PConnection p2pConnection) {
		this.p2pConnection = p2pConnection;
	}

	public IP2PConnectionListener getPspListener() {
		return pspListener;
	}

	public void setPspListener(IP2PConnectionListener pspListener) {
		this.pspListener = pspListener;
	}

	private IP2PConnectionListener pspListener;
	
	
}
