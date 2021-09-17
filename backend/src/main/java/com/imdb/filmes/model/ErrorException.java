package com.imdb.filmes.model;

import java.io.Serializable;

public class ErrorException implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer status;

    private String message;

    public ErrorException(){}

    public ErrorException(Integer status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

}