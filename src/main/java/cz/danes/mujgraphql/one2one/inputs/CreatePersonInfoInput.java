package cz.danes.mujgraphql.one2one.inputs;

import cz.danes.mujgraphql.one2one.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePersonInfoInput {
    private String personInfoS;
    private String nationallity;
    private int suma;
//    private Person person;
}
