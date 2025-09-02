package com.example.springcors.controller;

import com.example.springcors.domain.Memo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/memos")
public class MemoController {
//    private final CopyOnWriteArrayList<Memo> memos = new CopyOnWriteArrayList<>();
    private final ConcurrentHashMap<Long, Memo> memos = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public List<Memo> getMemos() {
        return memos.values().stream().toList();
    }

    @PostMapping
    public Memo createMemo(@RequestBody Memo.MemoDTO dto) {
        long newId = counter.incrementAndGet();
        Memo memo = new Memo(newId, dto.content());
        memos.put(newId, memo);
        return memo;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMemo(@PathVariable Long id) {
        memos.remove(id);
        return ResponseEntity.noContent().build();
    }
}
