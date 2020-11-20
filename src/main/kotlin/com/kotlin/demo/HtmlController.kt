package com.kotlin.demo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class HtmlController {

    @GetMapping("/")
    fun index(): String {
        return "index"
    }

    @GetMapping("/sign")
    fun htmlForm(): String {
        return "sign"
    }
}