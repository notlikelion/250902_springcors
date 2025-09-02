package com.example.springcors.controller;

import com.example.springcors.domain.Memo;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MemoController {
//    private final CopyOnWriteArrayList<Memo> memos = new CopyOnWriteArrayList<>();
    private final ConcurrentHashMap<Long, Memo> memos = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong();
}
