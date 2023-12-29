package com.furryboots.auditsync.web;

import com.furryboots.auditsync.data.domain.Context;
import com.furryboots.auditsync.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SyncController {

    private SyncService syncService;

    @Autowired
    public SyncController(SyncService syncService) {
        this.syncService = syncService;
    }

    @PostMapping("/api/sync/start")
    public void startSync() {
        syncService.start();
    }

    @PostMapping("/api/sync/stop")
    public void stopSync() {
        syncService.stop();
    }

    @GetMapping("/api/sync/status")
    public Context status() {
        return syncService.getContext();
    }
}
