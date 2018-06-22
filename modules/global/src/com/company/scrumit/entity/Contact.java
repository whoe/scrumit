package com.company.scrumit.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;
import javax.persistence.OneToMany;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import javax.validation.constraints.NotNull;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.OneToOne;

@NamePattern("%s %s|fio,email")
@Table(name = "SCRUMIT_CONTACT")
@Entity(name = "scrumit$Contact")
public class Contact extends StandardEntity {
    private static final long serialVersionUID = 6007970334363923354L;

    @NotNull
    @Column(name = "FIO", nullable = false)
    protected String fio;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    protected City city;

    @NotNull
    @Column(name = "EMAIL", nullable = false)
    protected String email;

    @Column(name = "PHONE")
    protected String phone;

    @Column(name = "COMMENTS")
    protected String comments;


    @OneToMany(mappedBy = "contact")
    protected List<ContactSpeciality> specialities;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "contact")
    protected Performer performer;

    public void setPerformer(Performer performer) {
        this.performer = performer;
    }

    public Performer getPerformer() {
        return performer;
    }


    public void setCity(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }


    public void setSpecialities(List<ContactSpeciality> specialities) {
        this.specialities = specialities;
    }

    public List<ContactSpeciality> getSpecialities() {
        return specialities;
    }


    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getComments() {
        return comments;
    }


}