package com.example.security.securitydbexample.Controller;

import com.example.security.securitydbexample.jwt.JwtUtils;
import com.example.security.securitydbexample.models.ERole;
import com.example.security.securitydbexample.models.Role;
import com.example.security.securitydbexample.models.User;
import com.example.security.securitydbexample.repository.RoleRepository;
import com.example.security.securitydbexample.repository.UserRepository;
import com.example.security.securitydbexample.request.LoginRequest;
import com.example.security.securitydbexample.request.SignUpRequest;
import com.example.security.securitydbexample.response.JwtResponse;
import com.example.security.securitydbexample.response.MessageResponse;
import com.example.security.securitydbexample.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    @CrossOrigin(origins = "*")

    public ResponseEntity<?> authenticateuser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    @CrossOrigin(origins = "*")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

    if(userRepository.existsByEmail(signUpRequest.getEmail())){
        return ResponseEntity.badRequest().body(new MessageResponse("Error:Email already exist!"));
    }
    User user=new User(signUpRequest.getUsername(),signUpRequest.getEmail(),passwordEncoder.encode(signUpRequest.getPassword()));
    Set<String> strRoles=signUpRequest.getRoles();
    Set<Role> roles=new HashSet<>();
    if(strRoles==null){
        Role userRole=roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(()->new RuntimeException("Error:Role is not found"));
        roles.add(userRole);
    }  else {
        strRoles.forEach(role -> {
            switch (role) {
                case "ROLE_ADMIN":
                    Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);

                    break;
                case "ROLE_MANAGEMENT":
                    Role managementRole = roleRepository.findByName(ERole.ROLE_MANAGEMENT)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(managementRole);

                    break;
                default:
                    Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
            }
        });
    }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/get_roles", method = RequestMethod.GET)
    public List<Role> get_roles() {
        return roleRepository.findAll();
    }




//    @GetMapping("/logout")
//    public String getLogoutPage(HttpServletRequest request, HttpServletResponse response){
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null)
//            new SecurityContextLogoutHandler().logout(request, response, authentication);
//
//        return "logout succesfull";
//    }
//@CrossOrigin(origins = "*")
//@GetMapping("/logout")
//public String getLogoutPage(HttpServletRequest request, HttpServletResponse response){
//
//    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//    if (authentication != null)
//        new SecurityContextLogoutHandler().logout(request, response, authentication);
//
//    return "logout succesfull";
//}


}