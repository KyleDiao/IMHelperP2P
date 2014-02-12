package com.yesudoo.im.p2p.xmpp;


public interface IXMPPClient {

	public boolean sendXMPPMessage(XMPPMessage message);
	public void setXMPPListener(IXMPPListener listener);
}
