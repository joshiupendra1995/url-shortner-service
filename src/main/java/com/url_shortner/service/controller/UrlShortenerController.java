package com.url_shortner.service.controller;

import com.url_shortner.service.service.UrlShortenerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/url")
public class UrlShortenerController {
    private final UrlShortenerService service;

    public UrlShortenerController(UrlShortenerService service) {
        this.service = service;
    }

    /**
     *
     * @param longUrl
     * @return shortenUrl
     */
    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam String longUrl) {
        return service.shortenUrl(longUrl);
    }

    /**
     *
     * @param shortUrl
     * @return longUrl
     */
    @GetMapping("/{shortUrl}")
    public String getLongUrl(@PathVariable String shortUrl) {
        return service.getLongUrl(shortUrl);
    }
}

