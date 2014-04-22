package com.yesudoo.im.p2p.util;

import com.yesudoo.im.p2p.netenv.IStunClient;
import com.yesudoo.im.p2p.xmpp.IXMPPClient;

public class P2PHelperConfig {

	private IStunClient stunClient;
	
	private IXMPPClient xmppClient;
	
	private String xmppServerAddr;
	
	public String getXmppServerAddr() {
		return xmppServerAddr;
	}

	public void setXmppServerAddr(String xmppServerAddr) {
		this.xmppServerAddr = xmppServerAddr;
	}

	public int getXmppPort() {
		return xmppPort;
	}

	public void setXmppPort(int xmppPort) {
		this.xmppPort = xmppPort;
	}

	public String getStunServerAddr() {
		return stunServerAddr;
	}

	public void setStunServerAddr(String stunServerAddr) {
		this.stunServerAddr = stunServerAddr;
	}

	public int getStunPort() {
		return stunPort;
	}

	public void setStunPort(int stunPort) {
		this.stunPort = stunPort;
	}

	private int xmppPort;
	
	private String stunServerAddr;
	
	private int stunPort;
	
	public IStunClient getStunClient() {
		return stunClient;
	}

	public void setStunClient(IStunClient stunClient) {
		this.stunClient = stunClient;
	}

	public IXMPPClient getXmppClient() {
		return xmppClient;
	}

	public void setXmppClient(IXMPPClient xmppClient) {
		this.xmppClient = xmppClient;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	private int timeout; // in seconds
	
	public P2PHelperConfig(){
		// TODO
	}
	
}
