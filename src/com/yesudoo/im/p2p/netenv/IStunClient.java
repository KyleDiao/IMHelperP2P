package com.yesudoo.im.p2p.netenv;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.yesudoo.im.p2p.connection.MappedSocket;

import de.javawi.jstun.attribute.MessageAttributeException;
import de.javawi.jstun.attribute.MessageAttributeParsingException;
import de.javawi.jstun.header.MessageHeaderParsingException;
import de.javawi.jstun.util.UtilityException;

public interface IStunClient {

	public String getPublicIP() throws Exception;

	public MappedSocket getMappedSocket() throws Exception;

	public NATType getNatType() throws Exception;
}
