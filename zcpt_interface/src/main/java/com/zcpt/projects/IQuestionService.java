package com.zcpt.projects;


import com.zcpt.pojo.projects.Question;

import java.util.List;

public interface IQuestionService {

    List<Question> findQuestionByProId(Integer projectId);

    Integer insertQuestion(Question question);

    Integer deleteQuestion(Integer id);
}
