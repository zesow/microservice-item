package com.gus.microservice.item.logic;

import com.gus.microservice.item.domain.logic.LolLogic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LolSpringLogic extends LolLogic {

}
