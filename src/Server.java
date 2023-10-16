import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Server {
    /**
     * @param username  not the mcuuid like actaul username. is case sensitive
     * @param serverId  the server id the client connected too. read readme for more info
     * @param ipAddress optional. set too null or empty when you dont want to prove it. makes it so they tell you if the client requested to join that server with that ip → anti proxy
     * @return returns true if the client actually wants to connect to that server id. read readme for security info
     */
    public static boolean verifyPlayer(String username, String serverId, String ipAddress) {
        try {
            String loginHash = (serverId);

            // Create an HTTP client
            CloseableHttpClient httpClient = HttpClients.createDefault();

            // Build the URL for the HTTP GET request
            StringBuilder urlBuilder = new StringBuilder("https://sessionserver.mojang.com/session/minecraft/hasJoined");
            urlBuilder.append("?username=").append(username);
            urlBuilder.append("&serverId=").append(loginHash);

            if (ipAddress != null && !ipAddress.isEmpty()) {
                urlBuilder.append("&ip=").append(ipAddress);
            }

            // Create an HTTP GET request
            HttpGet request = new HttpGet(urlBuilder.toString());

            // Execute the request
            HttpResponse response = httpClient.execute(request);

            System.out.println(response);

            // Check the response status code
            int statusCode = response.getStatusLine().getStatusCode();

            // Close the HTTP client
            httpClient.close();

            // If the response code is 200 (OK), it's a success
            return statusCode == 200;
            //You can actually open the url on browser but it only opens if the code is ok.
        } catch (Exception e) {
            e.printStackTrace();
            return false; // An error occurred
        }
    }
}
