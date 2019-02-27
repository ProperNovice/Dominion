package utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {

	private static ExecutorService executorService = Executors
			.newCachedThreadPool();
	private static ThreadRunning threadRunning = ThreadRunning.FX;

	private Executor() {

	}

	public static void sleep(final long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void runLater(Runnable runnable) {

		switch (threadRunning) {

		case EXECUTOR_SERVICE:
			runLaterExecutorService(runnable);
			break;

		case FX:
			runLaterFX(runnable);
			break;

		}

	}

	private static void runLaterExecutorService(Runnable runnable) {
		executorService.submit(runnable);
	}

	private static void runLaterFX(Runnable runnable) {
		runnable.run();
	}

	private enum ThreadRunning {
		EXECUTOR_SERVICE, FX
	}

	public static void sleepExecuteRunnableFX(long duration, Runnable runnable) {

		runLaterExecutorService(() -> {

			sleep(duration);
			runLaterFX(runnable);

		});

	}
}
