package br.com.kesley.jobextra.controller.form;

import java.time.LocalDate;

import br.com.kesley.jobextra.model.UserCategoryEnum;
import lombok.Getter;

@Getter
public class CreateUserForm {

    private UserCategoryEnum category;
    private String name;
    private String document;
    private LocalDate birthday;
    private String telephone;
    private String email;
    private String password;

}