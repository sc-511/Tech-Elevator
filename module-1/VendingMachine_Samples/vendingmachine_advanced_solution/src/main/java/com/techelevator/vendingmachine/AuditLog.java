package com.techelevator.vendingmachine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.techelevator.MoneyFormatter;

public class AuditLog implements Auditable {
	private File file;
	public static final String LOG_TYPE_FEED_MONEY = "FEED MONEY";
	public static final String LOG_TYPE_GIVE_CHANGE = "GIVE CHANGE";

	public AuditLog(File file) {
		this.file = file;
	}

	@Override
	public void moneyFed(BigDecimal amountAdded, BigDecimal balance) {
		String logMsg = LOG_TYPE_FEED_MONEY + " " + MoneyFormatter.formatMoney(amountAdded) + " "
				+ MoneyFormatter.formatMoney(balance);
		writeLog(logMsg);
	}

	@Override
	public void snackVended(String slotName, String snackName, BigDecimal priorBalance, BigDecimal currentBalance) {
		String logMsg = slotName + " " + snackName + " " + MoneyFormatter.formatMoney(priorBalance) + " "
				+ MoneyFormatter.formatMoney(currentBalance);
		writeLog(logMsg);
	}

	@Override
	public void changeGiven(BigDecimal amount) {
		String logMsg = LOG_TYPE_GIVE_CHANGE + " " + MoneyFormatter.formatMoney(amount) + " "
				+ MoneyFormatter.formatMoney(BigDecimal.ZERO);
		writeLog(logMsg);
	}

	private void writeLog(String log) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
			writer.println(LocalDateTime.now() + " " + log);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
