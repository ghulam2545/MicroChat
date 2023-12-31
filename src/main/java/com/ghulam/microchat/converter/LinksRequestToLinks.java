package com.ghulam.microchat.converter;

import com.ghulam.microchat.dto.request.LinksRequest;
import com.ghulam.microchat.model.Links;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LinksRequestToLinks implements Converter<LinksRequest, Links> {
    @Override
    public Links convert(LinksRequest source) {
        Links links = new Links();

        links.setInstagram(source.instagram());
        links.setFacebook(source.facebook());
        links.setYoutube(source.youtube());

        return links;
    }
}
