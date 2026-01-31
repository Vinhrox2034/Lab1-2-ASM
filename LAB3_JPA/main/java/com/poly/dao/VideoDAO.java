package com.poly.dao;
import com.poly.entity.Video;
import java.util.List;

public interface VideoDAO {
    List<Video> findAll();
    List<Video> findByKeyword(String keyword);
    Video findById(String id);
    Video create(Video entity);
    Video update(Video entity);
    void deleteById(String id);

}
