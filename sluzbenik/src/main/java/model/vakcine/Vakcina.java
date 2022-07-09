package model.vakcine;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vakcina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vakcina {

    private long id;
    private String naziv;
    private int kolicina;
}
