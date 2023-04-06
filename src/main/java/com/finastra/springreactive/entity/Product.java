package com.finastra.springreactive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private Long id;

    private String name;
}
