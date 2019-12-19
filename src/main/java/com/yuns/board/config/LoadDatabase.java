package com.yuns.board.config;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yuns.board.model.Contents;
import com.yuns.board.repository.ContentsRepository;
import reactor.core.publisher.Flux;

@Configuration
public class LoadDatabase {
	@Bean
	CommandLineRunner init(ContentsRepository contentsRepository) {
		return args -> {
			Flux.just(
				new Contents("작성자", "제목", "내용", LocalDateTime.now()),
				new Contents("작성자", "제목", "내용", LocalDateTime.now()),
				new Contents("작성자", "제목", "내용", LocalDateTime.now()))
				.flatMap(contentsRepository::save)
				.subscribe(System.out::println);
		};
	}
}
