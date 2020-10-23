package com.techelevator.vendingmachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.techelevator.vendingmachine.AuditLog;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuditLogTests {
	private AuditLog auditLog;
	private File logFile;

	@Before
	public void setup() {
		logFile = new File("test.txt");
		if (logFile.exists()) {
			logFile.delete();
		}
	}

	@Test
	public void moneyFed_logs_once_with_correct_format() {
		// Arrange
		auditLog = new AuditLog(logFile);
		final String lineZeroEnding = AuditLog.LOG_TYPE_FEED_MONEY + " $1.25 $2.50";

		// Act
		auditLog.moneyFed(BigDecimal.valueOf(1.25), BigDecimal.valueOf(2.50));

		// Assert
		List<String> lines = getLinesFromFile(this.logFile);
		Assert.assertEquals(1, lines.size());
		Assert.assertTrue(lines.get(0).endsWith(lineZeroEnding));
	}

	@Test
	public void changeGiven_logs_once_with_correct_format() {
		// Arrange
		auditLog = new AuditLog(logFile);
		final String lineZeroEnding = AuditLog.LOG_TYPE_GIVE_CHANGE + " $1.25 $0.00";

		// Act
		auditLog.changeGiven(BigDecimal.valueOf(1.25));

		// Assert
		List<String> lines = getLinesFromFile(this.logFile);
		Assert.assertEquals(1, lines.size());
		Assert.assertTrue(lines.get(0).endsWith(lineZeroEnding));
	}

	@Test
	public void snackVended_logs_once_with_correct_format() {
		// Arrange
		auditLog = new AuditLog(logFile);
		final String slotName = "Slot X";
		final String snackName = "Slot X";
		final String lineZeroEnding = slotName + " " + snackName + " $2.50 $1.25";

		// Act
		auditLog.snackVended(slotName, snackName, BigDecimal.valueOf(2.50), BigDecimal.valueOf(1.25));

		// Assert
		List<String> lines = getLinesFromFile(this.logFile);
		Assert.assertEquals(1, lines.size());
		Assert.assertTrue(lines.get(0).endsWith(lineZeroEnding));
	}

	@Test
	public void moneyFed_snack_vended_and_change_given_returns_three_lines() {
		// Arrange
		auditLog = new AuditLog(logFile);

		// Act
		auditLog.moneyFed(BigDecimal.valueOf(1.25), BigDecimal.valueOf(2.50));
		auditLog.snackVended("Slot X", "Snack Y", BigDecimal.valueOf(1.25), BigDecimal.valueOf(2.50));
		auditLog.changeGiven(BigDecimal.valueOf(1.25));

		// Assert
		List<String> lines = getLinesFromFile(this.logFile);
		Assert.assertEquals(3, lines.size());
	}

	@Test
	public void open_log_again_appends() {
		// Arrange
		auditLog = new AuditLog(logFile);
		final String lineZeroEnding = AuditLog.LOG_TYPE_FEED_MONEY + " $1.25 $2.50";
		final String lineOneEnding = AuditLog.LOG_TYPE_FEED_MONEY + " $3.25 $5.75";

		// Act
		auditLog.moneyFed(BigDecimal.valueOf(1.25), BigDecimal.valueOf(2.50));
		auditLog = new AuditLog(logFile);
		auditLog.moneyFed(BigDecimal.valueOf(3.25), BigDecimal.valueOf(5.75));

		// Assert
		List<String> lines = getLinesFromFile(this.logFile);
		Assert.assertEquals(2, lines.size());
		Assert.assertTrue(lines.get(0).endsWith(lineZeroEnding));
		Assert.assertTrue(lines.get(1).endsWith(lineOneEnding));
	}

	private List<String> getLinesFromFile(File theFile) {
		List<String> lines = new ArrayList<>();

		try (Scanner fileScanner = new Scanner(theFile)) {
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				lines.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return lines;
	}
}
