package com.slmanju.hrms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = { "/" })
    public ResponseEntity<Message> index() {
        return ResponseEntity.ok(new Message("Welcome to hrms"));
    }

    @Getter @Setter @AllArgsConstructor
    private class Message {
        private String text;
    }

}
