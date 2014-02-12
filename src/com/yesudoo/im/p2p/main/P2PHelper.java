package com.yesudoo.im.p2p.main;

import com.yesudoo.im.p2p.connection.IP2PConnection;
import com.yesudoo.im.p2p.util.P2PHelperConfig;
import com.yesudoo.im.p2p.xmpp.IXMPPClient;
import com.yesudoo.im.p2p.xmpp.XMPPMessage;

public class P2PHelper implements IP2PHelper {

	private P2PHelperConfig config;
	
	@Override
	public void setConfig(P2PHelperConfig config) {
		// TODO Auto-generated method stub
		this.config = config;
	}

	@Override
	public IP2PConnection getConnection(String targetJID) {
		// TODO Auto-generated method stub
		
		IXMPPClient xmppclient = config.getXmppClient();
		XMPPMessage message = new XMPPMessage();
		message.setTargetJID(targetJID);
		message.setContent("init");
		xmppclient.sendXMPPMessage(message);
		return null;
	}

	@Override
	public IP2PConnection recieveConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
