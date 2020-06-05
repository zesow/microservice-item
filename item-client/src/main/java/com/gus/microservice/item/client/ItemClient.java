/*===================================================================================
 *                    Copyright(c) 2019 Gus
 *
 * Project            : item-client
 * Source File Name   : com.gus.microservice.item.client.ItemClient.java
 * Description        :
 * Author             : user
 * Version            : 1.0.0
 * File Name related  :
 * Class Name related :
 * Created Date       : 2019. 4. 4.
 * Updated Date       : 2019. 4. 4.
 * Last modifier      : user
 * Updated content    : 최초작성
 *
 *==================================================================================*/
package com.gus.microservice.item.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//import com.gus.microservice.item.domain.entity.Item;

/**
 * ItemClient.java
 *
 * @author user
 * @version 1.0.0
 * @since 2019. 4. 4.
 */
@FeignClient( name = "item-service-api" )
public interface ItemClient {

  
}
