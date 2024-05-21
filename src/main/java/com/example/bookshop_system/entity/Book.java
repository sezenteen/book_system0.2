package com.example.bookshop_system.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book extends BaseEntity{

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private BigDecimal price;

    private Integer copies;
    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Enumerated(EnumType.ORDINAL)
    private Restriction ageRestriction;

    @Enumerated(EnumType.ORDINAL)
    private EditionType editionType;

    @ManyToOne
    private Author author;

    @ManyToMany
    private Set<Category> categories;

//    public Book(String title, String description, BigDecimal price, Integer copies, LocalDateTime releaseDate, Restriction ageRestriction, EditionType editionType, Author author, Set<Category> categories) {
//        this.title = title;
//        this.description = description;
//        this.price = price;
//        this.copies = copies;
//        this.releaseDate = releaseDate;
//        this.ageRestriction = ageRestriction;
//        this.editionType = editionType;
//        this.author = author;
//        this.categories = categories;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Restriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(Restriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public EditionType getEditionType() {
        return editionType;
    }

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
