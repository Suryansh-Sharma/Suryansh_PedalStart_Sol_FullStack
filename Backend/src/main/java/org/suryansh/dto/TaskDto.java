package org.suryansh.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TaskDto(int id,
                      String title,
                      String description,
                      LocalDateTime generatedOn,
                      LocalDate dueDate) {
}
