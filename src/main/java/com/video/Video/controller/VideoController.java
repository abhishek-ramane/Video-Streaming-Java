package com.video.Video.controller;

import java.io.IOException;
import java.io.OutputStream;

import com.video.Video.entity.Video;
import com.video.Video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;


@RestController
public class VideoController {

	@Autowired
	private VideoService service;

	@CrossOrigin("http://localhost:4200")
	@PostMapping("/upload/video")
	public String addVideo(@RequestParam("file") MultipartFile file) {
		Video v = new Video();
		try {
			v.setFile_name(file.getOriginalFilename());
			v.setFile_extension(file.getContentType().split("/")[1]);
			v.setFile_content(file.getBytes());
			service.addVideo(v);
		} catch (IOException e) {
			return "failed to upload";
		}
		return "Uploaded Sucessfully";
	}

	@GetMapping("/video/{id}")
	public StreamingResponseBody getVideoByID(@PathVariable int id, @RequestHeader String range) {
		Video video = service.getVideo(id);
		byte[] file_content = video.getFile_content();
		int file_size = video.getFile_content().length;
		range = range.substring(range.indexOf('=') + 1, range.length());
		int to = file_size;
		int from = Integer.parseInt(range.split("-")[0]);
		return new StreamingResponseBody(){

			@Override
			public void writeTo(OutputStream stream) throws IOException {
				stream.write(file_content, from, from + to);
			}
		};
	}

	@GetMapping("/upload/test")
	public String addVideo1() {
		return "tested (Server is up)";
	}
}
