package com.yuns.board.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@NoArgsConstructor
public class Contents {
	@Id
	private String contentsId;
	private String userId;
	private String title;
	private String context;
	private LocalDateTime createTime;
	private LocalDateTime modifyTime;

	public Contents(String userId, String title, String context, LocalDateTime createTime) {
		this.userId = userId;
		this.title = title;
		this.context = context;
		this.createTime = createTime;
	}
}
