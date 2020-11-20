package com.kotlin.demo.controller

import com.kotlin.demo.entity.User
import com.kotlin.demo.respository.DemoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import java.security.MessageDigest
import javax.servlet.http.HttpSession

@Controller
class HtmlController {

    @Autowired
    lateinit var repository:DemoRepository

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("title","index")
        return "index"
    }

    @GetMapping("/{formType}")
    fun htmlForm(model: Model, @PathVariable formType:String ): String {

        var res :String ?= null

        if("sign" == formType) res = "sign"
        else if("login" == formType) res = "login"

        model.addAttribute("title", res)

        return formType
    }

    @PostMapping("/sign")
    fun postSign(model: Model,
                 @RequestParam(value = "id") userId:String,
                 @RequestParam(value = "password") password:String ) : String {
        try {
            var user = repository.save(User(userId, encrypt(password)) )
            println(user.toString())
        } catch (e: Exception){
            e.printStackTrace()
        }

        model.addAttribute("title","home")
        return "welcome"
    }

    @PostMapping("/login")
    fun postLogin(model: Model,
                  session: HttpSession,
            @RequestParam(value = "id") userId: String,
            @RequestParam(value = "password") password: String):String {

        try {
            val cryptoPass = encrypt(password)
            val dbUser = repository.findByUserId(userId)

            if(dbUser != null){
                val dbPass = dbUser.password

                return if(cryptoPass == dbPass){
                    session.setAttribute("userId", dbUser.userId)
                    model.addAttribute("title","welcome")
                    model.addAttribute("userId",userId)
                    "welcome"
                } else {
                    model.addAttribute("title","login")
                    "login"
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        model.addAttribute("title","login")
        return "login";
    }

    fun encrypt(password: String) :String{
        return MessageDigest.getInstance("SHA-256")
                .digest(password.toByteArray())
                .fold("", {str, it -> str + "%02x".format(it)} )
    }

}