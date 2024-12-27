package com.ab.core;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ab.core.constants.QuizConstants;
import com.ab.core.db.ConnectionPool;

@SpringBootApplication
public class CoreQuizServerApplication implements ApplicationRunner {

	private static final Logger logger = LogManager.getLogger(CoreQuizServerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CoreQuizServerApplication.class, args);
	}
	
	@Override
	public void run(ApplicationArguments args) {
		
		logger.info("Starting Core QuizServer Application");
		QuizConstants.initializeProps();
		
		try {
			ConnectionPool.getInstance();
		} catch (SQLException e) {
			logger.error(QuizConstants.ERROR_PREFIX_START);
			logger.error("SQLException while initilizing ConnectionPool", e);
			logger.error(QuizConstants.ERROR_PREFIX_END);
			System.exit(0);
		}
		
		
		/*Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR, 3);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.AM_PM, Calendar.AM);
		
		long initialDelay = calendar.getTimeInMillis() - System.currentTimeMillis();
		//initialDelay = 0;
		logger.info("Purge old records task scheduled at {}", new Date(calendar.getTimeInMillis()));
		
		LazyScheduler.getInstance().submitRepeatedTask(new DeleteOldRecords(), initialDelay, 
				24 * 60 * 1000, TimeUnit.MILLISECONDS);
		LazyScheduler.getInstance().submitRepeatedTask(new DeleteGameMoneyCreditedStatus(), 0, 15 * 60 * 1000, TimeUnit.MILLISECONDS);
		LazyScheduler.getInstance().submitRepeatedTask(new DeleteUselessOTPTask(), initialDelay, 
				24 * 60 * 1000, TimeUnit.MILLISECONDS);
		
		WinMsgHandler.getInstance();
		
		long gapBetweenServerInstances = 2 * 60 * 1000;
		long gap = 0;
		for (int index = 1; index <= QuizConstants.CURRENT_SERVERS_COUNT; index ++) {
			LoggedInUsersCountTask task = LoggedInUsersCountManager.getInstance().createIfDoesNotExist(index);
			LazyScheduler.getInstance().submitRepeatedTask(task, gap, 
					QuizConstants.LOGGED_IN_USERS_COUNT_UPDATE_TIME_INTERVAL_IN_MILLIS, TimeUnit.MILLISECONDS);
			gap = gap + gapBetweenServerInstances;
		}*/
	}
}
