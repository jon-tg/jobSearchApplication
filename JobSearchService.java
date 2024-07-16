import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class JobSearchService {
    private static final String API_KEY = "b826344945msh42df2aaca0f0af7p174a20jsna8ff390fb6ef";
    private static final String API_HOST = "jsearch.p.rapidapi.com";
    private static final String BASE_URL = "https://jsearch.p.rapidapi.com";
    
    private HttpClient client;
    
    public JobSearchService() {
        this.client = HttpClient.newHttpClient();
    }
    
    public String searchJobs(String query) {
        String jobQuery = formatQuery(query);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/search?query=" + jobQuery + "&page=1&num_pages=10"))
                .header("x-rapidapi-key", API_KEY)
                .header("x-rapidapi-host", API_HOST)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred during HTTP request";
        }
    }
    
    private String formatQuery(String queryBody) {
        String[] queryArray = queryBody.split(" ");
        StringBuilder formattedQuery = new StringBuilder();
        for (String word : queryArray) {
            formattedQuery.append(word);
        }
        return formattedQuery.toString();
    }
}