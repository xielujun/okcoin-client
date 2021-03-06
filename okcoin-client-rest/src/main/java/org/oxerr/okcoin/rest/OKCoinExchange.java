package org.oxerr.okcoin.rest;

import org.knowm.xchange.BaseExchange;
import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeSpecification;
import org.oxerr.okcoin.rest.service.OKCoinAccountService;
import org.oxerr.okcoin.rest.service.OKCoinMarketDataService;
import org.oxerr.okcoin.rest.service.OKCoinTradeService;

import si.mazi.rescu.SynchronizedValueFactory;

/**
 * {@link Exchange} implementation for OKCoin.
 */
public class OKCoinExchange extends BaseExchange {

	/**
	 * Max count of retry in logging into via web form.
	 */
	public static final String LOGIN_MAX_RETRY_TIMES_PARAMETER = "login.max.retry.times";

	public static final String SOCKET_TIMEOUT_PARAMETER = "socketTimeout";
	public static final String CONNECT_TIMEOUT_PARAMETER = "connectTimeout";
	public static final String CONNECTION_REQUEST_TIMEOUT_PARAMETER = "connectionRequestTimeout";

	/**
	 * The parameter key of the trade password.
	 */
	public static final String TRADE_PASSWORD_PARAMETER = "trade_pwd";

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void initServices() {
		this.marketDataService = new OKCoinMarketDataService(this);

		if (exchangeSpecification.getApiKey() != null
			&& exchangeSpecification.getSecretKey() != null) {
			this.accountService = new OKCoinAccountService(this);
		}

		if ((exchangeSpecification.getApiKey() != null
				&& exchangeSpecification.getSecretKey() != null)
			|| (exchangeSpecification.getUserName() != null
				&& exchangeSpecification.getPassword() != null)) {
			this.tradeService = new OKCoinTradeService(this);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ExchangeSpecification getDefaultExchangeSpecification() {
		ExchangeSpecification exchangeSpecification = new ExchangeSpecification(
				this.getClass().getCanonicalName());
		exchangeSpecification.setSslUri("https://www.okcoin.cn");
		exchangeSpecification.setHost("www.okcoin.cn");
		exchangeSpecification.setExchangeName("OKCoin");
		exchangeSpecification
				.setExchangeDescription("OKCoin is a globally oriented crypto-currency trading platform.");
		return exchangeSpecification;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SynchronizedValueFactory<Long> getNonceFactory() {
		return null;
	}

}
