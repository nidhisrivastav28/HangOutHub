// package com.hangouthub.hangouthub.controllers;

// import java.lang.reflect.AccessFlag.Location;
// import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RequestAttribute;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.hangouthub.hangouthub.repository.LocationRepository;

// @RestController
// @RequestMapping("/plan")
// public class PlanController {
//     // @Autowired
//     private LocationRepository locationRepo;

//     @Autowired
//     private PlaceRepository placeRepo;

//     @PostMapping("/searchByLocation")
//     public List<Place> searchByLocation(@RequestBody Map<String, Double> payload){
//         Double latitude = payload.get("latitude");
//         Double longitude = payload.get("longitude");
        
//         Location loc = locationRepo.findByLatAndLong(latitude, longitude);

//         if (loc == null) {
//             return new ArrayList<>();
//         }

//         return placeRepo.findByLocationId(loc.getId());
//     }
    
    
// }