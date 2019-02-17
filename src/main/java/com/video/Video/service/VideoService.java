package com.video.Video.service;

import com.video.Video.entity.Video;
import com.video.Video.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
