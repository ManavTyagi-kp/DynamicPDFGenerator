package com.example.dynamicpdfgenerator.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter @Setter
public class Items<PdfEntity> {
    @Id
    private String itemName;
    private String quantity;
    private float rate;
    private float amount;
}
