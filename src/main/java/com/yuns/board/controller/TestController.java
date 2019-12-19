package com.yuns.board.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yuns.board.model.Contents;
import com.yuns.board.repository.ContentsRepository;
import reactor.core.publisher.Flux;

@RestController
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
}
