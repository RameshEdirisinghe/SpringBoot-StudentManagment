package edu.icet.service.impl;

import edu.icet.dto.Login;
import edu.icet.entity.LoginEntity;
import edu.icet.repository.LoginDao;
import edu.icet.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final LoginDao loginDao;

    @Override
    public String login(Login login) {
       LoginEntity loginEntity= loginDao.getReferenceById(1);
       if (loginEntity.getEmail().equals(login.getEmail())){
           if (loginEntity.getPassword().equals(login.getPassword())){
               return "success";
           }
           return "fail";
       }
        return "fail";
    }
}
