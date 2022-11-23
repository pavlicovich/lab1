package com.example.lab1.Controller;

import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewController
{
    @GetMapping(value = "/encrypt", produces = MediaType.APPLICATION_JSON_VALUE)
    public String encrypt(@RequestParam(name = "name", required = false, defaultValue = "input")String name, Model model)
    {
        return encrypt(name);
    }
    @GetMapping (value = "/decrypt", produces = MediaType.APPLICATION_JSON_VALUE)
    public  String decrypt(@RequestParam(name = "name", required = false, defaultValue =  "input")String name, Model model)
    {
        return decrypt(name);
    }

    private String encrypt(String str)
    {
        String string = "";
        int k = 5;
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z')
            {
                c += k % 26;
                if (c < 'a')
                    c += 26;
                if (c > 'z')
                    c -= 26;
            } else if (c >= 'A' && c <= 'Z')
            {
                c += k % 26;
                if (c < 'A')
                    c += 26;
                if (c > 'Z')
                    c -= 26;
            }
            string += c;
        }
        return string;
    }
    private String decrypt(String str)
    {
        int k = -5;
        String string = "";
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z')
            {
                c += k % 26;
                if (c < 'a')
                    c += 26;
                if (c > 'z')
                    c -= 26;
            } else if (c >= 'A' && c <= 'Z')
            {
                c += k % 26;
                if (c < 'A')
                    c += 26;
                if (c > 'Z')
                    c -= 26;
            }
            string += c;
        }
        return string;
    }
}
