package com.chengshi.qixingshe;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class mockServer {
    public static void main(String[] args) throws IOException {
        WireMock.configureFor("localhost", 8082);
        WireMock.removeAllMappings();
        mock("/user/list", "user.json");
    }


    private static void mock(String url, String filename) throws IOException {
        MappingBuilder mappingBuilder = WireMock.get(WireMock.urlEqualTo(url));

        ClassPathResource resource = new ClassPathResource("mock/response/" + filename);
        String content = FileUtils.readFileToString(resource.getFile(), "UTF-8");
        WireMock.stubFor(mappingBuilder.willReturn(WireMock.aResponse().withBody(content).withStatus(200)));
    }
}
