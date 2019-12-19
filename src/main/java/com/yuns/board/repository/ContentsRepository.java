package com.yuns.board.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.yuns.board.model.Contents;

public interface ContentsRepository extends ReactiveCrudRepository<Contents, Integer> {
}
