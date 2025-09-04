// package com.hangouthub.hangouthub.controllers;

// import com.hangouthub.hangouthub.models.Locations;
// import java.util.*;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestAttribute;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.hangouthub.hangouthub.models.Places;
// import com.hangouthub.hangouthub.repository.LocationRepository;
// import com.hangouthub.hangouthub.repository.PlaceRepository;

// @RestController
// @RequestMapping("/plan")
// public class PlanController {
//     // @Autowired
//     private LocationRepository locationRepo;

//     @Autowired
//     private PlaceRepository placeRepo;

//     @PostMapping
//     public List<Places> searchByLocations(@RequestBody Map<String, Double> payload){
//         Double latitude = payload.get("latitude");
//         Double longitude = payload.get("longitude");
        
//         Optional<Locations> loc = locationRepo.findByLatitudeAndLongitude(latitude, longitude);

//         if (loc.isEmpty()) {
//             return new ArrayList<>();
//         }

//         Locations locOpt = loc.get();

//         return placeRepo.findByLocations(locOpt);
//     }
// }