package com.yesudoo.im.p2p.xmpp;

public class XMPPMessage {

	private String targetJID;
	private String content;
	private String extend;
	public String getTargetJID() {
		return targetJID;
	}
	public void setTargetJID(String targetJID) {
		this.targetJID = targetJID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getExtend() {
		return extend;
	}
	public void setExtend(String extend) {
		this.extend = extend;
	}
	
}
