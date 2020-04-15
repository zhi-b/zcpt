package com.zcpt.mapper.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zcpt.mapper.AnswerMapper;
import com.zcpt.pojo.projects.Answer;
import com.zcpt.projects.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class AnswerServiceImpl implements IAnswerService {
    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public Integer insertAnswer(Answer answer) {
        return answerMapper.insert(answer);
    }

    @Override
    public Integer deleteAnswer(Integer id) {
        return answerMapper.deleteById(id);
    }

    @Override
    public Integer updateAnswer(Answer answer) {
        return answerMapper.updateById(answer);
    }
}
