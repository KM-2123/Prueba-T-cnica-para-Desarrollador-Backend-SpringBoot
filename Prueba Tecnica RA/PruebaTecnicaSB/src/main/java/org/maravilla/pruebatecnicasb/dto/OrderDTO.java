package org.maravilla.pruebatecnicasb.dto;

public class OrderDTO {
    private Long id;
    private String customerName;

    public OrderDTO() {
        // Constructor vacío
    }

    // Constructor con parámetros
    public OrderDTO(Long id, String customerName) {
        this.id = id;
        this.customerName = customerName;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
