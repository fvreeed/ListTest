package org.green;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Measuring {

    private String listName;

    private String methodName;

    private long time;
}
