package com.varejo360.backend.dto;

import com.varejo360.backend.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

public class ProductDto {
    @NotNull(message = "Value can not be null")
    private Long user_id;

    @NotNull(message = "Value can not be null")
    private long code;

    @NotNull(message = "Value can not be null")
    private String name;


    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
