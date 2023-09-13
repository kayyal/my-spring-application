package ir.neshan.myspringapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GlobalMessage {
    private String foodName;
    private Integer remainingCount;
}
