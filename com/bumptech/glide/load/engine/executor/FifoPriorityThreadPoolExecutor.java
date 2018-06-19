package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class FifoPriorityThreadPoolExecutor extends ThreadPoolExecutor {
    private static final String TAG = "PriorityExecutor";
    private final AtomicInteger ordering;
    private final UncaughtThrowableStrategy uncaughtThrowableStrategy;

    public static class DefaultThreadFactory implements ThreadFactory {
        int threadNum = 0;

        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder("fifo-pool-thread-");
            stringBuilder.append(this.threadNum);
            Thread anonymousClass1 = new Thread(runnable, stringBuilder.toString()) {
                public void run() {
                    Process.setThreadPriority(10);
                    super.run();
                }
            };
            this.threadNum++;
            return anonymousClass1;
        }
    }

    static class LoadTask<T> extends FutureTask<T> implements Comparable<LoadTask<?>> {
        private final int order;
        private final int priority;

        public LoadTask(Runnable runnable, T t, int i) {
            super(runnable, t);
            if ((runnable instanceof Prioritized) == null) {
                throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
            }
            this.priority = ((Prioritized) runnable).getPriority();
            this.order = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof LoadTask)) {
                return false;
            }
            LoadTask loadTask = (LoadTask) obj;
            if (this.order == loadTask.order && this.priority == loadTask.priority) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (31 * this.priority) + this.order;
        }

        public int compareTo(LoadTask<?> loadTask) {
            int i = this.priority - loadTask.priority;
            return i == 0 ? this.order - loadTask.order : i;
        }
    }

    public enum UncaughtThrowableStrategy {
        IGNORE,
        LOG {
            protected final void handle(Throwable th) {
            }
        },
        THROW {
            protected final void handle(Throwable th) {
                super.handle(th);
                throw new RuntimeException(th);
            }
        };

        protected void handle(Throwable th) {
        }
    }

    public FifoPriorityThreadPoolExecutor(int i) {
        this(i, UncaughtThrowableStrategy.LOG);
    }

    public FifoPriorityThreadPoolExecutor(int i, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        this(i, i, 0, TimeUnit.MILLISECONDS, new DefaultThreadFactory(), uncaughtThrowableStrategy);
    }

    public FifoPriorityThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        super(i, i2, j, timeUnit, new PriorityBlockingQueue(), threadFactory);
        this.ordering = new AtomicInteger();
        this.uncaughtThrowableStrategy = uncaughtThrowableStrategy;
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new LoadTask(runnable, t, this.ordering.getAndIncrement());
    }

    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future) != null) {
            Future future = (Future) runnable;
            if (future.isDone() != null && future.isCancelled() == null) {
                try {
                    future.get();
                } catch (Runnable runnable2) {
                    this.uncaughtThrowableStrategy.handle(runnable2);
                } catch (Runnable runnable22) {
                    this.uncaughtThrowableStrategy.handle(runnable22);
                }
            }
        }
    }
}
