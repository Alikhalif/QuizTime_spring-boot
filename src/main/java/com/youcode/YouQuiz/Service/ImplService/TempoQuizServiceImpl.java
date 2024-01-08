package com.youcode.YouQuiz.Service.ImplService;

import com.youcode.YouQuiz.Service.TempoQuizService;
import com.youcode.YouQuiz.dto.TempoResponse.TempoQuizResponseDto;
import com.youcode.YouQuiz.dto.TompQuizDto;
import com.youcode.YouQuiz.entities.Question;
import com.youcode.YouQuiz.entities.Quiz;
import com.youcode.YouQuiz.entities.TompQuiz;
import com.youcode.YouQuiz.repositories.QuestionRepository;
import com.youcode.YouQuiz.repositories.QuizRepository;
import com.youcode.YouQuiz.repositories.TompQuizRepository;
import com.youcode.YouQuiz.tool.TempID;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TempoQuizServiceImpl implements TempoQuizService {
    @Autowired
    private TompQuizRepository tompquizRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public TompQuizDto create(TompQuizDto tompQuizDto){
        TompQuiz tompQuiz = modelMapper.map(tompQuizDto, TompQuiz.class);
        Question question = questionRepository.findById(tompQuizDto.getQuestion_id())
                .orElseThrow(() -> new EntityNotFoundException("not found question with id : "+tompQuizDto.getQuestion_id()));
        tompQuiz.setQuestion(question);

        Quiz quiz = quizRepository.findById(tompQuizDto.getQuiz_id())
                .orElseThrow(() -> new EntityNotFoundException("not found quiz with id : "+tompQuizDto.getQuiz_id()));
        tompQuiz.setQuiz(quiz);

        TempID tempID = new TempID(
                tompQuizDto.getQuiz_id(),
                tompQuizDto.getQuestion_id()
        );

        if (tompquizRepository.existsById(tempID)){
            throw new EntityNotFoundException("Question already assigned to the quiz");
        }else {
            tompQuiz.setId(tempID);
        }

        tompQuiz.setTime(tompQuiz.getTime());

        tompQuiz = tompquizRepository.save(tompQuiz);
        return modelMapper.map(tompQuiz, TompQuizDto.class);
    }

    @Override
    public void delete(Long quiz_id, Long question_id){
        TempID tempID = new TempID(
                quiz_id,
                question_id
        );
        TompQuiz tompQuiz = tompquizRepository.findById(tempID)
                .orElseThrow(() -> new EntityNotFoundException("temp quiz not find with id: "+tempID));
        tompquizRepository.delete(tompQuiz);
    }

    @Override
    public TompQuizDto update(Long quiz_id, Long question_id, TompQuizDto tompQuizDto){
        TempID tempID = new TempID(
                quiz_id,
                question_id
        );

        TompQuiz tompQuizUpdated = tompquizRepository.findById(tempID)
                .orElseThrow(() -> new EntityNotFoundException("temp quiz not find with id: "+tempID));

        tompQuizUpdated.setTime(tompQuizDto.getTime());

        tompQuizUpdated = tompquizRepository.save(tompQuizUpdated);
        return modelMapper.map(tompQuizUpdated, TompQuizDto.class);
    }


    @Override
    public List<TempoQuizResponseDto> findTempoByQuiz(Long quizId) {
        List<TompQuiz> tempoQuizzes = tompquizRepository.findByQuizId(quizId);
        List<TempoQuizResponseDto> tempoQuizResponses = new ArrayList<>();

        for (TompQuiz tempoQuiz : tempoQuizzes) {

            TempoQuizResponseDto tompQuizDto = new TempoQuizResponseDto();

            tompQuizDto.setQuestion_text(questionRepository.getOne(tempoQuiz.getQuestion().getId()).getQuestionText());
            tompQuizDto.setQuestion_id(tempoQuiz.getQuestion().getId());
            tompQuizDto.setQuiz_id(tempoQuiz.getQuiz().getId());
            tompQuizDto.setTime(tempoQuiz.getTime());
            //TompQuizDto tempoQuizDtoResponse = modelMapper.map(tempoQuiz, TompQuizDto.class);
            tempoQuizResponses.add(tompQuizDto);
        }
        System.out.println(tempoQuizResponses);
        return tempoQuizResponses;
    }

}
