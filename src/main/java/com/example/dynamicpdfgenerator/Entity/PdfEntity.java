package com.example.dynamicpdfgenerator.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter @Setter
public class PdfEntity {
    private String seller;
    @Id
    private String sellerGstin;
    private String sellerAddress;
    private String buyer;
    @Id
    private String buyerGstin;
    private String buyerAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Items> itemsList = new ArrayList<>();
}
