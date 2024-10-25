package mbozkurt.core.messaging.test;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.junit.jupiter.api.Test;

import lombok.extern.java.Log;

@Log
public class TestController {

	@Test
	public void testMessages() {

		callHttpGet("http://localhost:8080/test/messages/fixed", "tr-TR");
		callHttpGet("http://localhost:8080/test/messages/fixed", "en-US");
		callHttpGet("http://localhost:8080/test/messages/param", "tr-TR");
		callHttpGet("http://localhost:8080/test/messages/param", "en-US");
	}

	private void callHttpGet(String url, String acceptLanguageValue) {
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().version(HttpClient.Version.HTTP_2)
					.uri(URI.create(url))
					.headers("Accept-Enconding", "gzip, deflate")
					.headers("Accept-Language", acceptLanguageValue).build();

			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			String responseBody = response.body();
			int responseStatusCode = response.statusCode();

			log.severe("httpGetRequest status code: " + responseStatusCode);
			log.severe("httpGetRequest: " + responseBody);

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
