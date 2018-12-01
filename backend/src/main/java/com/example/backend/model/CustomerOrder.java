package com.example.backend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customer_order")
public class CustomerOrder {
    private Long id;
    private String opis;
    private Customer customer;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "opis")
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }


    @ManyToOne
    @JoinColumn(name = "customer_id")
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOrder that = (CustomerOrder) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(opis, that.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, opis);
    }
}
