package io.crunch.catalog;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "model", updatable = false, nullable = false, length = 255)
    private String model;

    @Column(name = "processor", updatable = false, nullable = false, length = 255)
    private String processor;

    @Column(name = "memory", updatable = false, nullable = false, length = 255)
    private String memory;

    @Column(name = "image", updatable = false, nullable = false, length = 255)
    private String image;

    @Column(name = "description", updatable = false, nullable = false, length = 512)
    private String description;

    @Column(name = "quantity", updatable = false, nullable = false)
    private int quantity;

    @Column(name = "status", updatable = false, nullable = false, length = 255)
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }
}
