package org.example.exercice03_springwebflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ErrorHandlingController {

    @GetMapping("/api/error-resume")
    public Flux<String> errorResume() {
        return Flux.just("A", "B", "C", "D", "E")
                .map(value -> {
                    if ("C".equals(value)) {
                        throw new RuntimeException("Erreur: "+value);
                    }
                    return value+"\n";
                })
                .onErrorResume(e -> Flux.just("Default 1\n", "Default 2"));
    }

    @GetMapping("/api/error-continue")
    public Flux<Integer> errorContinue(){
        return Flux.range(1, 5)
                .map(v -> {
                    if(v == 2){
                        throw new RuntimeException("Erreur : "+v);
                    }
                    return v;
                })
                .onErrorContinue((e, value) -> {
                    System.err.println("Erreur avec : "+value+" "+e.getMessage());
                });
    }


}
