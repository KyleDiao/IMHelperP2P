package com.yesudoo.im.p2p.strategy;

import com.yesudoo.im.p2p.netenv.NATType;

public class StrategyFactory {

	private StrategyFactory() {
	}

	private static StrategyFactory instance;

	public static synchronized StrategyFactory getInstance() {
		if (null == instance) {
			instance = new StrategyFactory();
		}
		return instance;
	}

	public IStrategy getProperStrategy(NATType senderType, NATType targetType,
			String localJID, String remoteJID) {
		if (senderType.equals(NATType.PUBLIC)
				|| targetType.equals(NATType.PUBLIC)) {
			IStrategy strategy = new Public2AnyStrategy();
			strategy.setEnvironment(senderType, targetType, localJID, remoteJID);
			return strategy;
		} else if (senderType.equals(NATType.CONE)
				&& targetType.equals(NATType.CONE)) {
			IStrategy strategy = new Cone2ConeStrategy();
			strategy.setEnvironment(senderType, targetType, localJID, remoteJID);
			return strategy;
		} else if (senderType.equals(NATType.CONE)
				&& targetType.equals(NATType.SYMMETRIC)
				|| senderType.equals(NATType.SYMMETRIC)
				&& targetType.equals(NATType.CONE)) {
			IStrategy strategy = new Cone2SymmetricStrategy();
			strategy.setEnvironment(senderType, targetType, localJID, remoteJID);
			return strategy;
		} else if (targetType.equals(NATType.SYMMETRIC)
				&& senderType.equals(NATType.SYMMETRIC)) {
			IStrategy strategy = new Sym2SymStrategy();
			strategy.setEnvironment(senderType, targetType, localJID, remoteJID);
			return strategy;
		} else {
			return null;
		}
	}
}
