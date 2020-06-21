package com.gus.microservice.item.domain.spec.lol;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface LolLevel2Service {

    String summonersByName(String id) throws IOException;

    List<Map<String, Object>> matchlistsByAccount(String encryptedAccountId) throws IOException;
}
