package com.quiz.quiz.controller;

import com.quiz.quiz.repository.QuestionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final QuestionRepository questionRepository;

    public HomeController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    // Home page
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // View questions page
    @GetMapping("/view-questions")
    public String viewQuestions(Model model) {
        model.addAttribute("questions", questionRepository.findAll());
        return "questions";
    }
}

