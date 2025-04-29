package com.practica.libros.servicios;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class LibroHttpClient {
    private static final String BASE_URL = "http://localhost:8080/api/libros";
    private final HttpClient httpClient;

    public LibroHttpClient() {
        this.httpClient = HttpClient.newHttpClient();
    }

    // GET: Obtener todos los libros
    public String getAllLibros() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        handleHttpResponse(response);
        return response.body();
    }

    // GET: Obtener libro por ID
    public String getLibroById(Long id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        handleHttpResponse(response);
        return response.body();
    }

    // POST: Crear un libro con titulo, autor, genero y fecha
    public String createLibro(String titulo, String autor, String genero, String fecha) throws IOException, InterruptedException {
        String json = String.format(
                "{\"titulo\":\"%s\", \"autor\":\"%s\", \"genero\":\"%s\", \"fecha\":\"%s\"}",
                titulo, autor, genero, fecha
        );
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        handleHttpResponse(response);
        return response.body();
    }

    // PUT: Actualizar un libro con titulo, autor, genero y fecha
    public String updateLibro(Long id, String titulo, String autor, String genero, String fecha) throws IOException, InterruptedException {
        String json = String.format(
                "{\"titulo\":\"%s\", \"autor\":\"%s\", \"genero\":\"%s\", \"fecha\":\"%s\"}",
                titulo, autor, genero, fecha
        );
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        handleHttpResponse(response);
        return response.body();
    }

    // DELETE: Eliminar un libro por ID
    public String deleteLibro(Long id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/" + id))
                .DELETE()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        handleHttpResponse(response);
        return response.body();
    }

    // Manejo básico de respuestas HTTP no exitosas
    private void handleHttpResponse(HttpResponse<String> response) {
        if (response.statusCode() < 200 || response.statusCode() >= 300) {
            throw new RuntimeException("Error HTTP: " + response.statusCode() + " - " + response.body());
        }
    }
}
