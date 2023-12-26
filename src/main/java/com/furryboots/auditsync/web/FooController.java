package com.furryboots.auditsync.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furryboots.auditsync.data.domain.Foo;

@RestController
public class FooController {

    @GetMapping("/api/foo")
    public Foo getFoo() {
        return new Foo();
    }
}
