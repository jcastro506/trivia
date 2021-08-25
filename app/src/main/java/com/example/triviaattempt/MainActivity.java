package com.example.triviaattempt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;

import com.android.volley.toolbox.Volley;
import com.example.triviaattempt.controller.AppController;
import com.example.triviaattempt.data.AnswerCallBack;
import com.example.triviaattempt.data.Repository;
import com.example.triviaattempt.databinding.ActivityMainBinding;
import com.example.triviaattempt.model.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        List<Question> questions = new Repository().getAllQuestions(questionArrayList -> {
            Log.d("Q's", "onCreate: " + questionArrayList);
        });


    }
}