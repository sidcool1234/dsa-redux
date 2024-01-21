package org.sid.concurrency;


import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// This Code is copied from the Grok AI Model by X (FKA Twitter)
public class WebsiteScraper {
    public static void main(String[] args) {
        var executor1 = Executors.newVirtualThreadPerTaskExecutor();
        benchmarkThreads(executor1);
        executor1.shutdown();
//        Runtime.getRuntime().gc();
//        var executor2 = Executors.newWorkStealingPool();
//        benchmarkThreads(executor2);
//        executor2.shutdown();
//        benchmarkThreads(Executors.newSingleThreadExecutor());

        System.out.println("Main Thread Done! " + Thread.currentThread().getName());
    }

    private static void benchmarkThreads(ExecutorService executor) {
        List<String> urls = getUrls();
        List<CompletableFuture<List<String>>> futures = new ArrayList<>();

        long time = System.currentTimeMillis();

        for (String url : urls) {
            CompletableFuture<List<String>> future = CompletableFuture.supplyAsync(() -> scrapeWebsite(url, "body"), executor);
            futures.add(future);
        }

        CompletableFuture<List<String>> combinedResults = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream()
                        .map(CompletableFuture::join)
                        .flatMap(List::stream)
                        .collect(Collectors.toList()));

        try {
            combinedResults.get().stream().count();
//            System.out.println("Results: " + results);
            System.out.println("Time = " + (System.currentTimeMillis() - time));
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


    }

    @NotNull
    private static List<String> getUrls() {
        var list = List.of("https://google.com", "https://www.example.com", "https://www.falabella.com", "https://www.discord.com", "https://www.sony.co.uk",
                "https://google.com", "https://www.example.com", "https://www.falabella.com", "https://www.discord.com", "https://www.sony.co.uk",
                "https://google.com", "https://www.example.com", "https://www.falabella.com", "https://www.discord.com", "https://www.sony.co.uk",
                "https://google.com", "https://www.example.com", "https://www.falabella.com", "https://www.discord.com", "https://www.sony.co.uk");

        var returnval = new ArrayList<>(list);
        IntStream.range(0, 20).forEach(t -> returnval.addAll(list));
        System.out.println(returnval.size());
        return returnval;
    }

    private static List<String> scrapeWebsite(String url, String htmlElement) {
//        System.out.println("Running" + Thread.currentThread());
        List<String> results = new ArrayList<>();

        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select(htmlElement);

            for (Element element : elements) {
                results.add(element.text());
            }

        } catch (IOException e) {
//            System.err.println(e + "for "+ url);
            results.add("error");
        }

        return results;
    }
}
