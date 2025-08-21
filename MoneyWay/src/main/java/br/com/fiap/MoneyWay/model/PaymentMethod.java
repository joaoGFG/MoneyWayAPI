package br.com.fiap.MoneyWay.model;

public class PaymentMethod {
    private Long id;
    private String name;

    
    public PaymentMethod(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
