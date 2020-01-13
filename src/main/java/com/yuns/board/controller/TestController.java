package com.yuns.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yuns.board.model.Contents;
import com.yuns.board.repository.ContentsRepository;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class TestController {
	private final ContentsRepository contentsRepository;

	public TestController(ContentsRepository contentsRepository) {
		this.contentsRepository = contentsRepository;
	}

	@GetMapping
	public String greeting(@RequestParam(required = false, defaultValue = "") String name) {
		return name.equals("") ? "Hey!" : "Hey, " + name + "!";
	}

	@GetMapping("/contents")
	public Flux<Contents> listing() {
		return contentsRepository.findAll();
	}

	@PostMapping("/contents")
	public Mono<Void> create(@RequestBody Flux<Contents> contentsFlux) {
		return contentsFlux.map(contents -> {
			log.info("we will save" + contents + "to Reactive database soon!");
			return contents;
		}).then();
	}
}
