package net.mgfeller.naftis;

import io.micrometer.core.instrument.util.StringEscapeUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;

public class EgressCommand extends AbstractCommand {

    private final static Logger LOGGER = LoggerFactory.getLogger(EgressCommand.class);
    private final String url;

    public EgressCommand(CommandInput commandInput, boolean https) {
        super(commandInput);
        String uri = commandInput.getParameters().getOrDefault("uri", "httpbin.org/get");
        url = String.format("%s://%s", https ? "https" : "http", uri);
    }

    @Override
    protected String run() {
        try {
            SSLContext sslContext = new SSLContextBuilder()
                    .loadTrustMaterial(null, (certificate, authType) -> true).build();

            CloseableHttpClient client = HttpClients.custom()
                    .setSSLContext(sslContext)
                    .setSSLHostnameVerifier(new NoopHostnameVerifier())
                    .build();

            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("Accept", "text/html");

            HttpResponse response = client.execute(httpGet);
            HttpEntity entity = response.getEntity();

            String responseString = EntityUtils.toString(entity, "UTF-8");
            LOGGER.info(String.format("Response code: %d, body: %s",
                    response.getStatusLine().getStatusCode(), responseString));
            return String.format("Response code: %d, body: %s",
                    response.getStatusLine().getStatusCode(), StringEscapeUtils.escapeJson(responseString));
        } catch (Exception ex) {
            String message = "EXCEPTION: " + ex.getMessage();
            LOGGER.warn(message);
            return message;
        }
    }
}
