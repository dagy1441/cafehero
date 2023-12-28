package com.dagy.cafeheroapi.configuration.configurer;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.springframework.security.core.context.SecurityContextHolder.getContext;

/*
implémentation de l'interface AuditorAware<T> de Spring Data JPA.
 Cette interface est utilisée pour obtenir l'identifiant de l'utilisateur courant qui
 effectue une opération CRUD (Create, Read, Update, Delete) sur une entité persistante.
  Dans notre cas, l'identifiant de l'utilisateur est de type String.
*/
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String username = getContext().getAuthentication() != null ? getContext().getAuthentication().getName() : "";
        return ofNullable(username).filter(s -> !s.isEmpty());
    }

}