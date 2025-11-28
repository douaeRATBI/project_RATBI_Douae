package org.formation.cashsimplify.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class VirementAspect {

    @Before("execution(* org.formation.cashsimplify.service.CompteServiceImpl.effectuerVirement(..))")
    public void logVirement() {
        log.info(">>> VIREMENT : opération de virement en cours");
    }
}
