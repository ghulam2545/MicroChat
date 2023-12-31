package com.ghulam.microchat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_links")
public class Links {

    @Id
    private String linkId;
    private String instagram;
    private String facebook;
    private String youtube;
}
