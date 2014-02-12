package com.yesudoo.im.p2p.main;

import com.yesudoo.im.p2p.connection.IP2PConnection;
import com.yesudoo.im.p2p.util.P2PHelperConfig;

public interface IP2PHelper {

	public void setConfig(P2PHelperConfig config);
	
	public IP2PConnection getConnection(String targetJID);
	
	/**
	 * This method will block until connection is created or timeout
	 * @param targetJID
	 * @return
	 */
	public IP2PConnection recieveConnection();
}
