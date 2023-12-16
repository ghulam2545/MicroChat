package com.ghulam.mitter.dto.request;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TweetRequestDto {
    private String content;
    private String mediaUrl;
    private List<String> hashtags = new ArrayList<>();
    private String tweeter;
}
