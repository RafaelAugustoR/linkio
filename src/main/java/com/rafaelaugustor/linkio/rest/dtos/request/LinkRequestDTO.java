package com.rafaelaugustor.linkio.rest.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkRequestDTO {
    private String url;
    private String shortener;
}
