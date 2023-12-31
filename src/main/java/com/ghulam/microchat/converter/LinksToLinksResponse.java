package com.ghulam.microchat.converter;

import com.ghulam.microchat.dto.response.LinkResponse;
import com.ghulam.microchat.model.Links;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LinksToLinksResponse implements Converter<Links, LinkResponse> {
    @Override
    public LinkResponse convert(Links source) {
        return new LinkResponse(
                source.getLinkId(),
                source.getInstagram(),
                source.getFacebook(),
                source.getYoutube()
        );
    }
}
