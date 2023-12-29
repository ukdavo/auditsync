package com.furryboots.auditsync.data.domain;

import java.util.Objects;

/**
 * Holds data that relates to data synchronisation.
 */
public class Context {
    private boolean running = false;
    private int currentBatchSize = 10;
    private long iterations = 0L;
    private long syncStart = 0L;
    private long syncBatches = 0L;
    private long syncItems = 0L;
    private long currentSyncStart = 0L;
    private long currentSyncFinish = 0L;
    private long currentSyncItems = 0L;

    public Context() {}

    public Context(int batchSize) {
        currentBatchSize = batchSize;
    }

    public Context(Context ctx) {
        this.running = ctx.running;
        this.currentBatchSize = ctx.currentBatchSize;
        this.iterations = ctx.iterations;
        this.syncStart = ctx.syncStart;
        this.syncBatches = ctx.syncBatches;
        this.syncItems = ctx.syncItems;
        this.currentSyncStart = ctx.currentSyncStart;
        this.currentSyncFinish = ctx.currentSyncFinish;
        this.currentSyncItems = ctx.currentSyncItems;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getCurrentBatchSize() {
        return currentBatchSize;
    }

    public void setCurrentBatchSize(int currentBatchSize) {
        this.currentBatchSize = currentBatchSize;
    }

    public long getIterations() {
        return iterations;
    }

    public void setIterations(long iterations) {
        this.iterations = iterations;
    }

    public long getSyncStart() {
        return syncStart;
    }

    public void setSyncStart(long syncStart) {
        this.syncStart = syncStart;
    }

    public long getSyncBatches() {
        return syncBatches;
    }

    public void setSyncBatches(long syncBatches) {
        this.syncBatches = syncBatches;
    }

    public long getSyncItems() {
        return syncItems;
    }

    public void setSyncItems(long syncItems) {
        this.syncItems = syncItems;
    }

    public long getCurrentSyncStart() {
        return currentSyncStart;
    }

    public void setCurrentSyncStart(long currentSyncStart) {
        this.currentSyncStart = currentSyncStart;
    }

    public long getCurrentSyncFinish() {
        return currentSyncFinish;
    }

    public void setCurrentSyncFinish(long currentSyncFinish) {
        this.currentSyncFinish = currentSyncFinish;
    }

    public long getCurrentSyncItems() {
        return currentSyncItems;
    }

    public void setCurrentSyncItems(long currentSyncItems) {
        this.currentSyncItems = currentSyncItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Context context = (Context) o;
        return running == context.running && currentBatchSize == context.currentBatchSize && iterations == context.iterations && syncStart == context.syncStart && syncBatches == context.syncBatches && syncItems == context.syncItems && currentSyncStart == context.currentSyncStart && currentSyncFinish == context.currentSyncFinish && currentSyncItems == context.currentSyncItems;
    }

    @Override
    public int hashCode() {
        return Objects.hash(running, currentBatchSize, iterations, syncStart, syncBatches, syncItems, currentSyncStart, currentSyncFinish, currentSyncItems);
    }

    @Override
    public String toString() {
        return "Context{" +
                "running=" + running +
                ", currentBatchSize=" + currentBatchSize +
                ", iterations=" + iterations +
                ", syncStart=" + syncStart +
                ", syncBatches=" + syncBatches +
                ", syncItems=" + syncItems +
                ", currentSyncStart=" + currentSyncStart +
                ", currentSyncFinish=" + currentSyncFinish +
                ", currentSyncItems=" + currentSyncItems +
                '}';
    }
}
