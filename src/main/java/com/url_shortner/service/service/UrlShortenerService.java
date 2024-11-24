package com.url_shortner.service.service;

import com.url_shortner.service.entity.UrlMapping;
import com.url_shortner.service.repository.UrlMappingRepository;
import com.url_shortner.service.utils.Base62Util;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UrlShortenerService {

    private final UrlMappingRepository urlMappingRepository;

    public UrlShortenerService(UrlMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    /**
     *
     * @param longUrl
     * @return shortenUrl
     */
    public String shortenUrl(String longUrl) {
        UrlMapping existing = urlMappingRepository.findByLongUrl(longUrl);
        if (existing != null) {
            return existing.getShortUrl();
        }
        UrlMapping urlMapping = new UrlMapping();
        urlMapping.setLongUrl(longUrl);
        urlMapping.setShortUrl(generateShortUrl());
        urlMappingRepository.save(urlMapping);
        return urlMapping.getShortUrl();
    }

    /**
     *
     * @param shortUrl
     * @return long url if not found then return with the shorturl
     */
    public String getLongUrl(String shortUrl) {
        UrlMapping urlMapping = urlMappingRepository.findByShortUrl(shortUrl);
        return Optional.ofNullable(urlMapping).map(UrlMapping::getLongUrl).orElse(shortUrl);
    }

    /**
     * @return shortUrl
     */
    private String generateShortUrl() {
        long id = urlMappingRepository.count() + 1;
        return Base62Util.encode(id);
    }
}

