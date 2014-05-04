package com.yesudoo.im.p2p.netenv;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import com.yesudoo.im.p2p.connection.MappedSocket;

import de.javawi.jstun.attribute.MappedAddress;
import de.javawi.jstun.attribute.MessageAttribute;
import de.javawi.jstun.attribute.MessageAttributeException;
import de.javawi.jstun.attribute.MessageAttributeParsingException;
import de.javawi.jstun.header.MessageHeader;
import de.javawi.jstun.header.MessageHeaderParsingException;
import de.javawi.jstun.test.DiscoveryInfo;
import de.javawi.jstun.test.DiscoveryTest;
import de.javawi.jstun.util.UtilityException;

public class StunClientAdapter implements IStunClient {

	private int[] stunPorts = null;
	private String[] stunServers = null;

	// private UdpStunClient usc = null;// new UdpStunClient();
	private DiscoveryTest disTest = null;
	private DiscoveryInfo disInfo = null;

	private boolean doTest(String stunServer, int stunPort, InetAddress addr)
			throws SocketException, UnknownHostException,
			MessageAttributeParsingException, MessageHeaderParsingException,
			UtilityException, IOException, MessageAttributeException {

		this.disTest = new DiscoveryTest(addr, stunServer, stunPort);
		this.disInfo = disTest.test();
		return false;
	}

	/**
	 * Constructor
	 */
	public StunClientAdapter() {

	}

	public void refresh() throws SocketException, UnknownHostException,
			MessageAttributeParsingException, MessageHeaderParsingException,
			UtilityException, IOException, MessageAttributeException {
		for (int index = 0; index < stunServers.length
				&& index < stunPorts.length; index++) {
			this.doTest(stunServers[index], stunPorts[index],
					getFirstAvailableIaddress());
		}
	}

	@Override
	public String getPublicIP() throws SocketException,
			UnknownHostException, MessageAttributeParsingException,
			MessageHeaderParsingException, UtilityException, IOException,
			MessageAttributeException {
		if (disInfo == null) {
			this.refresh();
		}
		return disInfo.getPublicIP().getHostAddress();
	}
	
	@Override
	public MappedSocket getMappedSocket() {
		return null;
//		MappedSocket msocket = new MappedSocket();
//		msocket.setReuseAddress(true);
//		//msocket.bind(new InetSocketAddress(iaddress, 0));
//		//msocket.connect(InetAddress.getByName(stunServer), stunPort);
//		msocket.setSoTimeout(timeout);
//
//		MessageHeader sendMH = new MessageHeader(
//				MessageHeader.MessageHeaderType.BindingRequest);
//
//		sendMH.generateTransactionID();
//
//		byte[] data;
//
//		data = sendMH.getBytes();
//		DatagramPacket send = new DatagramPacket(data, data.length);
//		send.setAddress(InetAddress.getByName(stunServer));
//		send.setPort(stunPort);
//		msocket.send(send);
//
//		MessageHeader receiveMH = new MessageHeader();
//		while (!(receiveMH.equalTransactionID(sendMH))) {
//			DatagramPacket receive = new DatagramPacket(new byte[200], 200);
//			msocket.receive(receive);
//			receiveMH = MessageHeader.parseHeader(receive.getData());
//			receiveMH.parseAttributes(receive.getData());
//		}
//		
//		MappedAddress ma = (MappedAddress) receiveMH.getMessageAttribute(MessageAttribute.MessageAttributeType.MappedAddress);
//		msocket.setMaddr(ma);
//		return msocket;
	}


	@Override
	public NATType getNatType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getStunServers() {
		return stunServers;
	}

	public int[] getStunPorts() {
		return stunPorts;
	}

	public void setStunPorts(int[] stunPorts) {
		this.stunPorts = stunPorts;
	}

	public void setStunServers(String[] stunServers) {
		this.stunServers = stunServers;
	}

	/**
	 * get the first available inetaddress for use
	 * 
	 * @return available inetaddress excluding loop-back & local-only
	 */
	public static InetAddress getFirstAvailableIaddress() {
		Enumeration<NetworkInterface> ifaces;
		try {
			ifaces = NetworkInterface.getNetworkInterfaces();

			while (ifaces.hasMoreElements()) {
				NetworkInterface iface = ifaces.nextElement();
				Enumeration<InetAddress> iaddresses = iface.getInetAddresses();
				while (iaddresses.hasMoreElements()) {
					InetAddress iaddress = iaddresses.nextElement();
					if (Class.forName("java.net.Inet4Address").isInstance(
							iaddress)) {
						if ((!iaddress.isLoopbackAddress())
								&& (!iaddress.isLinkLocalAddress())) {
							return iaddress;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
