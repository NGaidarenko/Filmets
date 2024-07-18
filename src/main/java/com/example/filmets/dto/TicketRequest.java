package com.example.filmets.dto;

import com.example.filmets.entity.Screening;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequest {
    private String title;
    private int screeningId;
    private String customerName;
    private String seatNumber;
}
