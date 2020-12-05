package cz.danes.mujgraphql.one2one.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAgeInput {
    private long id;
    private int age;

}
