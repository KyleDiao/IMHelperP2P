package com.yesudoo.im.p2p.test;

import com.yesudoo.im.p2p.connection.IP2PConnection;
import com.yesudoo.im.p2p.connection.IP2PConnectionListener;
import com.yesudoo.im.p2p.main.P2PHelper;
import com.yesudoo.im.p2p.util.P2PHelperConfig;

public class IMSimulator {

	public static void main(int argn, String[] argv) throws Exception{
		P2PHelper p2p = new P2PHelper();
		P2PHelperConfig config = new P2PHelperConfig();

		// TODO detail configuration
		config.setStunClient(null);
		config.setXmppClient(null);
		config.setTimeout(3000);
		
		p2p.setConfig(config);
		String targetJID = "dyr@192.168.1.175/some";
		
		IP2PConnection conn = p2p.getConnection(targetJID);
		conn.setP2PListener(new IP2PConnectionListener() {
			
			@Override
			public void recieveData(byte[] data, int length) {
				// TODO Auto-generated method stub
				 
			}
		});
		
		byte[] data = new byte[50];
		conn.sendData(data, data.length);
	}
}
