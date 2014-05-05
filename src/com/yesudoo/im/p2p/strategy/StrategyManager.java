package com.yesudoo.im.p2p.strategy;

import com.yesudoo.im.p2p.netenv.IStunClient;
import com.yesudoo.im.p2p.netenv.NATType;
import com.yesudoo.im.p2p.xmpp.IXMPPClient;
import com.yesudoo.im.p2p.xmpp.XMPPMessage;


public class StrategyManager {
	
	public StrategyManager(){}

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
		
		XMPPMessage message = new XMPPMessage();
		message.setTargetJID(remoteJID);
		
		NATType natType = stunClient.getNatType();
		NATType remoteNatType = NATType.UNKNOWN;
		message.setContent(natType.toString());
		message.setExtend("nattype");
		xmppClient.sendXMPPMessage(message);
		XMPPMessage remoteMessage = xmppClient.recieveXMPPMessage();
		if(remoteMessage != null){
			if("nattype".equals(remoteMessage.getExtend())){
				remoteNatType = NATType.valueOf(remoteMessage.getContent());
				return StrategyFactory.getInstance().getProperStrategy(natType, remoteNatType,localJID,remoteJID);
			}
		}
		
		return null;
	}
	
	
}
