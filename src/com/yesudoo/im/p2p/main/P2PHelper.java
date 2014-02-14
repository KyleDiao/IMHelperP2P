package com.yesudoo.im.p2p.main;

import com.yesudoo.im.p2p.connection.IP2PConnection;
import com.yesudoo.im.p2p.connection.IReliableSocket;
import com.yesudoo.im.p2p.connection.P2PConnectionManager;
import com.yesudoo.im.p2p.netenv.IStunClient;
import com.yesudoo.im.p2p.strategy.IStrategy;
import com.yesudoo.im.p2p.strategy.StrategyManager;
import com.yesudoo.im.p2p.util.P2PHelperConfig;
import com.yesudoo.im.p2p.xmpp.IXMPPClient;

public class P2PHelper implements IP2PHelper {

	private P2PHelperConfig config;
	private StrategyManager smanager = new StrategyManager();

	@Override
	public void setConfig(P2PHelperConfig config) {
		// TODO Auto-generated method stub
		this.config = config;
	}

	@Override
	public IP2PConnection getConnection(String targetJID) {
		// TODO Auto-generated method stub
		IXMPPClient xmppClient = config.getXmppClient();
		IStunClient stunClient = config.getStunClient();
		smanager.setStunClient(stunClient);
		smanager.setXmppClient(xmppClient);

		IStrategy strategy = smanager.getProperStrategy("dyr@192.168.1.133",
				targetJID);
		if (strategy.tryStrategy()) {
			IReliableSocket rsocket = strategy.getReiliableSocket();
			P2PConnectionManager connmgr = new P2PConnectionManager();
			connmgr.setRsocket(rsocket);
			return connmgr.getP2pConnection();
		} else {
			return null;
		}
	}

	@Override
	public IP2PConnection recieveConnection() {
		// TODO Auto-generated method stub
		return null;
	}

}
