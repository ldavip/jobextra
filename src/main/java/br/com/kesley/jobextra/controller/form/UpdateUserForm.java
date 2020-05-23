package br.com.kesley.jobextra.controller.form;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class UpdateUserForm {
    private String name;
    private LocalDate birthday;
    private String telephone;
    private AddressForm address;
}