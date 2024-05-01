package com.four_bro.deliverium.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class OrderModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @ManyToOne
  @JoinColumn(name = "productId", referencedColumnName = "id")
  private ProductModel product;

  @ManyToOne
  @JoinColumn(name = "userId", referencedColumnName = "id")
  private UserModel user;

  @Column(name = "quantity")
  private Integer quantity;

  @Column(name = "status")
  private String status;
}
