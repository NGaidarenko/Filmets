package com.example.filmets.service.serviceImpl;

import com.example.filmets.dto.TicketRequest;
import com.example.filmets.entity.Ticket;
import com.example.filmets.repository.ScreeningRepository;
import com.example.filmets.repository.TicketRepository;
import com.example.filmets.service.serviceInterface.ScreeningService;
import com.example.filmets.service.serviceInterface.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ScreeningService screeningService;

    //Обработать ошибку
    @Override
    public Ticket getTicket(int id) {
        return ticketRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Ticket not found with id " + id));
    }

    @Override
    public Ticket createTicket(TicketRequest ticketRequest) {
        Ticket ticket = new Ticket();
        ticket.setCustomerName(ticketRequest.getCustomerName());
        ticket.setScreening(screeningService.getScreeningById(ticketRequest.getScreeningId()));
        ticket.setSeatNumber(ticketRequest.getSeatNumber());

        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(int id) {
        ticketRepository.deleteById(id);
    }
}
