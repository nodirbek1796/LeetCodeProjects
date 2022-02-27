package SecondTaskInNUU;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewResult {
    private Integer orderNumber; // nominal qiymat tartib raqami
    private HashMap<Float, Float> gradationNumbersAndFunctionValues;
}
