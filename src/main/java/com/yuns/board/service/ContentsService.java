package com.yuns.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.yuns.board.model.Contents;
import reactor.core.publisher.Mono;

@Service
public class ContentsService {
	private final ResourceLoader resourceLoader;

	@Autowired
	public ContentsService(@Qualifier("webApplicationContext") ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

	public Mono<Void> createContents(Mono<Contents> contents) {
		return contents.then();
	}
}
