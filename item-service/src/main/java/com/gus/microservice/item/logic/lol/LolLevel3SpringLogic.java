package com.gus.microservice.item.logic.lol;

import com.gus.microservice.item.domain.lifecycle.ServiceLifecycle;
import com.gus.microservice.item.domain.logic.lol.LolLevel3Logic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LolLevel3SpringLogic extends LolLevel3Logic {

}
