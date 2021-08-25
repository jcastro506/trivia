package com.example.triviaattempt.data;

import android.app.Application;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.triviaattempt.controller.AppController;
import com.example.triviaattempt.model.Question;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Repository {

    private String url = "https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements-data.json";
    private ArrayList<Question> allQuestions = new ArrayList<>();

    public List<Question> getAllQuestions(final AnswerCallBack callBack) {

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            for (int i = 0; i < response.length(); i++) {
                try {
                    Question question = new Question(response.getJSONArray(i).getString(0), response.getJSONArray(i).getBoolean(1));
                    allQuestions.add(question);
                    Log.d("Questions", "getAllQuestions: " + question);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, error -> {
            Log.d("Questions", "getAllQuestions: This failed miserably");
        });

        if (null != callBack) callBack.processFinished(allQuestions);

        AppController.getInstance().addToRequestQueue(jsonArrayRequest);
            return null;
    }
}
