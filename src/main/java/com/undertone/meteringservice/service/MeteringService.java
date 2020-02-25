package com.undertone.meteringservice.service;

import com.undertone.metering.MeteringRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MeteringService {


  public boolean saveImpression(MeteringRequest request) {
    return true;
  }

}
