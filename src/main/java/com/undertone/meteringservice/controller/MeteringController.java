package com.undertone.meteringservice.controller;

import com.undertone.metering.MeteringRequest;
import com.undertone.meteringservice.service.MeteringService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MeteringController {

  @Autowired
  private MeteringService meteringService;

  @PostMapping("/event")
  public boolean ipToGeo(@RequestBody MeteringRequest request) {
    return meteringService.saveImpression(request);
  }


}
