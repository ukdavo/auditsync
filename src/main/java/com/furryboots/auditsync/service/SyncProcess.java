package com.furryboots.auditsync.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SyncProcess implements Runnable {

    final SyncService syncService;

    final static Logger logger = LoggerFactory.getLogger(SyncService.class);

    public SyncProcess(SyncService syncService) {
        this.syncService = syncService;
    }

    @Override
    public void run() {
        while (syncService.isRunning()) {
            try {
                process();
            } catch (InterruptedException e) {
                logger.error("Unexpected processing exception", e);
                throw new RuntimeException(e);
            }
        }

        logger.info("Stopped sync");
    }

    private void process() throws InterruptedException {
        // TODO - replace this with logic for syncing Alfresco audit with Elasticsearch
        Thread.sleep(5000);
        logger.info("Processing..");
    }
}
