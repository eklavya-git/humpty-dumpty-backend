package com.altius.tiny.controller;

import com.altius.tiny.util.UrlShortenerUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UrlShortenerController {
    Map<String,String> map=new HashMap<>();

    @CrossOrigin
    @PostMapping("/short-url")
    public String getShortURL(@RequestBody String longURL) throws MalformedURLException, URISyntaxException, UnsupportedEncodingException {
        String decodedURL= URLDecoder.decode(longURL, "UTF-8");
        System.out.println("######"+decodedURL);
        URL url= UrlShortenerUtil.validateURl(URLDecoder.decode(longURL, "UTF-8"));
        URL output= new URL(url.getProtocol(), url.getHost(),UrlShortenerUtil.getHashURL(url.getFile()));
        map.put(output.toString(), decodedURL);
        return longURL+"  =====>  "+output;
    }

    @CrossOrigin
    @PostMapping("/long-url")
    public String getLongURL(@RequestBody String shortURL) throws MalformedURLException, URISyntaxException, UnsupportedEncodingException {
        String decodedURL=URLDecoder.decode(shortURL, "UTF-8");
        return map.get(decodedURL);
    }
}
