package com.pract4.entity;

import java.time.LocalDateTime;

public record TeaBrewing(String name, Tea tea, LocalDateTime from,
                         LocalDateTime to, int temp) {
}
