package com.nyrta1.eduhub.controller;

import com.nyrta1.eduhub.service.VideoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/video")
@RequiredArgsConstructor
public class VideoController {
    private final VideoService videoService;

    @GetMapping("/stream/{fileType}/{fileName}")
    public Mono<ResponseEntity<byte[]>> streamVideo(@RequestHeader(value = "Range", required = false) String httpRangeList,
                                                    @PathVariable("fileType") String fileType,
                                                    @PathVariable("fileName") String fileName) {
        return Mono.just(videoService.streamVideo(fileName, fileType, httpRangeList));
    }
}
