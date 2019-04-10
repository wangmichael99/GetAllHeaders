/**
 * 
 */
package com.wxl.getAllHeaders.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wxl.getAllHeaders.rest.model.RequestModel;

/**
 * @author Michael_Wang
 *
 */
@RestController("/")
public class GetAllHeadersController {
    final static Logger logger = LoggerFactory.getLogger(GetAllHeadersController.class);

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<RequestModel> GetResponse(@RequestHeader MultiValueMap<String, String> headers) {

        RequestModel rm = new RequestModel();

        rm.setReqHeader(headers.toString());

        logger.info("##########Header START#############");
        for (String headerName : headers.keySet()) {
            logger.info(headerName + ":" + headers.get(headerName));

        }
        logger.info("##########Header END###############");
        return new ResponseEntity<RequestModel>(rm, HttpStatus.OK);

    }

}
