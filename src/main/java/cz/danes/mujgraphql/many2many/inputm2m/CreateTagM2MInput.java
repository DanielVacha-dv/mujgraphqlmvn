package cz.danes.mujgraphql.many2many.inputm2m;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTagM2MInput {
    private String name;
}