package com.sensorproject.SensoringMonitoring.Controller;

import com.sensorproject.SensoringMonitoring.Model.auth.JWTRequest;
import com.sensorproject.SensoringMonitoring.Model.auth.JWTResponse;
import com.sensorproject.SensoringMonitoring.Model.auth.Userdata;
import com.sensorproject.SensoringMonitoring.Repository.auth.UserdataRepository;
import com.sensorproject.SensoringMonitoring.Service.auth.UserService;
import com.sensorproject.SensoringMonitoring.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
public class AuthController {

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private UserdataRepository userdataRepository;

    @GetMapping("/")
    public String home() {
        return "welcome to home site";
    }
    @GetMapping("/listofdata")
    public List<Userdata> data(@RequestHeader HttpHeaders headers) {
        String token = headers.get("Authorization").get(0).substring(7);
        String username = jwtUtility.getUsernameFromToken(token);
        List<Userdata> userdataList =  userdataRepository.findAllByUsername(username);
        return userdataList;
    }

    @PostMapping("/authenticate")
    public JWTResponse authenticate(@RequestBody JWTRequest jwtRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = userService.loadUserByUsername(jwtRequest.getUsername());

        final String token =
                jwtUtility.generateToken(userDetails);

        return  new JWTResponse(token);
    }
}
