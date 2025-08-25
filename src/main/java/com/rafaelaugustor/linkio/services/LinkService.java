package com.rafaelaugustor.linkio.services;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import com.rafaelaugustor.linkio.domain.Link;
import com.rafaelaugustor.linkio.repositories.LinkRepository;
import com.rafaelaugustor.linkio.rest.dtos.request.LinkRequestDTO;
import com.rafaelaugustor.linkio.rest.dtos.response.LinkResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LinkService {

    private final LinkRepository linkRepository;

    public LinkResponseDTO saveLink(LinkRequestDTO request) {
        final String id = resolveIdFrom(request);
        final String shortUrl = generateShortUrl(id);

        var link = new Link(
                id,
                request.getUrl(),
                shortUrl,
                LocalDateTime.now()
        );
        var saved = linkRepository.save(link);

        return new LinkResponseDTO(saved.getShortUrl());
    }

    public LinkResponseDTO getLink(String id) {
        String url = linkRepository.findById(id)
                .map(Link::getUrl)
                .orElseThrow();
        return new LinkResponseDTO(url);
    }

    private String generateShortUrl(String id) {
        return "https://linkio.rafaelaugustor.dev/" + id;
    }

    private String resolveIdFrom(LinkRequestDTO request) {
        String requested = request.getShortener();
        return (requested != null && !requested.isBlank())
                ? requested
                : NanoIdUtils.randomNanoId();
    }
}