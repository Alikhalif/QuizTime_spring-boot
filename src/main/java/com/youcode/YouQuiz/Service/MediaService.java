package com.youcode.YouQuiz.Service;

import com.youcode.YouQuiz.dto.MediaDto;

public interface MediaService {
    MediaDto create(MediaDto mediaDto);
    void delete(Integer id);
    MediaDto getOne(Integer id);
}
