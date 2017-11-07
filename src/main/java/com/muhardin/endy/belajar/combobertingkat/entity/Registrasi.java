package com.muhardin.endy.belajar.combobertingkat.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity @Data
public class Registrasi {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotNull @NotEmpty @Email
    private String email;

    @NotNull @NotEmpty
    private String password;

    @NotNull @NotEmpty
    private String nama;

    @NotNull @NotEmpty
    private String alamat;

    @NotNull @NotEmpty
    private String kelurahan;
}
