package com.nyrta1.eduhub.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface VideoService {
    ResponseEntity<byte[]> streamVideo(String fileName, String fileType, String range);
    String saveVideo(MultipartFile videoFile);
    boolean deleteVideo(String fileName) throws IOException;
}
