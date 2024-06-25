package com.employeemanagement;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee extends Person {
    private BigDecimal salary;
    private String role;

    public Employee(String name, LocalDate dateOfBirth, BigDecimal salary, String role) {
        super(name, dateOfBirth);
        this.salary = salary;
        this.role = role;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Nome: " + getName() + 
               ", Data de Aniversário: " + getDateOfBirth().format(formatter) +
               ", Salário: " + String.format("%,.2f", salary).replace('.', ',') +
               ", Função: " + role;
    }
}
