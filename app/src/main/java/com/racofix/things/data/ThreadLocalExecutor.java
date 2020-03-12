package com.racofix.things.data;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalExecutor {

    private static final Handler UI_HANDLER = new Handler(Looper.getMainLooper());

    private static final ThreadPoolExecutor BACKGROUND_THREAD_POOL = new ThreadPoolExecutor(4, 8, 10, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            (ThreadFactory) Thread::new);

    public static void runOnBackgroundThread(Runnable runnable) {
        BACKGROUND_THREAD_POOL.submit(runnable);
    }

    public static void runOnUIThread(Runnable runnable) {
        UI_HANDLER.post(runnable);
    }
}
