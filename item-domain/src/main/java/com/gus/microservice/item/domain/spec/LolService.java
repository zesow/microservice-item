package com.gus.microservice.item.domain.spec;

import java.util.Map;

public interface LolService {

    Map<String, Object> findUserMatchHistoryByUsername(String id);
}
