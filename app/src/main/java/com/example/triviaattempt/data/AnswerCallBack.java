package com.example.triviaattempt.data;

import com.example.triviaattempt.model.Question;

import java.util.ArrayList;

public interface AnswerCallBack {

    void processFinished(ArrayList<Question> questionArrayList);
}
