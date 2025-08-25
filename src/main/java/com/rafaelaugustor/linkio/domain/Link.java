package com.rafaelaugustor.linkio.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "links")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {

    @Id
    private String id;

    private String url;

    private String shortUrl;

    @Indexed(expireAfter = "10m")
    private LocalDateTime expirationDate;
}
