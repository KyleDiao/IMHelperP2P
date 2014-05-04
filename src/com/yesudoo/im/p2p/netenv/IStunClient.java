package com.yesudoo.im.p2p.netenv;

import com.yesudoo.im.p2p.connection.MappedSocket;

public interface IStunClient {

	public String getPublicIP() throws Exception;

	public MappedSocket getMappedSocket();

	public NATType getNatType();
}
