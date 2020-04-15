package com.zcpt.projects;

import com.zcpt.pojo.projects.Answer;

public interface IAnswerService {


    Integer insertAnswer(Answer answer);

    Integer deleteAnswer(Integer id);

    Integer updateAnswer(Answer answer);
}
