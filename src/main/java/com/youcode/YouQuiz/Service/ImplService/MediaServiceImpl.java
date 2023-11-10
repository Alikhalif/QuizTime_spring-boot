package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Service.MediaService;
import com.youcode.YouQuiz.dto.MediaDto;
import com.youcode.YouQuiz.dto.QuestionDto;
import com.youcode.YouQuiz.entities.Level;
import com.youcode.YouQuiz.entities.Media;
import com.youcode.YouQuiz.entities.Question;
import com.youcode.YouQuiz.entities.Subject;
import com.youcode.YouQuiz.repositories.MediaRepository;
import com.youcode.YouQuiz.repositories.QuestionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class MediaServiceImpl implements MediaService {
    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MediaDto create(MediaDto mediaDto){
        Media media = modelMapper.map(mediaDto, Media.class);


        if(mediaDto.getQuestion_id() != null){
            Question question = questionRepository.findById(mediaDto.getQuestion_id())
                    .orElseThrow(()-> new EntityNotFoundException("Question not found"));
            media.setQuestion(question);
        }

        media = mediaRepository.save(media);
        return modelMapper.map(media, MediaDto.class);
    }

    @Override
    public void delete(Integer id){
        Media media = mediaRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Question not found with id "+id));
        mediaRepository.delete(media);
    }

    @Override
    public MediaDto getOne(Integer id){
        Media media = mediaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Media not found with id "+id));
        return modelMapper.map(media, MediaDto.class);
    }
}
