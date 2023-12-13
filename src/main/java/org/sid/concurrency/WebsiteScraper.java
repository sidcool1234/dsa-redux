package org.sid.concurrency;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

// This Code is copied from the Grok AI Model by X (FKA Twitter)
public class WebsiteScraper {
    public static void main(String[] args) {
        List<String> urls = List.of("https://google.com", "https://www.example.com");
        List<CompletableFuture<List<String>>> futures = new ArrayList<>();

        for (String url : urls) {
            CompletableFuture<List<String>> future = CompletableFuture.supplyAsync(() -> scrapeWebsite(url, "li"));
            futures.add(future);
        }

        CompletableFuture<List<String>> combinedResults = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .flatMap(List::stream)
                        .collect(Collectors.toList()));

        try {
            List<String> results = combinedResults.get();
            System.out.println("Results: " + results);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Main Thread Done! " + Thread.currentThread().getName());
    }

    private static List<String> scrapeWebsite(String url, String htmlElement) {
        System.out.println("Running" + Thread.currentThread().getName());
        List<String> results = new ArrayList<>();

        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select(htmlElement);

            for (Element element : elements) {
                results.add(element.text());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return results;
    }
}
