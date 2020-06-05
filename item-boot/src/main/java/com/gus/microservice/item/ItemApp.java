/*===================================================================================
 *                    Copyright(c) 2019 Gus
 *
 * Project            : item-boot
 * Source File Name   : com.gus.microservice.item.ItemApp.java
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
package com.gus.microservice.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ItemApp {

    public static void main( String[] args ) {
//        for(String arg : args) {
//            System.out.println("args : " + arg);
//        }
//        Logger logger = LogManager.getLogger("DEVELOPER_LOG");

        SpringApplication.run( ItemApp.class, args );
    }

}
