package com.example.carros.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String get() {
        return "Get Spring Boot";
    }

    @GetMapping("login")
    public String post(@RequestParam("login") String login, @RequestParam("senha") String senha) {
        return "Login: " + login + "/ Senha: " + senha + ".";
    }

    // POST - RequestParam
    @PostMapping("login")
    public String login(@RequestParam("login") String login, @RequestParam("senha") String senha) {
        return "Login: " + login + "/ Senha: " + senha + ".";
    }

    // @PathVariable
    @GetMapping("login/{login}/senha/{senha}")
    public String post2(@PathVariable("login") String login, @PathVariable("senha") String senha) {
        return "Login: " + login + "/ Senha: " + senha + ".";
    }

}
