// package com.maftouhi.customerservice.Controllers;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.cloud.context.config.annotation.RefreshScope;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// import java.util.Map;

// @RestController
// @RefreshScope
// public class ConfigTestController {
//     @Value("${customer.params.x}")
//     private int x;

//     @GetMapping("/testconfig")
//     public Map<String,Integer> configtest(){
//         return Map.of(" X ",x);
//     }
// }
