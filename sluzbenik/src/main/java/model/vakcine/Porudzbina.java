package model.vakcine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "porudzbina")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Porudzbina {
    private String vakcina;
    private Integer kolicina;
    private Date datum;
    private PORUDZBINA_STATUS status;

    private String id;
}
