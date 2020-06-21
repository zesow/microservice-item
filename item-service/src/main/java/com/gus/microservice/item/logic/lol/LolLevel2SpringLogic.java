package com.gus.microservice.item.logic.lol;

import com.gus.microservice.item.domain.logic.lol.LolLevel2Logic;
import com.gus.microservice.item.domain.logic.lol.LolLevel3Logic;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LolLevel2SpringLogic extends LolLevel2Logic {

}
