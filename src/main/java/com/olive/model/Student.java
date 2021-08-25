package com.olive.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="std_tab")
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {
@Id
private int id;
private String name;
private double sal;
private String address;
}
