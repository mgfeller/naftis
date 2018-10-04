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
    private final boolean https;

    public EgressCommand(CommandInput commandInput, boolean https) {
        super(commandInput);
        this.https = https;
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

            String url = https ? "https://httpbin.org/get" : "http://httpbin.org/get";
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
