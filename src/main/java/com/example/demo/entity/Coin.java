package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author meow
 */
@Setter
@Getter
@Table(name = "coin")
@Entity
public class Coin extends BaseEntity{

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;
}
