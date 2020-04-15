package com.zcpt.mapper.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zcpt.mapper.AnswerMapper;
import com.zcpt.mapper.QuestionMapper;
import com.zcpt.pojo.projects.Answer;
import com.zcpt.pojo.projects.Question;
import com.zcpt.projects.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private AnswerMapper answerMapper;
    @Override
    public List<Question> findQuestionByProId(Integer projectId) {
        List<Question> questionList = questionMapper.selectList(new QueryWrapper<Question>()
                .eq("project_id", projectId));
        if(questionList != null){
            for(Question question : questionList){
                List<Answer> answerList = answerMapper.selectList(new QueryWrapper<Answer>()
                        .eq("que_id", question.getId()));
                question.setAnswerList(answerList);
            }
        }
        return questionList;
    }

    @Override
    public Integer insertQuestion(Question question) {
        return questionMapper.insert(question);
    }

    @Override
    public Integer deleteQuestion(Integer id) {
        return questionMapper.deleteById(id);
    }
}
