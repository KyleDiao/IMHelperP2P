package com.yesudoo.im.p2p.strategy;

import com.yesudoo.im.p2p.netenv.IStunClient;
import com.yesudoo.im.p2p.netenv.NATType;
import com.yesudoo.im.p2p.xmpp.IXMPPClient;
import com.yesudoo.im.p2p.xmpp.IXMPPListener;
import com.yesudoo.im.p2p.xmpp.XMPPMessage;


public class StrategyManager {

	private IStunClient stunClient;
	
	private IXMPPClient xmppClient;

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
	
	public IStrategy getProperStrategy(String localJID, String remoteJID){
		
		
		xmppClient.setXMPPListener(new IXMPPListener() {
			
			@Override
			public void notifyXMPPMessage(XMPPMessage message) {
				// TODO Auto-generated method stub
				
			}
		});
		XMPPMessage message = new XMPPMessage();
		message.setTargetJID(remoteJID);
		message.setContent("");
		NATType natType = stunClient.getNatType();
		
		return null;
	}
	
	
}
