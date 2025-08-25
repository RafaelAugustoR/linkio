package com.rafaelaugustor.linkio.rest.controllers;

import com.rafaelaugustor.linkio.rest.dtos.request.LinkRequestDTO;
import com.rafaelaugustor.linkio.rest.dtos.response.LinkResponseDTO;
import com.rafaelaugustor.linkio.services.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class LinkController {

    private final LinkService linkService;

    @PostMapping("/shorten-url")
    public ResponseEntity<LinkResponseDTO> saveLink(@RequestBody LinkRequestDTO request){
        return ResponseEntity.ok(linkService.saveLink(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> getLink(@PathVariable String id){
        var redirect = linkService.getLink(id);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(redirect.getShortUrl()))
                .build();
    }
}