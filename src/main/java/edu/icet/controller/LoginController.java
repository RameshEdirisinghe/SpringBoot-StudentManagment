package edu.icet.controller;

import edu.icet.dto.Login;
import edu.icet.dto.Student;
import edu.icet.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService service;
    @PostMapping("/check")
    public void setLogin(@RequestBody Login login){
        service.login(login);
    }
}
