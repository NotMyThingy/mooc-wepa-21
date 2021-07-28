package todoapplication;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Todo extends AbstractPersistable<Long>{

    private String name;
    private Integer checked;

}
