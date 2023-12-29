package com.furryboots.auditsync.service;

import com.furryboots.auditsync.data.domain.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class SyncService {

    private final AtomicReference<Context> contextRef;

    @Autowired
    @Qualifier("syncTaskExecutor")
    private TaskExecutor taskExecutor;

    final static Logger logger = LoggerFactory.getLogger(SyncService.class);

    /**
     * Default constructor.
     */
    public SyncService() throws InterruptedException {
        contextRef = new AtomicReference<>(new Context());
    }

    public boolean start() {
        logger.info("Received start sync request");

        if (!contextRef.get().isRunning()) {
            final Context ctx = new Context(getContext());
            ctx.setRunning(true);
            setContext(ctx);
            startProcessing();
            logger.info("Starting sync..");
            return true;
        } else {
            logger.info("Sync is already running");
            return false;
        }
    }

    private void startProcessing() {
        logger.info("Spawning sync process..");
        taskExecutor.execute(new SyncProcess(this));
    }

    public boolean stop() {
        logger.info("Received stop sync request");

        if (isRunning()) {
            final Context ctx = new Context(getContext());
            ctx.setRunning(false);
            setContext(ctx);
            logger.info("Stopping sync");
            return true;
        } else {
            logger.info("Sync is already not running");
            return false;
        }
    }

    public boolean isRunning() {
        return getContext().isRunning();
    }

    /**
     * Gets the atomic reference to the context.
     *
     * @return The reference
     */
    public AtomicReference<Context> getContextRef() {
        return contextRef;
    }

    /**
     * Gets the context.
     *
     * @return The context
     */
    public Context getContext() {
        return contextRef.get();
    }

    /**
     * Updates the context.
     *
     * @param context The context
     */
    public void setContext(Context context) {
        contextRef.compareAndSet(contextRef.get(), context);
    }
}
