package br.com.kesley.jobextra.controller.form;

import lombok.Getter;

@Getter
public class AddressForm {
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
}