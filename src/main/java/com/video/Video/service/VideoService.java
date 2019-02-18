package com.video.Video.service;

import com.video.Video.entity.Video;
import com.video.Video.model.VideoWithoutContent;
import com.video.Video.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    VideoRepository videoRepository;

    public boolean addVideo(Video v){
         try {
             videoRepository.save(v);
         }catch (Exception e){
             return false;
         }
         return true;
    }

    public Video getVideo(int id){
        return videoRepository.findById(id).get();
    }

    public List<VideoWithoutContent> getAllVideoWithoutContent() {
        List<VideoWithoutContent> videoList = new ArrayList<>();
        videoRepository.findAll().forEach(video -> {
            VideoWithoutContent v = new VideoWithoutContent();
            v.setId(video.getId());
            v.setFile_extension(video.getFile_extension());
            v.setFile_name(video.getFile_name());
            videoList.add(v);
        });
        return videoList;
    }

}
