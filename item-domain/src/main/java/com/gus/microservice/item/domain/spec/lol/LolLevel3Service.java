package com.gus.microservice.item.domain.spec.lol;

import java.util.Map;

public interface LolLevel3Service {

    Map<String, Object> findUserMatchHistoryByUsername(String id);

    Map<String, Object> findUserInfo(String id);


}
