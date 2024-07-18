package com.example.filmets.service.serviceInterface;

import com.example.filmets.dto.TicketRequest;
import com.example.filmets.entity.Ticket;
import org.springframework.stereotype.Service;

@Service
public interface TicketService {
    Ticket getTicket(int id);
    Ticket createTicket(TicketRequest ticketRequest);
    void deleteTicket(int id);
}
